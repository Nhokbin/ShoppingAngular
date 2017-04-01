package com.dav.shopping.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminController")
@RequestMapping("/admin")
public class HomeController {
	
	@RequestMapping("/index")
	public String home() {
		return "admin/index";
	}
}
