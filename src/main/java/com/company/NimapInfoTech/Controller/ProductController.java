package com.company.NimapInfoTech.Controller;

import java.util.List;

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
import com.company.NimapInfoTech.Category.Entity.ProductEntity;
import com.company.NimapInfoTech.Service.CategoryService;
import com.company.NimapInfoTech.Service.ProdcutService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProdcutService prodService;

	@GetMapping("/page=3")
	public List<ProductEntity> getAllProduct() {
		return prodService.getAllProduct();
	}

	@GetMapping("/{di}")
	public ProductEntity getProductById(@PathVariable int di) {
		return prodService.getProductById(di);
	}

	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return prodService.createProduct(product);
	}

	@PutMapping("/{di}")
	public ProductEntity updateProduct(@PathVariable int di, @RequestBody ProductEntity product) {
		return prodService.updateProduct(di, product);
	}

	@DeleteMapping("/{di}")
	public String deleteProduct(@PathVariable int di) {
		return prodService.deleteProduct(di);

	}
}
