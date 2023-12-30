package com.company.NimapInfoTech.Controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	  
	  @Autowired
	  private CategoryService categoryService;
	  
	  
	  
// GET all categories
	  @GetMapping("/")
	  //public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	  public List<CategoryEntity> getAllCategories(){
		  List<CategoryEntity> obj = categoryService.getAllCategories();
		  System.out.println(obj);
	    return categoryService.getAllCategories();
	  }
	  
	  
// GET all categories by pagination	  
	  @GetMapping
	    public ResponseEntity<Page<CategoryEntity>> getEntities(
	            @RequestParam(defaultValue = "1") int page,
	            @RequestParam(defaultValue = "2") int size
	    ) {
	        PageRequest pageable = PageRequest.of(page, size);
	        Page<CategoryEntity> entities = categoryService.getPaginatedEntities(pageable);
	        return ResponseEntity.ok(entities);
	    }
//GET Categories by id
	 @GetMapping("/{id}")
	  public CategoryEntity getCategoryById(@PathVariable int id) {
	    return categoryService.getCategoryById(id);
	  }

	 // POST Category
	  @PostMapping
	  public String createCategory(@RequestBody CategoryEntity category) {
	    return categoryService.createCategory(category);
	  }
  
	  // UPDATE 
	  @PutMapping("/{id}")
	  public String updateCategory(@PathVariable int id, @RequestBody CategoryEntity category) {
	    return categoryService.updateCategory(id, category);
	  }
	  
	  // DELETE
	  @DeleteMapping("/{id}")
	  public String deleteCategory(@PathVariable int id) {
	   return categoryService.deleteCategory(id);
	    
	  }
	}

