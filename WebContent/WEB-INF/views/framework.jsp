<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <link rel="apple-touch-icon" href="public/apple-touch-icon.png">

    <link rel="stylesheet" href="public/css/bootstrap.css">
    <style>
        body {
            padding-top: 70px;
            padding-bottom: 20px;
            background: #f2f2f2;
        }
    </style>
    <link rel="stylesheet" href="public/css/main.css">
    <link rel="stylesheet" href="public/css/style.css">
    <script src="public/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>

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
            <a class="navbar-brand" href="index.html"><img src="public/img/templogo.png" height="100%"></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="nav navbar-nav nav-list" style="float: none">
                <li><a class="film-hover" href="#">桥段</a></li>
                <li><a class="animation-hover" href="#">角色</a></li>
                <li><a class="comic-hover" href="#">电影</a></li>
                <li><a class="game-hover" href="#">演员</a></li>
                <li class="pull-right"><a href="#">注册</a></li>
                <li class="pull-right">
                    <a data-toggle="modal" data-target="#log_part" href="#">登录</a>
                </li>
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


<div class="container">
    <!-- Example row of columns -->

    <hr>

    <footer>
        <p>&copy;2017 中国传媒大学智能标签实验室</p>
    </footer>
</div> <!-- /container -->
<script src="public/js/vendor/jquery.js"></script>
<script src="public/js/vendor/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(document).scroll(function () {
            var distance=$(document).scrollTop();
            //console.log(distance);
            if(distance>=300)
            {
            }
            else
            {
            }
        });

    });

</script>
</body>
</html>
