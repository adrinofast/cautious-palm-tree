package com.example.ImageDraw.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.util.IOUtils;

@Component
public class ExtractImages {
	
	

	public void upLoadFIletos3(MultipartFile file,String fileName) throws IOException {
		
		String bucketName ="aws-upload-face-regos1";
		AWSCredentials credentials = new BasicAWSCredentials("AKIA6I6BWDAVB2O4B5FK","2p/MoNhCijGFpk/tr1cSrQKtUu7uugYPtWtkqlTS");
		
		AmazonS3 s3client = AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		 System.out.println("hello i am uploading");
		 
		 File convertedFile = ExtractImages.convert(file);
		 s3client.putObject(bucketName,fileName,convertedFile);
		
	}
	
	public static File convert(MultipartFile file) throws IOException {
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos2 = new FileOutputStream(convFile);
	    fos2.write(file.getBytes());
	    fos2.close();
	    return convFile;
	}

	

}
