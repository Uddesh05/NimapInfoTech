package com.company.NimapInfoTech.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.NimapInfoTech.Category.Entity.ProductEntity;

public interface ProductDao extends JpaRepository<ProductEntity,Integer> {

}
