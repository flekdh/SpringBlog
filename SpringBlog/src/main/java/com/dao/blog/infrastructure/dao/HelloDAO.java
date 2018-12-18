package com.dao.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dao.blog.domain.model.entity.Hello;

public interface HelloDAO extends JpaRepository<Hello, Integer>{

}
