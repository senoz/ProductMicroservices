package com.supermart.grocery.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUCTS", schema = "grocery")
public class Product {

	@Id
	@GeneratedValue(
	    strategy= GenerationType.AUTO,
	    generator="native"
	)
	@GenericGenerator(
	    name = "native",
	    strategy = "native"
	)
	@Column(name = "id", updatable = false, nullable = false)
	public long id;

	@Column(name = "CATID")
	public long catId;
	
	@Column(name="NAME")
	public String name;

	@Column(name="DESCRIPTION", columnDefinition = "TEXT")
	public String Description;
	
	@Column(name="PRICE")
	public double price;
	
	@Column(name="QUANTITY")
	public int qty;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCatId() {
		return catId;
	}

	public void setCatId(long catId) {
		this.catId = catId;
	}

	public String getProductName() {
		return name;
	}

	public void setProductName(String name) {
		this.name = name;
	}

	public String getProductDescription() {
		return Description;
	}

	public void setProductDescription(String description) {
		Description = description;
	}

	public double getProductPrice() {
		return price;
	}

	public void setProductPrice(double price) {
		this.price = price;
	}

	public int getProductQty() {
		return qty;
	}

	public void setProductQty(int qty) {
		this.qty = qty;
	}
}
