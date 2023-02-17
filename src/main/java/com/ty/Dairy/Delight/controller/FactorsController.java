package com.ty.Dairy.Delight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Dairy.Delight.dto.Factors;
import com.ty.Dairy.Delight.service.FactorsService;
import com.ty.Dairy.Delight.util.ResponseStructure;

@RestController
@RequestMapping("factors")
public class FactorsController {

	@Autowired
	FactorsService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Factors>> saveFactors(@RequestBody Factors factors) {
		return service.saveFactorsService(factors);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Factors>> updateFactors(@RequestBody Factors factors,@RequestParam int factorsid) {
		return service.updateFactorsService(factors, factorsid);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Factors>> findFactorsById(@RequestParam int factorsid) {
		return service.findFactorsByIdService(factorsid);
	}

	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Factors>> deleteFactorsById(@RequestParam int factorsid) {
		return service.deleteFactorsById(factorsid);
	}
}
