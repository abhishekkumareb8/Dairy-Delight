package com.ty.Dairy.Delight.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Factors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float  fat;
	private float snf;
	private float liters;
	private Date date;

}
