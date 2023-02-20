package com.ty.Dairy.Delight.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Dairy.Delight.dao.AdminDao;
import com.ty.Dairy.Delight.dto.Admin;
import com.ty.Dairy.Delight.exception.NoSuchIdFoundException;
import com.ty.Dairy.Delight.exception.UnableToUpdateException;
import com.ty.Dairy.Delight.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		if (admin != null) {
			ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
			ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
					responseStructure, HttpStatus.OK);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Created");
			responseStructure.setData(adminDao.saveAdmin(admin));
			return responseEntity;
		}
		return null;
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int admin_id) {
		Optional<Admin> optional = adminDao.getAdminById(admin_id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			admin.setAdmin_id(admin_id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(adminDao.updateAdmin(admin));
			return responseEntity;
		}

		throw new UnableToUpdateException("no such id found in database to update");

	}

	public ResponseEntity<ResponseStructure<Admin>> getAdmin(int admin_id) {
		Optional<Admin> optional = adminDao.getAdminById(admin_id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Received");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw new NoSuchIdFoundException("no such id found in database");
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int admin_id) {
		Optional<Admin> optional = adminDao.getAdminById(admin_id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				responseStructure, HttpStatus.OK);
		if (optional.isPresent()) {
			adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Admin Deleted");
			responseStructure.setData(optional.get());
		}
		return responseEntity;
	}
//
}
