package com.firgurinshop.Entity;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	@ManyToOne
	@JoinColumn(name = "category_id" , insertable = false, updatable = false)
	private Category category;
	private String category_id;
	@ManyToOne
	@JoinColumn(name = "brand_id" ,insertable = false, updatable = false)
	private Brand brand;
	private String brand_id;
	private String product_name;
	private String product_desc;
	private String product_series;
	private String product_size;
	private String product_proportion;
	private String product_date;
	private int product_price;
	private String product_price_update;
	private String product_image;
	private String product_image2;
	private String product_image3;
	private String product_image4;
	private int product_status;
	private String created_at;
	private String updated_at;
	private String product_update;

	public Product() {
		super();
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getProduct_series() {
		return product_series;
	}

	public void setProduct_series(String product_series) {
		this.product_series = product_series;
	}

	public String getProduct_size() {
		return product_size;
	}

	public void setProduct_size(String product_size) {
		this.product_size = product_size;
	}

	public String getProduct_proportion() {
		return product_proportion;
	}

	public void setProduct_proportion(String product_proportion) {
		this.product_proportion = product_proportion;
	}

	public String getProduct_date() {
		return product_date;
	}

	public void setProduct_date(String product_date) {
		this.product_date = product_date;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_price_update() {
		return product_price_update;
	}

	public void setProduct_price_update(String product_price_update) {
		this.product_price_update = product_price_update;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getProduct_image2() {
		return product_image2;
	}

	public void setProduct_image2(String product_image2) {
		this.product_image2 = product_image2;
	}

	public String getProduct_image3() {
		return product_image3;
	}

	public void setProduct_image3(String product_image3) {
		this.product_image3 = product_image3;
	}

	public String getProduct_image4() {
		return product_image4;
	}

	public void setProduct_image4(String product_image4) {
		this.product_image4 = product_image4;
	}

	public int getProduct_status() {
		return product_status;
	}

	public void setProduct_status(int product_status) {
		this.product_status = product_status;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getProduct_update() {
		return product_update;
	}

	public void setProduct_update(String product_update) {
		this.product_update = product_update;
	}

}
