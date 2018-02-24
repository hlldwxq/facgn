<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" /> 
<!doctype html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="${ctx}/public/apple-touch-icon.png">
    <link rel="stylesheet" href="${ctx}/public/css/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/public/css/main.css">
    <link rel="stylesheet" href="${ctx}/public/css/style.css">
    <link rel="stylesheet" href="${ctx}/public/css/tropes.css">
    <link rel="stylesheet" href="${ctx}/public/css/cropper.min.css">    
    <link rel="stylesheet" href="${ctx}/public/css/froala/froala_editor.pkgd.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
	<script src="${ctx}/public/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <style>
        body {
            padding-top: 100px;
            padding-bottom: 20px;
            background: #f2f2f2;
        }
    </style>
</head>
<body>
<!--[if lt IE 8]>
<p class="browserupgrade">浏览器版本<strong>过旧</strong>建议<a
        href="https://www.baidu.com/s?wd=%E6%B5%8F%E8%A7%88%E5%99%A8/">升级</a>你的浏览器</p>
<![endif]-->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button><!-- -------------------------here------------ -->
            <a class="navbar-brand" href="${ctx}/index"><img src="${ctx}/public/img/templogo.png" height="100%"></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav nav-list" style="float: none">
                <li><a class="film-hover" href="#">桥段</a></li>
                <li><a class="animation-hover" href="#">角色</a></li>
                <li><a class="comic-hover" href="#">电影</a></li>
                <li><a class="game-hover" href="#">演员</a></li>
                <c:if test="${sessionScope.user==null}">
	                <li class="pull-right"><a href="${ctx}/login">注册</a></li>
	                <li class="pull-right">
	                    <a href="${ctx}/login">登录</a>
	                </li>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                	<li class="pull-right">
	                    <a href="${ctx}/logout">退出</a>
	                </li>
                	<li class="pull-right"><a href="${ctx}/myInformation">${user.username}</a></li>
	                
                </c:if>
                <li class="pull-right">
                    <form id="navbarSearch" class="navbar-form" role="search" action="" style="width: 360px;position: relative;padding: 0;margin-right: 20px;opacity: 0;transition: opacity .3s">
                            <input name="kw" type="text" class="form-control" style="width: 100%;position: absolute;" placeholder="输入桥段、角色或电影名称" search-tooltip-type="1">
                        <button name="method" value="search" type="submit" class="search-button" style="height: 34px;width: 60px;position: absolute;"><span class="glyphicon glyphicon-search"></span></button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
