package com.ty.Dairy.Delight.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Factors {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float  fat;
	private float snf;
	private float liters;
	private Date date;

}
