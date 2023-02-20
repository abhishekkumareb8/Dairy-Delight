package com.ty.Dairy.Delight.dto;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity
public class  CollectionPointManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String pointname;
	private String username;
	private String email;
	private String password;
	private String address;
	private long phone;
	
	@OneToMany
	private List<Vendor> vendor;

	}
	

