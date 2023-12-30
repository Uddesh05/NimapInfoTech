package com.company.NimapInfoTech.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Category.Entity.ProductEntity;
import com.company.NimapInfoTech.Dao.ProductDao;

@Service
public class ProdcutService {

	@Autowired
	private ProductDao productdao;
	
	//get all products
	public List<ProductEntity> getAllProducts() {
		return productdao.findAll();
	}
	//GET all by pagination
		 public Page<ProductEntity> getPaginatedEntities(Pageable pageable) {
		        return productdao.findAll(pageable);
		    }
	
	//get products  by id
	public ProductEntity getProductById(int di) {
		List<ProductEntity> records = productdao.findAll();
		ProductEntity temp=null;
		for(int i=0;i<records.size();i++) {
			ProductEntity obj = records.get(i);
			if(di==obj.getProid()) {
				return obj;
			}
		}
		return temp;
	}
	
//POST-create new product
	public String createProduct(ProductEntity product)  {
		productdao.save(product);
	        return "New Product Added";
	    }
	
	
//UPDATE-update product by id
	public String updateProduct(int id,ProductEntity product) {
		Optional<ProductEntity> op =productdao.findById(product.getProid());
		ProductEntity ct=null;
		if(op.isPresent()) {
			ct=productdao.save(product);
		}
		return "Products Updated Sucessfully" ;
	}

	// DELETE product by id
	public String deleteProduct(int id) {
		Optional<ProductEntity> op =productdao.findById(id);
		if(op.isPresent()) {
			productdao.deleteById(id);
		}
		return "Product Deleted Sucessfully!!";
	}
}
