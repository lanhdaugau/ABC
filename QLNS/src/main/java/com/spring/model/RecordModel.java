package com.spring.model;



import com.spring.domain.Staffs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordModel {
	
	private Integer id;
	
	private String reason;
	
	
	private String date;
	private Staffs staffs;
}
