<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hello Spring Blog</title>

    <!-- Custom fonts for this template -->
    <link href="<c:url value="/static/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/static/css/clean-blog.min.css" />" rel="stylesheet">
    
	<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
	<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
	<script src="/webjars/origoni-startbootstrap-clean-blog/1.0.3/js/clean-blog.min.js"></script>
	<style type="text/css">
	.deleteBtn {display: inline; padding: 10px;}
	</style>
</head>
<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="/">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/hello">Hello</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/blog">Blog</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/post/list">Post</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact.html">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <!-- Page Header -->
    <header class="intro-header" style="background-image: url('/static/img/home-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto col-md-10 col-md-offset-1">
            <div class="site-heading">
              	<h1>${blog_title}</h1>
                <hr class="small">
              	<span class="subheading">${blog_content}</span>
            </div>
          </div>
        </div>
      </div>
    </header>
    

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-lg-offset-2 col-md-10 col-md-offset-1" style="padding: 10px; margin-bottom: 20px;">
		    	<button type="button" class="btn btn-warning btn-sm" onClick="location.href='/post/write'"
		    		style="float: right;">새로운 포스트 작성하기</button>
		    </div>
            <div class="col-lg-12 col-lg-offset-2 col-md-10 col-md-offset-1">
			<c:forEach var="post" items="${postList}">
				<div class="post-preview" style="height:150px; padding: 20px; margin-bottom: 20px;">
					<div style="display: inline; float: left; top:50%; left:50%;">
	                    <a href="/post/${post.id}">
	                        <h2 class="post-title">
	                            ${post.subject}
	                        </h2>
	                        <h3 class="post-subtitle">
	                           	 ${post.sub_subject}
	                        </h3>
	                    </a>
                    	<p class="post-meta">Posted by <a href="#">Origoni</a> on ${post.regDate}</p>
                    </div>
					<div style="display: inline; float: right;">
        				<button type="button" class="btn btn-sm btn-danger" onClick="location.href='/post/${post.id}/delete'">삭제</button>
        			</div>
                </div>
                <hr>
			</c:forEach>
			
                <!-- Pager -->
                <ul class="pager">
                    <li class="next">
                        <a href="#">Older Posts &rarr;</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-lg-offset-2 col-md-10 col-md-offset-1">
                    <ul class="list-inline text-center">
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>