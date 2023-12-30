package com.company.NimapInfoTech.Category.Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class ProductEntity {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proid;
	private String pname;
	private String proprice;
	 @ManyToOne
	    @JoinColumn(name = "category_id")
	    private CategoryEntity categoryentity;
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public CategoryEntity getCategoryentity() {
		return categoryentity;
	}
	public void setCategoryentity(CategoryEntity categoryentity) {
		this.categoryentity = categoryentity;
	}
	
	public String getProprice() {
		return proprice;
	}
	public void setProprice(String proprice) {
		this.proprice = proprice;
	}
	@Override
	public String toString() {
		return "ProductEntity [proid=" + proid + ", pname=" + pname + ", proprice=" + proprice + ", categoryentity="
				+ categoryentity + "]";
	}
	
	

	
	
	
}
