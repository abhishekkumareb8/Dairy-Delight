package com.ty.Dairy.Delight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Dairy.Delight.dao.CollectionPointManagerDao;
import com.ty.Dairy.Delight.dto.CollectionPointManager;
import com.ty.Dairy.Delight.exception.NoSuchIdFoundException;
import com.ty.Dairy.Delight.exception.UnAuthorisedException;
import com.ty.Dairy.Delight.exception.UnableToUpdateException;
import com.ty.Dairy.Delight.util.ResponseStructure;

@Service
public class CollectionPointManagerService {

	@Autowired
	private CollectionPointManagerDao dao;

//save
	public ResponseEntity<ResponseStructure<CollectionPointManager>> saveCpm(CollectionPointManager cpm) {
		ResponseStructure<CollectionPointManager> r = new ResponseStructure<CollectionPointManager>();
		ResponseEntity<ResponseStructure<CollectionPointManager>> e = new ResponseEntity<ResponseStructure<CollectionPointManager>>(
				r, HttpStatus.CREATED);
		r.setStatus(HttpStatus.CREATED.value());
		r.setMessage("Saved Point name and details");
		r.setData(dao.saveCpm(cpm));
		return e;
	}

//login to get all
	public ResponseEntity<ResponseStructure<List<CollectionPointManager>>> loginCpm(String email, String password) {
		ResponseStructure<List<CollectionPointManager>> r = new ResponseStructure<List<CollectionPointManager>>();
		ResponseEntity<ResponseStructure<List<CollectionPointManager>>> e = new ResponseEntity<ResponseStructure<List<CollectionPointManager>>>(
				r, HttpStatus.FOUND);
		CollectionPointManager c = dao.loginCpm(email);
		if (c != null && c.getPassword().equals(password)) {
			r.setStatus(HttpStatus.FOUND.value());
			r.setMessage("Logged in succesfully");
			r.setData(dao.getAll());
		} else {
			throw new UnAuthorisedException();
		}
		return e;
	}

//getById
	public ResponseEntity<ResponseStructure<CollectionPointManager>> getById(int id) {
		ResponseStructure<CollectionPointManager> r = new ResponseStructure<CollectionPointManager>();
		ResponseEntity<ResponseStructure<CollectionPointManager>> e = new ResponseEntity<ResponseStructure<CollectionPointManager>>(
				r, HttpStatus.OK);
		Optional<CollectionPointManager> o = dao.getCpmById(id);
		if (o.isPresent()) {
			r.setStatus(HttpStatus.OK.value());
			r.setMessage("Found ID");
			r.setData(dao.getCpmById(id).get());
		} else {
			throw new NoSuchIdFoundException();
		}
		return e;
	}

//update
	public ResponseEntity<ResponseStructure<CollectionPointManager>> updateById(int id, CollectionPointManager cpm) {
		ResponseStructure<CollectionPointManager> r = new ResponseStructure<CollectionPointManager>();
		ResponseEntity<ResponseStructure<CollectionPointManager>> e = new ResponseEntity<ResponseStructure<CollectionPointManager>>(
				r, HttpStatus.OK);
		Optional<CollectionPointManager> o = dao.getCpmById(id);
		if (o.isPresent()) {
			cpm.setId(o.get().getId());
			r.setStatus(HttpStatus.OK.value());
			r.setMessage("Found ID");
			r.setData(dao.updateCpm(cpm));
		} else {
			throw new UnableToUpdateException();
		}
		return e;

	}

	//deleted
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		ResponseStructure<String> r = new ResponseStructure<String>();
		Optional<CollectionPointManager> c = dao.getCpmById(id);
		if (c.isPresent()) {
			r.setStatus(HttpStatus.OK.value());
			r.setMessage("Deleted");
			r.setData(dao.deleteById(id));
		} else {
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<String>>(r, HttpStatus.OK);
	}

}
