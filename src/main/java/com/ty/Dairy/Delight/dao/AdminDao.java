package com.ty.Dairy.Delight.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Dairy.Delight.dto.Admin;
import com.ty.Dairy.Delight.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	private AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Optional<Admin> getAdminById(int admin_id) {
		return adminRepository.findById(admin_id);
	}
	
	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
	}

}
