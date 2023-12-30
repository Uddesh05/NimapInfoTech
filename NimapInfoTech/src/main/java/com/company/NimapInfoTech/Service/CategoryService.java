package com.company.NimapInfoTech.Service;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Dao.CategoryDao;
//import com.geekster.weeklytest.project.StudentsEntityDataMapper.Model.Student;

@Service
public class CategoryService {

	@Autowired
	
	private CategoryDao categorydao;
	
	//GET all categories
	public List<CategoryEntity> getAllCategories() {  
	        return categorydao.findAll();
	    }
	
	//GET all by pagination
	 public Page<CategoryEntity> getPaginatedEntities(Pageable pageable) {
	        return categorydao.findAll(pageable);
	    }

	//INSERT category by id  post
	 public String createCategory(CategoryEntity category)  {

		 categorydao.save(category);
	        return "New Categories Added";
	    }
	// UPDATE categories table
	public String updateCategory(int id,CategoryEntity category) {
		Optional<CategoryEntity> op =categorydao.findById(category.getId());
		CategoryEntity ct=null;
		if(op.isPresent()) {
			ct=categorydao.save(category);
		}
		return "Categories Updated Sucessfully" ;
	}
// DELETE categories
	public String deleteCategory(int id) {
		Optional<CategoryEntity> op =categorydao.findById(id);
		if(op.isPresent()) {
			categorydao.deleteById(id);
		}
		return "Deleted item from Categories Succesfully!!";
		
	}

	// GET categories by id
	public CategoryEntity getCategoryById(int id) {
		Optional<CategoryEntity> op =categorydao.findById(id);
		CategoryEntity ct=null;
		if(op.isPresent()) {
			ct=op.get();
		}
	
		return ct;
	}

	
	
}
