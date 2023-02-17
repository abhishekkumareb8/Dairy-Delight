package com.ty.Dairy.Delight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Dairy.Delight.dto.CollectionPointManager;

public interface CollectionPointManagerRepo extends JpaRepository<CollectionPointManager, Integer> {
public CollectionPointManager getByEmail(String email);
}
