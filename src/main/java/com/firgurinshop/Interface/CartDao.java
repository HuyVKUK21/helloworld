package com.firgurinshop.Interface;

import java.util.List;

import com.firgurinshop.Entity.Cart;

public interface CartDao {
	public List<Cart> getCartByUserId(String user_id);
	public int AddCart(Cart cart);
	public int DeleteCart(String cart_id);
}
