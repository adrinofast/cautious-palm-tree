package com.example.ImageDraw.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.ImageDraw.controller.DetectLabels;
import com.example.ImageDraw.model.ClientFactory;
import com.example.ImageDraw.model.FaceDetailObj;
import com.example.ImageDraw.service.ImageDrawService;

@Component
public class ImageDawServiceImpl implements ImageDrawService {
	
	private static final  org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(DetectLabels.class);
		
	@Autowired
	FaceDetailObj facedetail ;
	List<FaceDetailObj>  fceDets =null;
	 String collectionName = "facesDetected";
	@Override
	public  List<FaceDetailObj> detectFaces(MultipartFile file, String fileName) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> facesCroped =null;
		byte[] bytes;
		 try {
		        bytes = file.getBytes();
		    } catch (IOException e) {
		        System.err.println("Failed to load image: " + e.getMessage());
		        return fceDets;
		    }
		 ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		 
		    AmazonRekognition rekognition = ClientFactory.createClient();
		    
		    ListCollectionsRequest lcRequest = new ListCollectionsRequest();

            ListCollectionsResult lcResult = rekognition.listCollections(lcRequest);
           
            DescribeCollectionRequest dcRequest = new DescribeCollectionRequest()
                    .withCollectionId(collectionName);
            
            DescribeCollectionResult dcResult = rekognition.describeCollection(dcRequest);
            
            System.out.println(dcResult.toString());
            
            boolean collectionExists = false;
            for(String collection :lcResult.getCollectionIds() )
            {
            	System.out.println("the collecyion name is " + " " + collection);
            	if(collection.equals(collectionName))
            	{
            		collectionExists = true;
            		break;
            	}
            }
		    
		    if(collectionExists == false)
		    {
		    	CreateCollectionRequest  ccRequest = new CreateCollectionRequest().withCollectionId(collectionName);
		    	CreateCollectionResult ccResult = rekognition.createCollection(ccRequest);
		    	System.out.println("*********  Creating Collection Response***********");
		    	System.out.println(ccResult.getCollectionArn());
		    	System.out.println(ccResult.getStatusCode());
		    }	
		    
		 
		    DetectFacesRequest request = new DetectFacesRequest()
		            .withImage(new Image().withBytes(byteBuffer))
		            .withAttributes(Attribute.ALL);
		    DetectFacesResult result = rekognition.detectFaces(request);
		 
		    IndexFacesRequest indexFacesRequest = new IndexFacesRequest()
	                .withImage(new Image().withBytes(byteBuffer))
	                
	                .withCollectionId(collectionName)
	                .withExternalImageId(fileName)
	                .withDetectionAttributes("DEFAULT");

	        IndexFacesResult indexFacesResult = rekognition.indexFaces(indexFacesRequest);
	        
	        
		    String orientationCorrection = result.getOrientationCorrection();
		    System.out.println("Orientation correction: " + orientationCorrection);
		    
		    //System.out.println(result.toString());
		 
		    List<FaceDetail> faceDetails = result.getFaceDetails();
		    List<BoundingBox> boundingBoxes = new ArrayList<BoundingBox>(faceDetails.size());
		    
		    for (FaceDetail faceDetail : faceDetails) {
		 
		        printFaceDetails(faceDetail);
		    }
		    
		    BoundingBoxDrawer drawer = new BoundingBoxDrawer();
		       // drawer.drawBoundingBoxes(bytes, result.getOrientationCorrection(), boundingBoxes);
		    // facesCroped = drawer.drawBoundingBoxes(bytes, result,fileName );
		    fceDets = drawer.drawBoundingBoxes(bytes, result,fileName );
		    return fceDets;

	}
	
	
	private void printFaceDetails(FaceDetail faceDetail) {
	    System.out.println("###############");

	    AgeRange ageRange = faceDetail.getAgeRange();
	    System.out.println("Age range: " + ageRange.getLow() + "-" + ageRange.getHigh());
	 
	    Beard beard = faceDetail.getBeard();
	    System.out.println("Beard: " + beard.getValue() + "; confidence=" + beard.getConfidence());
	 
	    BoundingBox bb = faceDetail.getBoundingBox();
	    System.out.println("BoundingBox: left=" + bb.getLeft() +
	            ", top=" + bb.getTop() + ", width=" + bb.getWidth() +
	            ", height=" + bb.getHeight());
	 
	    Float confidence = faceDetail.getConfidence();
	    System.out.println("Confidence: " + confidence);
	 
	    List<Emotion> emotions = faceDetail.getEmotions();
	    for (Emotion emotion : emotions) {
	        System.out.println("Emotion: " + emotion.getType() +
	                "; confidence=" + emotion.getConfidence());
	    }
	 
	    Eyeglasses eyeglasses = faceDetail.getEyeglasses();
	    System.out.println("Eyeglasses: " + eyeglasses.getValue() +
	            "; confidence=" + eyeglasses.getConfidence());
	 
	    EyeOpen eyesOpen = faceDetail.getEyesOpen();
	    System.out.println("EyeOpen: " + eyesOpen.getValue() +
	            "; confidence=" + eyesOpen.getConfidence());
	 
	    Gender gender = faceDetail.getGender();
	    System.out.println("Gender: " + gender.getValue() +
	            "; confidence=" + gender.getConfidence());
	 
	    List<Landmark> landmarks = faceDetail.getLandmarks();
	    for (Landmark lm : landmarks) {
	        System.out.println("Landmark: " + lm.getType()
	            + ", x=" + lm.getX() + "; y=" + lm.getY());
	    }
	 
	    MouthOpen mouthOpen = faceDetail.getMouthOpen();
	    System.out.println("MouthOpen: " + mouthOpen.getValue() +
	            "; confidence=" + mouthOpen.getConfidence());
	 
	    Mustache mustache = faceDetail.getMustache();
	    System.out.println("Mustache: " + mustache.getValue() +
	            "; confidence=" + mustache.getConfidence());
	 
	    Pose pose = faceDetail.getPose();
	    System.out.println("Pose: pitch=" + pose.getPitch() +
	            "; roll=" + pose.getRoll() + "; yaw" + pose.getYaw());
	 
	    ImageQuality quality = faceDetail.getQuality();
	    System.out.println("Quality: brightness=" +
	            quality.getBrightness() + "; sharpness=" + quality.getSharpness());
	 
	    Smile smile = faceDetail.getSmile();
	    System.out.println("Smile: " + smile.getValue() +
	            "; confidence=" + smile.getConfidence());
	 
	    Sunglasses sunglasses = faceDetail.getSunglasses();
	    System.out.println("Sunglasses=" + sunglasses.getValue() +
	            "; confidence=" + sunglasses.getConfidence());
	 
	    System.out.println("###############");
	}
    
	
	public List<FaceDetailObj> searchFaces(MultipartFile file, String fileName)
	{
		List<FaceDetailObj>  faceDetalListFound = new ArrayList<FaceDetailObj>();
		byte[] imgbytes = null;
		 try {
			 imgbytes = file.getBytes();
		    } catch (IOException e) {
		        System.err.println("Failed to load image: " + e.getMessage());
		        
		    }
		
		 ByteBuffer byteBuffer = ByteBuffer.wrap(imgbytes);
		AmazonRekognition rekognition = ClientFactory.createClient();
		SearchFacesByImageRequest  sfiRequest = new SearchFacesByImageRequest().withCollectionId("facesDetected").withImage(new Image().withBytes(byteBuffer));
		
		SearchFacesByImageResult sfiResult = rekognition.searchFacesByImage(sfiRequest);
		List<FaceMatch> faceMatches = sfiResult.getFaceMatches();
		for(FaceMatch fm : faceMatches)
		{
			System.out.println("**********the confidence*******" + " " + fm.getFace().getConfidence());
			System.out.println(fm.getFace().getFaceId());
			System.out.println(fm.getFace().getImageId());
			System.out.println(fm.getFace().getExternalImageId());
			
			if(fm.getFace().getExternalImageId()==null )
			{
				
			}
			else
			{
				FaceDetailObj fdo = new FaceDetailObj();
				try {
					fdo.setEncodedImageContent(getS3ReferenceImage(fm.getFace().getExternalImageId()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				faceDetalListFound.add(fdo);
			}
			
			
		}
		
		System.out.println(faceDetalListFound.toString());
		return faceDetalListFound;
		
	}	
    
	
	public String getS3ReferenceImage(String keyName) throws IOException
	{  
		File tmp = null;
		String encodeBase64 = null;
		String bucketName ="aws-upload-face-regos1";
AWSCredentials credentials = new BasicAWSCredentials("AKIA6I6BWDAVB2O4B5FK","2p/MoNhCijGFpk/tr1cSrQKtUu7uugYPtWtkqlTS");
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		System.out.println("the client name s" + keyName);
		S3Object s3object = s3client.getObject(bucketName, keyName);
		S3ObjectInputStream inputStream = s3object.getObjectContent();
		
		tmp = File.createTempFile("s3test", ".jpeg");
        Files.copy(inputStream, tmp.toPath(), StandardCopyOption.REPLACE_EXISTING);
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        
        try {
            BufferedImage image = ImageIO.read(tmp);
            ImageIO.write(image, "jpeg", jpegOutputStream);
          } catch (IllegalArgumentException e) {
           // response.sendError(HttpServletResponse.SC_NOT_FOUND);
          }
          tmp.delete();
          byte[] imgByte = jpegOutputStream.toByteArray();

		
		//byte[] imgContent = new byte[inputStream.read(buffer)];
		encodeBase64 =Base64.getEncoder().encodeToString(imgByte);
		
		return encodeBase64;		
	}
	
	
	public void indexFaces(MultipartFile file, String fileName)
	{
		LOGGER.info("Inside the Index Faces Method");
		
		 AmazonRekognition rekognition = ClientFactory.createClient();
		 
		 byte[] bytes = null;
		 try {
		        bytes = file.getBytes();
		    } catch (IOException e) {
		        System.err.println("Failed to load image: " + e.getMessage());
		        
		    }
		 ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		 
		 IndexFacesRequest indexFacesRequest = new IndexFacesRequest()
	                .withImage(new Image().withBytes(byteBuffer))
	                
	                .withCollectionId(collectionName)
	                .withExternalImageId(fileName)
	                .withDetectionAttributes("DEFAULT");

	        IndexFacesResult indexFacesResult = rekognition.indexFaces(indexFacesRequest);
	        
	        
	        
		
	}

	public void deleteCollection(String collectionName)

	{
		 AmazonRekognition rekognition = ClientFactory.createClient();
		DeleteCollectionRequest request = new DeleteCollectionRequest()
		         .withCollectionId(collectionName);
		      DeleteCollectionResult deleteCollectionResult = rekognition.deleteCollection(request);        
		  
		   
		
	}
	
	public void createCollection(String collectionName)

	{
		 AmazonRekognition rekognition = ClientFactory.createClient();
		CreateCollectionRequest request = new CreateCollectionRequest()
		         .withCollectionId(collectionName);
		      CreateCollectionResult deleteCollectionResult = rekognition.createCollection(request);        
		  
		   
		
	}
	
	


}
