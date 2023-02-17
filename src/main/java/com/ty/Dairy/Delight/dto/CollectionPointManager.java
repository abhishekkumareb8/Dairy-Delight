package com.ty.Dairy.Delight.dto;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	

