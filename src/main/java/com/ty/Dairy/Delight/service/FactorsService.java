package com.ty.Dairy.Delight.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Dairy.Delight.dao.FactorsDao;
import com.ty.Dairy.Delight.dao.VendorDao;
import com.ty.Dairy.Delight.dto.Factors;
import com.ty.Dairy.Delight.dto.Vendor;
import com.ty.Dairy.Delight.exception.NoSuchIdFoundException;
import com.ty.Dairy.Delight.util.ResponseStructure;

@Service
public class FactorsService {

	@Autowired
	FactorsDao dao;
	
	@Autowired
	private VendorDao vendorDao;

	public ResponseEntity<ResponseStructure<Factors>> saveFactorsService(Factors factor, int id) {
		Vendor vendor= vendorDao.getVendor(id);
		ResponseStructure<Factors> responseStructure = new ResponseStructure<Factors>();
		if(vendor!=null) {
		List<Factors>list=vendor.getFactors();
		list.add(factor);
		vendor.setFactors(list);
		factor.setDate(new Date());
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Factors Creation");
		responseStructure.setData(dao.saveFactors(factor));
		return new ResponseEntity<ResponseStructure<Factors>>(responseStructure, HttpStatus.CREATED);
		}else {
			throw new NoSuchIdFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<Factors>> updateFactorsService(Factors factor, int factorid) {
		ResponseStructure<Factors> responseStructure = new ResponseStructure<Factors>();
		Optional<Factors> optional = dao.findFactorsById(factorid);
		if (optional.isPresent()) {
			factor.setId(factorid);
			factor.setDate(new Date());
			responseStructure.setStatus(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Factors Updation");
			responseStructure.setData(dao.updateFactors(factor));
		} else {
			throw new NoSuchIdFoundException(" No Id Found ");
		}
		return new ResponseEntity<ResponseStructure<Factors>>(responseStructure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Factors>> findFactorsByIdService(int factorid) {
		ResponseStructure<Factors> responseStructure = new ResponseStructure<Factors>();
		Optional<Factors> optional = dao.findFactorsById(factorid);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Found factors");
			responseStructure.setData(optional.get());
		} else {
			 throw new NoSuchIdFoundException(" No Id Found");
		}
		return new ResponseEntity<ResponseStructure<Factors>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Factors>> deleteFactorsById(int factorid) {
		ResponseStructure<Factors> responseStructure = new ResponseStructure<Factors>();
		Optional<Factors> optional = dao.findFactorsById(factorid);
		if (optional.isPresent()) {
			dao.deleteFactors(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Factor Deleted");
			responseStructure.setData(optional.get());
		} else {
			throw new NoSuchIdFoundException("No Id Found");
		}
		return new ResponseEntity<ResponseStructure<Factors>>(responseStructure, HttpStatus.OK);
	}

}
