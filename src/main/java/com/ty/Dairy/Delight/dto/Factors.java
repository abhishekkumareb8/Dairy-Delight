package com.ty.Dairy.Delight.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Factors {

	@Id
	private int id;
	private float fat;
	private float SNF;
	private float Liters;

}
