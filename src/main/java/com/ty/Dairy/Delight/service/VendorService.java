package com.ty.Dairy.Delight.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Dairy.Delight.dao.VendorDao;
import com.ty.Dairy.Delight.dto.Vendor;
import com.ty.Dairy.Delight.exception.NoSuchIdFoundException;
import com.ty.Dairy.Delight.exception.UnableToUpdateException;
import com.ty.Dairy.Delight.util.ResponseStructure;

@Service
public class VendorService {

	@Autowired
	private VendorDao dao;

	// SAVE VENDOR DETAILS
	public ResponseEntity<ResponseStructure<Vendor>> saveVendor(Vendor vendor) {
		ResponseStructure<Vendor> responseStructure = new ResponseStructure<Vendor>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveVendor(vendor));
		responseStructure.setMessage("Vendor details saved");
		ResponseEntity<ResponseStructure<Vendor>> responseEntity = new ResponseEntity<ResponseStructure<Vendor>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	// GET VENDOR DETAILS
	public ResponseEntity<ResponseStructure<Vendor>> getVendor(int id) {
		Vendor optional = dao.getVendor(id);
		ResponseStructure<Vendor> responseStructure = new ResponseStructure<Vendor>();
		ResponseEntity<ResponseStructure<Vendor>> responseEntity = new ResponseEntity<ResponseStructure<Vendor>>(
				responseStructure, HttpStatus.OK);
		if (optional!=null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.getVendor(id));
			responseStructure.setMessage("User found");
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("No Such Id Found");
		}
	}
	
	//UPDATD VENDOR
	public ResponseEntity<ResponseStructure<Vendor>> updateVendor(Vendor vendor, int id) {
		Vendor optional = dao.getVendor(id);
		ResponseStructure<Vendor> responseStructure = new ResponseStructure<Vendor>();
		ResponseEntity<ResponseStructure<Vendor>> responseEntity = new ResponseEntity<ResponseStructure<Vendor>>(
				responseStructure, HttpStatus.OK);
		if(optional!=null) {
			vendor.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dao.updateVendor(vendor));
			responseStructure.setMessage("Vendor detail updated");
			return responseEntity;
		}else
		{
			throw new UnableToUpdateException("Unable to update details for given id");
		}
	}
	
	//DELETE VENDOR
	
	public ResponseEntity<ResponseStructure<Vendor>> deleteVendor(int id) {
		Vendor optional = dao.getVendor(id);
		ResponseStructure<Vendor> responseStructure = new ResponseStructure<Vendor>();
		ResponseEntity<ResponseStructure<Vendor>> responseEntity = new ResponseEntity<ResponseStructure<Vendor>>(
				responseStructure, HttpStatus.OK);
		if (optional!=null) {
			dao.deleteVendor(optional);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Vendor Deleted as per Given Id");
			responseStructure.setData(optional);
			return responseEntity;
		} else {
			throw new NoSuchIdFoundException("No User found to delete for given id");
		}
	}
}
