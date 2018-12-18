package com.dao.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.blog.domain.model.entity.Post;

public interface PostDAO extends JpaRepository<Post, Integer>{
	Post findOneById(int id);
	Post findOneBySubject(String subject);
}
