package com.spring.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class ImageUploadController {
	@GetMapping("getimage/{image}")
	@ResponseBody
	public ResponseEntity<ByteArrayResource> getImage(@PathVariable("image") String image){
		if(!image.equals("") ||image != null) {
			try {
				Path filename= Paths.get("C:/Users/Admin/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/QLNS/src/main/webapp/images",image);
				byte[] buffer =Files.readAllBytes(filename);
				ByteArrayResource byteArrayResource = new ByteArrayResource(buffer);
				System.out.println(filename);
				return ResponseEntity.ok()
						.contentLength(buffer.length)
						.contentType(MediaType.parseMediaType("image/jpg"))
						.contentType(MediaType.parseMediaType("image/png"))
						.body(byteArrayResource);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ResponseEntity.badRequest().build();
		
	}
	
	
}
