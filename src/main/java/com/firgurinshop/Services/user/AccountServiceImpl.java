package com.firgurinshop.Services.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firgurinshop.Entity.User;
import com.firgurinshop.Interface.AccountDao;
import com.firgurinshop.Interface.AccountService;
import com.firgurinshop.Interface.CategoryDao;

@Service
@Transactional("transactionManager")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;
	@Override
	public User checkAccount(User user) {
		String password = user.getUser_password();
		User user_test = accountDao.checkAccount(user);
		if(user_test != null ) {
			if(BCrypt.checkpw(password, user_test.getUser_password())) {
				return user_test;
			}
			else {
				return null;
			}
		}
		return null;
	}
	@Override
	public int AddAccount(User user) {
		user.setUser_password(BCrypt.hashpw(user.getUser_password(), BCrypt.gensalt(12)));
		return accountDao.AddAccount(user);
	}

}
