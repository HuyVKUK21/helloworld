package com.firgurinshop.Services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Brand;
import com.firgurinshop.Interface.BrandDao;
import com.firgurinshop.Interface.BrandService;
import com.firgurinshop.Interface.CartDao;

@Service
@Transactional("transactionManager")
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> getBrand() {
		// TODO Auto-generated method stub
		return brandDao.getBrand();
	}


	
}
