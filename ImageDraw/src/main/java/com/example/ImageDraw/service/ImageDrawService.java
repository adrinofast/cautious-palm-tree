package com.example.ImageDraw.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ImageDrawService {
	
	List<String> detectFaces(MultipartFile file, String name) throws IOException;
	


}
