package com.company.NimapInfoTech.Category.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity

public class CategoryEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "categoryentity")
	private Set<ProductEntity> prodSet= new HashSet();
	
	
	
	public Set<ProductEntity> getProdSet() {
		return prodSet;
	}
	public void setProdSet(Set<ProductEntity> prodSet) {
		this.prodSet = prodSet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CategoryEntity [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
