package com.company.NimapInfoTech.Dao;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.company.NimapInfoTech.Category.Entity.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity,Integer>{

}
