package com.ty.Dairy.Delight.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Dairy.Delight.dto.CollectionPointManager;
import com.ty.Dairy.Delight.repository.CollectionPointManagerRepo;

@Repository
public class CollectionPointManagerDao {

	@Autowired
	CollectionPointManagerRepo repo;

	public CollectionPointManager saveCpm(CollectionPointManager cpm) {
		return repo.save(cpm);
	}
	public CollectionPointManager loginCpm(String email) {
		return repo.getByEmail(email);
	}

	public CollectionPointManager updateCpm(CollectionPointManager cpm) {
		return repo.save(cpm);
	}

	public Optional<CollectionPointManager> getCpmById(int id) {
		return repo.findById(id);
	}

	public List<CollectionPointManager> getAll() {
		return repo.findAll();
	}

	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted";
	}

}
