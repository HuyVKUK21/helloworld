package com.firgurinshop.controller.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.firgurinshop.Entity.User;
import com.firgurinshop.Interface.AccountService;



@Controller
public class UserController extends BaseController{
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		_mvShare.addObject("user", new User());
		_mvShare.setViewName("web/login");
		return _mvShare;	
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginAccount(HttpSession session, @ModelAttribute("user") User user) {
		user  = accountService.checkAccount(user);
		if(user != null) {
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", user);
		}
		else {
			_mvShare.addObject("status_login", "Sai tài khoản hoặc mật khẩu");
		}
		
		return _mvShare;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String loginAccount(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:trang-chu";
	}
	
	@RequestMapping(value = "/infomation", method = RequestMethod.GET)
	public ModelAndView Infomation() {
		_mvShare.setViewName("user/account/infomation");
		return _mvShare;
	}
	
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public ModelAndView signUp() {
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new User());
		return _mvShare;
	}
	

//	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public ModelAndView createAccount(@ModelAttribute("user") User user) {
		int count = accountService.AddAccount(user);
		if(count > 0) {
			_mvShare.addObject("status", "Đăng ký thành công! Đăng nhập để sử dụng dịch vụ");
		}
		else {
			_mvShare.addObject("status", "Đăng ký thất bại, vui lòng tải lại trang hoặc thử lại");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}



	@RequestMapping(value = "/forgot-password", method = RequestMethod.GET)
	public ModelAndView forgotPassword() {
		_mvShare.setViewName("user/account/forgot-password");
		return _mvShare;	
	}
	

			
	
}
