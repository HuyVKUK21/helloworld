package com.firgurinshop.Services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Category;
import com.firgurinshop.Interface.CategoryDao;
import com.firgurinshop.Interface.CategoryService;

@Service
@Transactional("transactionManager")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;

	@Transactional("transactionManager")
	public List<Category> getAllCategory() {
		return categoryDao.getAllCategory();
	}
}
