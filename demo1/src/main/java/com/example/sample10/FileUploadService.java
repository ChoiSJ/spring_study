package com.example.sample10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("uploadService")
public class FileUploadService {
	
	@Value("${upload.maxSize}")
	private int maxSize;
	@Value("${upload.maxFileAmount}")
	private int maxAmount;
	@Value("${upload.directory}")
	private String directory;
	
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	public void displayUploadConf() {
		System.out.println("최대 사이즈:" + maxSize);
		System.out.println("최대 갯수:" + maxAmount);
		System.out.println("업로드 폴더:" + directory);
	}
}
