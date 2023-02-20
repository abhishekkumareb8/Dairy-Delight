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

import com.ty.Dairy.Delight.dto.Vendor;
import com.ty.Dairy.Delight.service.VendorService;
import com.ty.Dairy.Delight.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("vendor")
public class VendorController {

	@Autowired
	private VendorService service;

	//SAVE VENDOR DETAILS//
	
//	@ApiOperation(value = "Save Vendor", notes = "It is used to save Vendor details")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
//			@ApiResponse(code = 500, message = "Internal server Error"),
//			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "ok"),
//			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
//	(consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_ATOM_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(@RequestBody Vendor vendor) {
		return service.saveVendor(vendor);
	}

	//UPDATE VENDOR DETAILS//
	
//	@ApiOperation(value = "Update Vendor", notes = "Uses to update Vendor details")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
//			@ApiResponse(code = 500, message = "Internal server error"),
//			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 403, message = "Forbidden"),
//			@ApiResponse(code = 405, message = "Method Not Allowed") })
//	(produces = MediaType.APPLICATION_JSON_VALUE, consumes = { MediaType.APPLICATION_JSON_VALUE,
//			MediaType.APPLICATION_ATOM_XML_VALUE })
	@PutMapping
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(@RequestBody Vendor vendor, @RequestParam int id) {
		return service.updateVendor(vendor, id);
	}

	//GET VENDOR DETAILS//
	
//	@ApiOperation(value = "Get Vendor", notes = "Get Vendor Details by id")
//	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
//			@ApiResponse(code = 500, message = "Internal server error"),
//			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "Ok"),
//			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 405, message = "Method Not Allowed") })
//	(produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping
	public ResponseEntity<ResponseStructure<Vendor>> getVendor(@RequestParam int id) {
		return service.getVendor(id);
	}

	//DELETE VENDOR //
	
//	@ApiOperation(value = "Delete Vendor", notes = "Use to delete Vendoe By given Id")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Created"),
//			@ApiResponse(code = 404, message = "Not found"),
//			@ApiResponse(code = 500, message = "Internal server error"),
//			@ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 403, message = "Method Not Allowed") })
//	(produces = MediaType.APPLICATION_JSON_VALUE)
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(@RequestParam int id) {
		return service.deleteVendor(id);
	}
}
