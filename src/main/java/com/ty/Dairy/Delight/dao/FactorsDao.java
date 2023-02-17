package com.ty.Dairy.Delight.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Dairy.Delight.dto.Factors;
import com.ty.Dairy.Delight.repository.FactorsRepository;

@Repository
public class FactorsDao {

	@Autowired
	FactorsRepository repo;

	public Factors saveFactors(Factors factors) {
		return repo.save(factors);
	}

	public Factors updateFactors(Factors factors) {
		return repo.save(factors);
	}

	public Optional<Factors> findFactorsById(int id) {
		return repo.findById(id);
	}

	public void deleteFactors(int id) {
		repo.deleteById(id);
	}

}
