package com.spring.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "departs")
public class Departs implements Serializable{
	@Id
	@GeneratedValue
	private String id;
	@Column(name = "name_depart",
			columnDefinition = "nvarchar(100) not null")
	private String nameDepart;

	@OneToMany(fetch = FetchType.LAZY,mappedBy="departs")
	private List<Staffs> staffs;
}
