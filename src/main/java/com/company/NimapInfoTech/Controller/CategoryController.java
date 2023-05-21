package com.company.NimapInfoTech.Controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Service.CategoryService;

@RestController
@RequestMapping("/api/categerios")
public class CategoryController {
	  
	  @Autowired
	  private CategoryService categoryService;

	  @GetMapping("/page=3")
	  public List<CategoryEntity> getAllCategories(){
	    return categoryService.getAllCategories();
	  }

	 @GetMapping("/{di}")
	  public CategoryEntity getCategoryById(@PathVariable int di) {
	    return categoryService.getCategoryById(di);
	  }

	  @PostMapping
	  public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
	    return categoryService.createCategory(category);
	  }
     
	  @PutMapping("/{di}")
	  public CategoryEntity updateCategory(@PathVariable int di, @RequestBody CategoryEntity category) {
	    return categoryService.updateCategory(di, category);
	  }
	  
	  @DeleteMapping("/{di}")
	  public void deleteCategory(@PathVariable int di) {
	    categoryService.deleteCategory(di);
	    
	  }
	}

