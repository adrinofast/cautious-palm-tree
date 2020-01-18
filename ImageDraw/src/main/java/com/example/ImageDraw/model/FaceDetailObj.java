package com.example.ImageDraw.model;

import org.springframework.stereotype.Component;

@Component
public class FaceDetailObj {
	
	private String encodedImageContent;
	private String ageRange;
	private String gender;
	private String emotion;
	private boolean eyeGlasses;
	private String name;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEncodedImageContent() {
		return encodedImageContent;
	}
	public void setEncodedImageContent(String encodedImageContent) {
		this.encodedImageContent = encodedImageContent;
	}
	public String getAgeRange() {
		return ageRange;
	}
	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public boolean isEyeGlasses() {
		return eyeGlasses;
	}
	public void setEyeGlasses(boolean eyeGlasses) {
		this.eyeGlasses = eyeGlasses;
	}
	@Override
	public String toString() {
		return "FaceDetailObj [encodedImageContent=" + encodedImageContent + ", ageRange=" + ageRange + ", gender="
				+ gender + ", emotion=" + emotion + ", eyeGlasses=" + eyeGlasses + ", name=" + name + "]";
	}
	
	
	
	
	

}
