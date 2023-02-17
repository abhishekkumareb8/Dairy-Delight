package com.ty.Dairy.Delight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Dairy.Delight.dto.Vendor;
import com.ty.Dairy.Delight.service.VendorService;
import com.ty.Dairy.Delight.util.ResponseStructure;

@RestController
@RequestMapping("vendor")
public class VendorController {

	@Autowired
	private VendorService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(@RequestBody Vendor vendor) {
		return service.saveVendor(vendor);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@RequestBody Vendor vendor,@RequestParam int id){
		return service.updateVendor(vendor, id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Vendor>> getVendor(@RequestParam int id){
		return service.getVendor(id);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@RequestParam int id) {
		return service.deleteVendor(id);
	}
}
