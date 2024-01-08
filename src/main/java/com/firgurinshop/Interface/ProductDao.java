package com.firgurinshop.Interface;

import java.util.List;

import com.firgurinshop.Entity.Brand;
import com.firgurinshop.Entity.Product;

public interface ProductDao {
	public List<Product> getAllProduct();
	public List<Product> getDataProduct(String id);
	public List<Product> getDataProductAvailable();
	public List<Product> getDataFilter(String id);
	public List<Product> getProductSize();
	public List<Product> getFilterBrand(String tradeMark);
	public List<Product> getFilterSize(String productSize);
	public List<Product> getSearchProduct(String keyword);
}
