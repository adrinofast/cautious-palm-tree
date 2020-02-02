package com.example.ImageDraw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.ImageDraw.model.FaceDetailObj;

@Component
public interface ImageDrawService {
	
	List<FaceDetailObj> detectFaces(MultipartFile file, String name) throws IOException;
	


}
