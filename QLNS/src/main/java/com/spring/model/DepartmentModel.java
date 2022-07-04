package com.spring.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel implements Serializable {

	private String idDepart;

	private String nameDepart;

	private String numberPhone;
	
	
}
