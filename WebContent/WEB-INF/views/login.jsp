<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="header.jsp" %>

<div class="container">
    <div class="text-center">
        <br><br><br><img src="public/img/templogo.png" width=300><br><br><br>
        <p>
            <a class="login-change on" href="#signin">登录</a>
            <a class="login-change" href="#signup">注册</a>
        </p>
        <form class="login-form signin-form" action="login" method="post" onsubmit="return login()">
            <br><br>
            <p>
                <label>邮箱：</label>
                <input class="login-input" type="email" name="email">
            </p>
            <p>
                <label>密码：</label>
                <input class="login-input" type="password" name="password">
            </p>
            <br>
            <input class="login-submit" type="submit" value="登录">
        </form>
        <form class="login-form signup-form" action="register" method="post" onsubmit="return login()" style="display: none">
            <br><br>
            <p>
                <label>用户名：</label>
                <input class="login-input" type="text" name="username">
            </p>
            <p>
                <label>邮箱：</label>
                <input class="login-input" type="email" name="email">
            </p>
            <p>
                <label>密码：</label>
                <input class="login-input" type="password" name="password">
            </p>
            <br>
            <input class="login-submit" type="submit" value="注册FACGN">
        </form>
    </div>
</div>
<%@include file="foot.jsp" %>
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
        signinContent='<div class="signin"><p><label>邮箱：</label><input class="login-input" type="text" name="user"></p><p><label>密码：</label> <input class="login-input" type="password" name="password"></p></div><input class="login-submit" type="submit" value="登录">';
        signupContent='<div class="signup"><p><label>用户名：</label><input class="login-input" type="text" name="user"></p><p><label>邮箱：</label><input class="login-input" type="password" name="email"></p><p><label>密码：</label><input class="login-input" type="password" name="password"></p></div>';
        $('.login-change[href="#signin"]').click(function () {
            if($(this).hasClass('on'))return;
            $(this).addClass('on');
            $('.login-change[href="#signup"]').removeClass('on');
            $('.signin-form').css({display:'inline-block'});
            $('.signup-form').css({display:'none'})
        })
        $('.login-change[href="#signup"]').click(function () {
            if($(this).hasClass('on'))return;
            $(this).addClass('on');
            $('.login-change[href="#signin"]').removeClass('on');
            $('.signin-form').css({display:'none'});
            $('.signup-form').css({display:'inline-block'})
        })
    });
</script>
</body>
</html>
