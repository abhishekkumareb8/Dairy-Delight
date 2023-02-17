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

import com.ty.Dairy.Delight.dto.Admin;
import com.ty.Dairy.Delight.service.AdminService;
import com.ty.Dairy.Delight.util.ResponseStructure;

@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin, @RequestParam int admin_id) {
		return adminService.updateAdmin(admin, admin_id);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Admin>> getAdmin(@RequestParam int admin_id) {
		return adminService.getAdmin(admin_id);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int admin_id) {
		return adminService.deleteAdmin(admin_id);//
	}
}
