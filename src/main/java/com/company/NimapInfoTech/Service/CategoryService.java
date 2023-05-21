package com.company.NimapInfoTech.Service;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.NimapInfoTech.Category.Entity.CategoryEntity;
import com.company.NimapInfoTech.Dao.CategoryDao;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categorydao;

	public List<CategoryEntity> getAllCategories() {
		return categorydao.findAll();
	}

	public CategoryEntity createCategory(CategoryEntity category) {
		Optional<CategoryEntity> op = categorydao.findById(category.getId());
		CategoryEntity ct = null;
		if (op.isPresent()) {
			if (!op.get().getName().equalsIgnoreCase(category.getName())) {
				ct = categorydao.save(category);
			}
		}
		return ct;
	}

	public CategoryEntity updateCategory(int id, CategoryEntity category) {
		Optional<CategoryEntity> op = categorydao.findById(category.getId());
		CategoryEntity ct = null;
		if (op.isPresent()) {
			ct = categorydao.save(category);
		}
		return ct;
	}

	public void deleteCategory(int id) {
		Optional<CategoryEntity> op = categorydao.findById(id);
		if (op.isPresent()) {
			categorydao.deleteById(id);
		}

	}

	public CategoryEntity getCategoryById(int id) {
		Optional<CategoryEntity> op = categorydao.findById(id);
		CategoryEntity ct = null;
		if (op.isPresent()) {
			ct = op.get();
		}

		return ct;
	}

}
