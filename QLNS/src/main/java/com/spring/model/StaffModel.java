package com.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.spring.domain.Departs;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StaffModel implements Serializable {
	
	private Long staffId;
	@NotEmpty
	@Length(min=3)
	private String fullName;
	@NotEmpty
	private String dateBirthday;

	private boolean gender;
	@NotEmpty	
	private String address;
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	private String email;
	
	
	private MultipartFile image;
	private String imageUrl;
	private Departs departs;

}
