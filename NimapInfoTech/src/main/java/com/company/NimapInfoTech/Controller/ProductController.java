package com.company.NimapInfoTech.Controller;

import java.util.List;

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
import com.company.NimapInfoTech.Category.Entity.ProductEntity;
import com.company.NimapInfoTech.Service.CategoryService;
import com.company.NimapInfoTech.Service.ProdcutService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	  @Autowired
	  private ProdcutService productService;

	  @GetMapping("/")
	  //public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	  public List<ProductEntity> getAllProducts(){
	    return productService.getAllProducts();
	  }
	  @GetMapping
	    public ResponseEntity<Page<ProductEntity>> getEntities(
	            @RequestParam(defaultValue = "1", required=false) int page,
	            @RequestParam(defaultValue = "4",required=false) int size
	    ) {
	        PageRequest pageable = PageRequest.of(page, size);
	        Page<ProductEntity> entities = productService.getPaginatedEntities(pageable);
	        return ResponseEntity.ok(entities);
	    }

	 @GetMapping("/{di}")
	  public ProductEntity getProductById(@PathVariable int di) {
	    return productService.getProductById(di);
	  }
	  

	  @PostMapping
	  public String createProduct(@RequestBody ProductEntity product) {
	    return productService.createProduct(product);
	  }
   
	  @PutMapping("/{id}")
	  public String updateProduct(@PathVariable int id, @RequestBody ProductEntity product) {
	    return productService.updateProduct(id, product);
	  }
	  
	  @DeleteMapping("/{id}")
	  public String deleteProduct(@PathVariable int id) {
	  return  productService.deleteProduct(id);
	    
	  }
	}
