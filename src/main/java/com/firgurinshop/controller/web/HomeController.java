package com.firgurinshop.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.firgurinshop.Entity.Cart;
import com.firgurinshop.Entity.Category;
import com.firgurinshop.Entity.Product;
import com.firgurinshop.Entity.User;
import com.firgurinshop.Interface.BrandService;
import com.firgurinshop.Interface.CartService;
import com.firgurinshop.Interface.CategoryService;
import com.firgurinshop.Interface.ProductDao;
import com.firgurinshop.Interface.ProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController extends BaseController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CartService cartService;
	@Autowired
	BrandService brandService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<Product> product = productService.getAllProduct();
		List<Category> category = categoryService.getAllCategory();
		_mvShare.addObject("tbl_product", product);
		_mvShare.addObject("tbl_category_product", category);
		_mvShare.addObject("tbl_product_available", productService.getDataProductAvailable());
		System.out.println("test: " + product.size());
		_mvShare.setViewName("web/home");
		return _mvShare;
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public ModelAndView Contact() {
		_mvShare.setViewName("web/contact");
		return _mvShare;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam String keywords_submit) {
		System.out.println(keywords_submit);
		System.out.println(	_mvShare.addObject("Hello it's me" + productService.getSearchProduct(keywords_submit)));
		_mvShare.addObject("search_Product", productService.getSearchProduct(keywords_submit));
		_mvShare.setViewName("web/search");
		return _mvShare;
	}

	@RequestMapping(value = "/detail-product/{id}", method = RequestMethod.GET)
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.addObject("cart", new Cart());
		List<Product> dataProduct = productService.getDataProduct(id);
		_mvShare.addObject("tbl_detail_product", productService.getDataProduct(id));
		_mvShare.setViewName("web/detail-product");
		return _mvShare;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView cartGet(@RequestParam("user_id") String user_id) {
		_mvShare.addObject("user_id", user_id);
		System.out.println("Đây là userid: " + user_id);
		_mvShare.addObject("tbl_info_cart", cartService.getCartByUserId(user_id));
		_mvShare.addObject("itemProduct", cartService.getCartByUserId(user_id).size());
		_mvShare.setViewName("web/cart");
		return _mvShare;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public String cartPost(@ModelAttribute("cart") Cart cart, @RequestParam("user_id") String user_id) {

		cartService.AddCart(cart);
		return "redirect:/cart?user_id=" + user_id;
	}

	
	@RequestMapping(value = "/payment/{user_id}", method = RequestMethod.GET)
	public ModelAndView Payment(@PathVariable String user_id) {
		_mvShare.addObject("user_id", user_id);
		_mvShare.addObject("tbl_cart", cartService.getCartByUserId(user_id));
		_mvShare.setViewName("web/payment");
		return _mvShare;
	}

//
	@RequestMapping(value = "/product-portfolio/{id}", method = RequestMethod.GET)
	public ModelAndView productPortfolio(@PathVariable String id, @RequestParam(required = false) @PathVariable String tradeMark,  @RequestParam(required = false) @PathVariable String productSize ) {
		List<Product> product = productService.getDataFilter(id);
		System.out.println("hahahahaha" + product);
		List<Product> tradeMarkFilter = productService.getFilterBrand(tradeMark);
		_mvShare.addObject("tbl_product_portfolio",product);
		_mvShare.addObject("tbl_product_portfolio",tradeMarkFilter);
		_mvShare.addObject("tbl_product_portfolio",productService.getFilterSize(productSize));
		_mvShare.addObject("tbl_product_size",productService.getProductSize());
		_mvShare.addObject("tbl_brand_product", brandService.getBrand());
		_mvShare.setViewName("web/product-portfolio");
		return _mvShare;
	}
//

//
//	@RequestMapping(value = "/update-to-cart", method = RequestMethod.GET)
//	@ResponseBody
//	public String updatetoCart(@RequestParam String submitButton, @RequestParam String cart_id,
//			@RequestParam("user_id") String user_id) {
//		if ("-".equals(submitButton)) {
//			_homeService.updateCart(cart_id);
//		} else if ("+".equals(submitButton)) {
//			_homeService.updateCartAdd(cart_id);
//		}
//		List<Cart> updatedCartList = _homeService.getInfoCart(user_id);
//		Gson gson = new Gson();
//		String json = gson.toJson(updatedCartList);
//		return json;
//	}
////
	@RequestMapping(value = "/delete-to-cart/{cart_id}/{user_id}", method = RequestMethod.GET)
	public String deletetoCart(@PathVariable String cart_id, @PathVariable String user_id) {
		cartService.DeleteCart(cart_id);
		return "redirect:/cart?user_id=" + user_id;
	}

}