package com.dao.blog.domain.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="POST_SAMPLE", uniqueConstraints= {@UniqueConstraint(columnNames= {"post_id"})})
public class Post {
	@Id
	@GeneratedValue
	@Column(name="POST_ID")
	int id;
	@Column(name="SUBJECT")
	String subject;
	
	@Column(name="SUB_SUBJECT")
	String sub_subject;
	
	
	@Column(name="CONTENT", length = 100000000)
	String content;

	@Column(name="REG_DATE")
	Date regDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSub_subject() {
		return sub_subject;
	}

	public void setSub_subject(String sub_subject) {
		this.sub_subject = sub_subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
}
