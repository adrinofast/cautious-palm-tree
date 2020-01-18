package com.example.ImageDraw.serviceImpl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.amazonaws.services.rekognition.model.*;
import com.example.ImageDraw.model.FaceDetailObj;


public class BoundingBoxDrawer {
	
	public String dirPath="";
	List<FaceDetailObj>  faceDetalList = new ArrayList<FaceDetailObj>();
	
	public  List<FaceDetailObj> drawBoundingBoxes(byte[] bytes, DetectFacesResult result, String fileName) throws IOException {
	    int width;
	    int height;
	    BufferedImage img;
	    List<String> facesCroped = null;
	    //dirPath = "F:\\Workspace\\ImageDraw\\" + fileName;
	    dirPath = "F:\\ResultsImag\\" + fileName;
	    
	    File direto = new File(dirPath);
	    
	    Graphics2D graphics;
	    try {
	        img = ImageIO.read(new ByteArrayInputStream(bytes));
	        width = img.getWidth();
	        height = img.getHeight();
	        graphics = img.createGraphics();
	    } catch (IOException e) {
	        System.err.println("Failed to read image: " + e.getLocalizedMessage());
	        return faceDetalList;
	    }
	    System.out.println("Image: width=" + width + ", height=" + height);
	 
	    String orientationCorrection = result.getOrientationCorrection();
	    System.out.println("Orientation correction: " + orientationCorrection);
	    System.out.println("Creating the Diretory");
	    
	    if(!direto.exists())
	    {
	    	direto.mkdir();
	    }
	    
	    List<FaceDetail> faceDetails = result.getFaceDetails();	
	    for (FaceDetail faceDetail : faceDetails) {	
	    	
	    
	        drawBoundingBox(faceDetail, orientationCorrection, width, height, graphics);
	        cropFace(img,faceDetail,width, height, fileName);
	        
	        String cropImageName = fileName + faceDetail.hashCode() + "img__CROP_bb.jpg";
	        
	        System.out.println("imahe ame cropped"+ "" + cropImageName);
	        System.out.println("path"+ " "+ dirPath);
	        
	        String encodedImgContent = generateBase64(cropImageName, dirPath);
	        
	        System.out.println("encoded string" +" " +  encodedImgContent);
	        
	        FaceDetailObj fdo = new FaceDetailObj();
	        
	        fdo.setAgeRange(faceDetail.getAgeRange().toString());
	        
	        HashMap<String,Float> hmapEmotions =new HashMap<String,Float>();
	        
	        
	        for(Emotion emo : faceDetail.getEmotions())
	        {
	        	hmapEmotions.put(emo.getType(), emo.getConfidence());
	        }
	        
	        maxvalue(hmapEmotions).toString();
	        //fdo.setEmotion(faceDetail.getEmotions().toString());
	        fdo.setEmotion(maxvalue(hmapEmotions).toString());
	        fdo.setGender(faceDetail.getGender().getValue());
	        fdo.setEyeGlasses(faceDetail.getEyeglasses().getValue());
	        fdo.setEncodedImageContent(encodedImgContent);
	        fdo.setName(cropImageName);
//	        
//	        System.out.println("age arange" + "" + faceDetail.getAgeRange().toString());
//	        System.out.println("gender arange" + "" + faceDetail.getGender().getValue());
//	        System.out.println("age emotion " + "" + faceDetail.getEmotions().toString());
//	        System.out.println("age glasses" + "" + faceDetail.getEyeglasses().toString());
	        
	        faceDetalList.add(fdo);
	        System.out.println(fdo.toString());
	    
	    }
	 
	    try {
	    	System.out.println("writing image");
	
	    	if(direto.exists())
	    	{
	          ImageIO.write(img, "jpg", new File( dirPath + "\\"+ fileName + ".jpg"));
            }
	        
	    } catch (IOException e) {
	        System.err.println("Failed to write image: " + e.getLocalizedMessage());
	    }
	    
	    System.out.println(faceDetalList.toString());
	   facesCroped = ing(dirPath);
	    //return facesCroped;
	   
	   return faceDetalList;
	}
	 
//	private void drawBoundingBox1(FaceDetail faceDetail, String orientationCorrection, int width, int height,
//	        Graphics2D graphics) {
//	 
//	    BoundingBox bb = faceDetail.getBoundingBox();
//	    BoundingBox cbb = convertBoundingBox(bb, orientationCorrection, width, height);
//	    if (cbb == null) {
//	        return;
//	    }
//	 
//	    graphics.setColor(Color.RED);
//	    graphics.setStroke(new BasicStroke(10));
//	    System.out.println("wrting box");
//	    System.out.println(cbb.getLeft().intValue() + "" +cbb.getTop().intValue() + "" +cbb.getWidth().intValue() + "" +  cbb.getHeight().intValue() );
//	    graphics.drawRect(cbb.getLeft().intValue(), cbb.getTop().intValue(),
//	            cbb.getWidth().intValue(), cbb.getHeight().intValue());
//	}
	
	private void drawBoundingBox(FaceDetail faceDetail, String orientationCorrection, int width, int height,
	        Graphics2D graphics) {
	 
	    BoundingBox bb = faceDetail.getBoundingBox();
//	    BoundingBox cbb = convertBoundingBox(bb, orientationCorrection, width, height);
//	    if (cbb == null) {
//	        return;
//	    }
	 
	    graphics.setColor(Color.BLUE);
	    graphics.setStroke(new BasicStroke(5));
	    System.out.println("wrting box");
	   
//	    graphics.drawRect(cbb.getLeft().intValue(), cbb.getTop().intValue(),
//	            cbb.getWidth().intValue(), cbb.getHeight().intValue());
	    
	    float left = width*bb.getLeft();
	    float top = height*bb.getTop();
	    	int scale =1;	
	    
	    System.out.println("left = " + left + "top = " + top);	
	    if(Math.round(left) < 0 )
	    {
	    	 left = (float) 0.01;
	    	 System.out.println("changinf the left vlus");
	    	 System.out.println(left);
	    }
	    	
	    graphics.drawRect(Math.round(left / scale), Math.round(top / scale), Math.round((width*bb.getWidth())/scale), Math.round((height*bb.getHeight())/scale));
	}
	
	
	
	
	private BoundingBox convertBoundingBox(BoundingBox bb, String orientationCorrection, int width, int height) {
	    if (orientationCorrection == null) {
	        System.out.println("No orientationCorrection available.");
	        return null;
	    } else {
	        float left = -1;
	        float top = -1;
//	        switch (orientationCorrection) {
//	        case "ROTATE_0":
//	            left = width * bb.getLeft();
//	            top = height * bb.getTop();
//	            break;
//	        case "ROTATE_90":
//	            left = height * (1 - (bb.getTop() + bb.getHeight()));
//	            top = width * bb.getLeft();
//	            break;
//	        case "ROTATE_180":
//	            left = width - (width * (bb.getLeft() + bb.getWidth()));
//	            top = height * (1 - (bb.getTop() + bb.getHeight()));
//	            break;
//	        case "ROTATE_270":
//	            left = height * bb.getTop();
//	            top = width * (1 - bb.getLeft() - bb.getWidth());
//	            break;
//	        default:
//	            System.out.println("Orientation correction not supported: " +
//	                    orientationCorrection);
	            return null;
	        }
	    }
	
	private void cropFace(BufferedImage img, FaceDetail faceDetail, int width, int height, String fName)
	{
		 BoundingBox bbo = faceDetail.getBoundingBox();
		 
		 File savePath = new File(dirPath);
		 float left = Math.abs(width*bbo.getLeft());
		    float top = height*bbo.getTop();
		    	int scale = 1;		
		    	String imageSave = dirPath + "\\" + fName;
		    	
		    	File savingPath = new File(imageSave);
		    	if(!savingPath.exists())
		    	{
		    		System.out.println("i am in creating d");
		    		savingPath.mkdir();
		    	}
		    	
		 BufferedImage cropedImg = img.getSubimage(Math.round(left / scale), Math.round(top / scale), Math.round((width*bbo.getWidth())/scale), Math.round((height*bbo.getHeight())/scale));
		 
		 try {
		    	System.out.println("writing Cropped  image");
		    	
		    	if(savePath.exists())
		    	{
		    		 ImageIO.write(cropedImg, "jpg", new File( imageSave + faceDetail.hashCode() + "img__CROP_bb.jpg"));
		    	}
		       
		    } catch (IOException e) {
		        System.err.println("Failed to write image: " + e.getLocalizedMessage());
		    }
		 
	}
	
	public  List<String> ing(String imgPath) throws IOException
	{
		List<String> images = new ArrayList<String>();
		
		//String imgPath = "F:\\Workspace\\ImageDraw\\37262448_2108128606093009_4251185318507577344_n.jpg";
		File flDis = new File(imgPath);
		if(flDis != null)
		{
			
			for(final File file :flDis.listFiles() )
			{
				String encodeBase64 = null;
				
					try {
						FileInputStream fileInputStream = new FileInputStream(file);
						byte[] imgContent = new byte[((int)file.length())];
						fileInputStream.read(imgContent);
						encodeBase64 =Base64.getEncoder().encodeToString(imgContent);
						
						//writeimage(encodeBase64);
						//images.add("data:image/jpg"+":base64,"+encodeBase64);
						images.add(encodeBase64);
						fileInputStream.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
						
				}
				
		}
		//return new ResponseEntity<List<String>>(images,HttpStatus.OK);
		return images;
	}
	
	
	public String generateBase64(String fileName ,String filePath) throws IOException
	{
		String encodedImg = null;
		
		File filePathObj = new File(filePath);
		for(final File file :filePathObj.listFiles() )
		{
			if(file.getName().equals(fileName))
			{
			
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					byte[] imgContent = new byte[((int)file.length())];
					fileInputStream.read(imgContent);
					encodedImg =Base64.getEncoder().encodeToString(imgContent);
					
					//writeimage(encodeBase64);
					//images.add("data:image/jpg"+":base64,"+encodeBase64);
					//images.add(encodeBase64);
					fileInputStream.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return encodedImg;
		
	}
	
	public static <K, V extends Comparable<V>> Entry<K, V> maxvalue(Map<K, V> map) {
	    Map.Entry<K, V> maxEntry = null;
	    for (Map.Entry<K, V> entry : map.entrySet()) {
	        if (maxEntry == null || entry.getValue()
	            .compareTo(maxEntry.getValue()) > 0) {
	            maxEntry = entry;
	        }
	    }
	    return maxEntry;
	}
	}
	




