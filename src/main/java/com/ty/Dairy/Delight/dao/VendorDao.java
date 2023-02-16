package com.ty.Dairy.Delight.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Dairy.Delight.dto.Vendor;
import com.ty.Dairy.Delight.repository.VendorRepository;

@Repository
public class VendorDao {
	
	@Autowired
	private VendorRepository repository;
	
	public Vendor saveVendor(Vendor vendor) {
		return repository.save(vendor);
	}
	
	public Optional<Vendor> getVendor(int id){
		return repository.findById(id);
	}
	
	public Vendor updateVendor(Vendor vendor) {
		return repository.save(vendor);
	}
	
	public void deleteVendor(Vendor vendor) {
		 repository.delete(vendor);
	}

}
