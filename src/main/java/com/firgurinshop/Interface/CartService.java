package com.firgurinshop.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firgurinshop.Entity.Cart;
import com.firgurinshop.Entity.User;

@Service
public interface CartService {
	public List<Cart> getCartByUserId(String user_id);
	public int AddCart(Cart cart);
	public int DeleteCart(String cart_id);
}
