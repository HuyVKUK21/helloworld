package com.firgurinshop.Services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Product;
import com.firgurinshop.Interface.ProductDao;
import com.firgurinshop.Interface.ProductService;

@Service
@Transactional("transactionManager")
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	@Transactional("transactionManager")
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataProduct(String id) {
		return productDao.getDataProduct(id);
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataProductAvailable() {
		// TODO Auto-generated method stub
		return productDao.getDataProductAvailable();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getDataFilter(String id) {
		// TODO Auto-generated method stub
		return productDao.getDataFilter(id);
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getProductSize() {
		// TODO Auto-generated method stub
		return productDao.getProductSize();
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getFilterBrand(String tradeMark) {
		// TODO Auto-generated method stub
		return productDao.getFilterBrand(tradeMark);
	}

	@Override
	@Transactional("transactionManager")
	public List<Product> getFilterSize(String productSize) {
		// TODO Auto-generated method stub
		return productDao.getFilterSize(productSize);
	}

	@Override
	public List<Product> getSearchProduct(String keyword) {
		// TODO Auto-generated method stub
		return productDao.getSearchProduct(keyword);
	}
}
