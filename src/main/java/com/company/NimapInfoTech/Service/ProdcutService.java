package com.company.NimapInfoTech.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Category.Entity.ProductEntity;
import com.company.NimapInfoTech.Dao.CategoryDao;
import com.company.NimapInfoTech.Dao.ProductDao;

@Service
public class ProdcutService {

	@Autowired
	private ProductDao productdao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ProductEntity prodEntity;

	public List<ProductEntity> getAllProduct() {
		return productdao.findAll();
	}

	public ProductEntity createProduct(ProductEntity product) {
		Optional<ProductEntity> op = productdao.findById(product.getId());

		if (op.isPresent() && !op.get().getPname().equalsIgnoreCase(product.getPname())) {
			Optional<CategoryEntity> category = categoryDao.findById(product.getCategoryentity().getId());
			if (category.isPresent()) {
				prodEntity.setCategoryentity(category.get());
			}
		}
		return productdao.save(product);

	}

	public ProductEntity updateProduct(int id, ProductEntity product) {
		product.setId(id);
		Optional<ProductEntity> op = productdao.findById(product.getId());
		ProductEntity ct = null;
		if (op.isPresent()) {

			ct = productdao.save(product);
		}
		return ct;
	}

	public ProductEntity getProductById(int id) {
		Optional<ProductEntity> op = productdao.findById(id);
		ProductEntity prodEntity = null;
		if (op.isPresent()) {
			prodEntity = op.get();
		}
		return prodEntity;
	}

	public String deleteProduct(int id) {
		Optional<ProductEntity> op = productdao.findById(id);
		String str = "Data Deletion Failed";
		if (op.isPresent()) {
			productdao.deleteById(id);
			str = "Data Deleted Successfully";
		}
		return str;
	}

}
