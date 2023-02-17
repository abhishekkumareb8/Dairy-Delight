package com.ty.Dairy.Delight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Dairy.Delight.dto.CollectionPointManager;
import com.ty.Dairy.Delight.service.CollectionPointManagerService;
import com.ty.Dairy.Delight.util.ResponseStructure;

@RestController
@RequestMapping("cpm")
public class CollectionPointManagerController {
	@Autowired
	private CollectionPointManagerService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<CollectionPointManager>> saveCpm(@RequestBody CollectionPointManager c) {
		return service.saveCpm(c);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<CollectionPointManager>> getById(@PathVariable int id)
	{
		return service.getById(id);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<CollectionPointManager>>> getAll(@RequestParam String email, @RequestParam String pwd)
	{
		return service.loginCpm(email, pwd);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<CollectionPointManager>> updateCpm(@RequestParam int id, @RequestBody CollectionPointManager c)
	{
		return service.updateById(id, c);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id){
		return service.deleteById(id);
	}

}
