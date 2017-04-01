package com.dav.shopping.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dav.shopping.entity.PostCategory;
import com.dav.shopping.service.PostCategoryService;


@RestController("clientHome")
@RequestMapping({"home","/"})
public class HomeController {

	private PostCategoryService postCategoryService;

	@Autowired(required = true)
	@Qualifier(value = "postCategoryService")
	public void setPersonService(PostCategoryService ps) {
		this.postCategoryService = ps;
	}
	
	@RequestMapping({"index","/"})
	public String Hello(){
		return "Hello Client";
	}
/*
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String Hello(Model model) {
		model.addAttribute("postCategory", new PostCategory());
		System.out.println(postCategoryService.getAll().size());
		model.addAttribute("ListPostCategory", this.postCategoryService.getAll().get(0));
		return "admin/index";
	}
*/
}
