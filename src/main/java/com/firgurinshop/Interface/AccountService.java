package com.firgurinshop.Interface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firgurinshop.Entity.User;

@Service
public interface AccountService {
	@Autowired
	public User checkAccount(User user);
	
	@Autowired
	public int AddAccount(User user);
}
