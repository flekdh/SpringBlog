package com.dao.blog.presentation.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.blog.domain.model.entity.Post;
import com.dao.blog.infrastructure.dao.PostDAO;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostDAO postDao;

	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String form(Post post) {
		return "post_form";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@Valid Post post, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "post_form";
		}
		post.setRegDate(new Date());
		return "redirect:/post/" + postDao.save(post).getId();
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Post> postList = postDao.findAll();
		model.addAttribute("postList", postList);
		return "blog";
	}

	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOneById(id);
		model.addAttribute("post", post);
		return "post";
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editor(Model model, @PathVariable int id) {
		Post post = postDao.findOneById(id);
		model.addAttribute("post", post);
		return "post_form";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String edit(@Valid Post post, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "redirect:/post/" + postDao.save(post).getId();
	}
	
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		postDao.deleteById(id);
		return "redirect:/post/list";
	}
	
	/* 2018.12.17 이다빈 */
	/* API 요청 방식 */
	@RequestMapping("/api/list")
	@ResponseBody
	public List<Post> api_list(Model model) {
		List<Post> postList = postDao.findAll();
		return postList;
	}

	@RequestMapping("/api/{id}")
	@ResponseBody
	public Post api_view(Model model, @PathVariable int id) {
		Post post = postDao.findOneById(id);
		return post;
	}
}