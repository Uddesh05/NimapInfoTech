 package com.company.NimapInfoTech.Category.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class CategoryEntity {
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	 
@JsonIgnore
@OneToMany(mappedBy = "categoryentity",cascade=CascadeType.ALL)
//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	private List<ProductEntity> aa;

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
