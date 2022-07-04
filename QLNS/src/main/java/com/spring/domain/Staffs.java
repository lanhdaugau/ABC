package com.spring.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staffs")
public class Staffs implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	@Column(name = "full_name",
			columnDefinition = "nvarchar(200) not null")
	private String fullName;
	
	@Column(name = "birthday",
			columnDefinition = "nvarchar(200) not null")
	private String dateBirthday;
	
	@Column(name = "gender")	
	private boolean gender;
	@Column(name = "address",
			columnDefinition = "nvarchar(200) not null")
	private String address;
	
	@Column(name = "phone_number",
			columnDefinition = "varchar(20) not null")
	private String phoneNumber;
	
	@Column(name = "email",
			columnDefinition = "nvarchar(200) not null")
	private String email;

	@Column(name = "image_url",
			columnDefinition = "nvarchar(300) not null")
	private String imageUrl;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departId")
	private Departs departs;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="staffs")
	private Set<Records> records;
}
