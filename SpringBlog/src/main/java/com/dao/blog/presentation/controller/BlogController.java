package com.dao.blog.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.blog.domain.model.entity.Post;
import com.dao.blog.infrastructure.dao.PostDAO;

@Controller
public class BlogController {

	@Autowired
	private PostDAO postDao;
	
	@RequestMapping({ "/" })
	public String index(Model model) {
		model.addAttribute("home_title", "Clean TigerDao Blog Home");
		model.addAttribute("home_content", "Welcome to A TigerDao Blog Theme by Start Bootstrap");
		return "index";
	}
	
	@RequestMapping({ "/blog" })
	public String blog(Model model) {
		model.addAttribute("blog_title", "Clean TigerDao Blog");
		model.addAttribute("blog_content", "A TigerDao Blog Theme by Start Bootstrap");
		List<Post> post_list = postDao.findAll();
		System.out.println("[PostController] list post : "+post_list);
		model.addAttribute("post_list", post_list);
		return "blog";
	}
	
	@RequestMapping({ "/post" })
	public String post(Model model) {
		model.addAttribute("blog_title", "Clean TigerDao Blog");
		model.addAttribute("blog_content", "A TigerDao Blog Theme by Start Bootstrap");
		System.out.println("[BlogController] post : "+model);
		return "post";
	}
	
	@RequestMapping({"/hello" })
	public String hello(Model model) {
		model.addAttribute("name", "SpringBlog from Dao");
		return "hello";
	}
}
