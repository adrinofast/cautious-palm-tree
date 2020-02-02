package com.example.ImageDraw.controller;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.ImageDraw.service.*;
import com.example.ImageDraw.model.FaceDetailObj;
import com.example.ImageDraw.model.FaceSearchObj;
import com.example.ImageDraw.model.Student;
import com.example.ImageDraw.service.ImageDrawService;
import com.example.ImageDraw.serviceImpl.ExtractImages;
import com.example.ImageDraw.serviceImpl.ImageDawServiceImpl;


import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DetectLabels {
	
	private static final  org.slf4j.Logger LOGGER =  LoggerFactory.getLogger(DetectLabels.class);
	
	@Autowired
	ExtractImages extImg;
	
	@Autowired
	ImageDawServiceImpl  imageDrawServImple;
	
	@Autowired
	ImageDrawService    imageDetectService;
	
	@Autowired
	ImageSearchService   imageSearchService;

	
	@RequestMapping(value="/home" , method = RequestMethod.GET)
	public Student getSample()
	{
		Student dt = new Student();
		dt.setId("23");
		dt.setName("phaniiiiii");	
		return dt;
	}
	
	@RequestMapping(value="/detectMe", method = RequestMethod.POST)
	public ResponseEntity<List<FaceDetailObj>> detectFaces(@RequestPart(value = "file") MultipartFile file , @RequestPart(value = "fileName") String name) throws IOException
	{
		//imageDrawServImple.createCollection("facesDetected");
		LOGGER.info("Inside the Detect faces Function");
		//ImageDawServiceImpl imd = new ImageDawServiceImpl();
		String filestName = name;
		
		extImg.upLoadFIletos3(file, filestName);
		//List<FaceDetailObj>  facedetailss =null;
		List<FaceDetailObj> facedetailss =imageDetectService.detectFaces(file, filestName);
		
		return new ResponseEntity<List<FaceDetailObj>>(facedetailss,HttpStatus.OK);
	}
	

	
	@RequestMapping(value="/searchFaces", method = RequestMethod.POST)
	public ResponseEntity<List<FaceSearchObj>> searchFaces(@RequestPart(value = "file") MultipartFile file , @RequestPart(value = "fileName") String name) throws IOException
	{
		//imageDrawServImple.deleteCollection("facesDetected");
		LOGGER.info("Inside the Search faces Function");
		ImageDawServiceImpl imd = new ImageDawServiceImpl();
		String filestName = name;
		
		extImg.upLoadFIletos3(file, filestName);
		imageDrawServImple.indexFaces(file, filestName);
		//List<FaceDetailObj>  facedetailss =null;
		//List<FaceDetailObj> facedetailss =imd.searchFaces(file, filestName);
		List<FaceSearchObj> facedetailsFound = imageSearchService.searchFaces(file, filestName);
		
		//List<FaceDetailObj> facedetailsFound = imd.searchFaces(file, filestName);
		
		return new ResponseEntity<List<FaceSearchObj>>(facedetailsFound,HttpStatus.OK);
	}
	
	@RequestMapping(value="/createCollection" ,method=RequestMethod.POST)
	public void createCollection()
	{
		imageDrawServImple.deleteCollection("facesDetected");
	}
	
	
	@RequestMapping(value="/deleteCollection" ,method=RequestMethod.POST)
	public void deleteCollection()
	{
		imageDrawServImple.createCollection("facesDetected");
	}
	
	@RequestMapping(value="/getimages" ,method=RequestMethod.GET)
	public ResponseEntity<List<String>> ing() throws IOException
	{
		List<String> images = new ArrayList<String>();
		
		String imgPath = "F:\\Workspace\\ImageDraw\\37262448_2108128606093009_4251185318507577344_n.jpg";
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
		return new ResponseEntity<List<String>>(images,HttpStatus.OK);
	}
	
	public void writeimage(String str) throws IOException
	
	{
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(str);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
		String path ="D:\\streamsytes\\";
		ImageIO.write(img, "jpg", new File(path + "img__CROP_bb.jpg"));		
	}

}
	