package com.firgurinshop.Interface;

import com.firgurinshop.Entity.User;

public interface AccountDao {
	public User checkAccount(User user);
	public int AddAccount(User user);
}
