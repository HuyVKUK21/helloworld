package com.firgurinshop.Services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.Cart;
import com.firgurinshop.Interface.CartDao;
import com.firgurinshop.Interface.CartService;

@Service
@Transactional("transactionManager")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;

	@Override
	public List<Cart> getCartByUserId(String user_id) {
		// TODO Auto-generated method stub
		return cartDao.getCartByUserId(user_id);
	}

	@Override
	public int AddCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.AddCart(cart);
	}

	@Override
	public int DeleteCart(String cart_id) {
		// TODO Auto-generated method stub
		return cartDao.DeleteCart(cart_id);
	}

}
