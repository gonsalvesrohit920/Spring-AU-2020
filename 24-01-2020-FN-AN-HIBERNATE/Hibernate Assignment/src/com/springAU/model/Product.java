package com.springAU.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@NamedQuery(name=Product.GET_ALL_PRODUCTS, query="from Product") // Named Query
@Entity
@Table(name="Products") 
public class Product {
	public static final String GET_ALL_PRODUCTS = "GET_ALL_PRODUCTS";
	
	@Override
	public String toString() {
		return "Product [" + " productId=" + productId + ", productNAme=" + productNAme + ", price="
				+ price + ", description=" + description + "]";
	}

	public int getProductId() {
		return productId;
	}
	
	@ManyToOne
    private Seller seller;

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Id
	@GeneratedValue()
	private int productId;
	private String productNAme;
	private int price;
	
	@Lob
	private String description;

	
	public Product(String productNAme, int price, String description) {
		super();
		this.productNAme = productNAme;
		this.price = price;
		this.description = description;
	}
	
	public Product() {
		
	}
	
	public String getProductNAme() {
		return productNAme;
	}

	public void setProductNAme(String productNAme) {
		this.productNAme = productNAme;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
