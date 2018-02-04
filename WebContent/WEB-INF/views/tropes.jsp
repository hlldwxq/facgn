<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<div class="container">
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-operate row">
            <a href="${ctx}/save">创建新条目</a>
            <a href="#">引用</a>
            <a href="#">分享</a>
        </div>
    </div>
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-context row">
            <div class="tropes-basic">
                <img class="tropes-pic" src="${plot.plot_pic}" align="right" hspace="30" vspace="15">
                <h1 style="margin-top: 20px;margin-bottom: 5px;"><strong>${plot.plot_name}</strong></h1>
                <a class="edit-button" href="${ctx}/revise/plot/${plot.absolute_id}">编辑</a>
                <h2 style="color:gray;font-weight: bold;">${plot.plot_label_1}.${plot.plot_label_2}.${plot.plot_label_3}</h2>
                <p>
                   	 什么是${plot.plot_name}：${plot.plot_content}
                </p>
            </div>
            <div class="tropes-related">
                <h2 style="margin-top: 30px;margin-bottom: 0px;">呈现</h2>
                <ul class="relate-first">
                    <li>
                        <a class="edit-button" href="">编辑</a>
                        <h3>电影</h3>
                        <ul class="relate-second">
                        	<c:forEach items="${moviePlot}" var="movie">
	                            <li>
	                                <a class="relate-movie" href="${ctx}/movieplot/${movie.id}">${movie.plot_at_movie}</a>
	                                <span>${movie.begin_time}-${movie.end_time}</span>
	                                <a class="relate-detail" href="${ctx}/movieplot/${movie.id}">详情</a>
	                                <p>${movie.plot_content}</p>
	                            </li>
                            </c:forEach>
                            
                        </ul>
                    </li>
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h3>动画</h3>
                    </li>
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h3>游戏</h3>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
</div>


<hr>
</div> <!-- /container -->

<script src="${ctx}/public/js/vendor/jquery.js"></script>
<script src="${ctx}/public/js/vendor/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $(document).scroll(function () {
            var distance = $(document).scrollTop();
            //console.log(distance);
            if (distance >= 300) {
            }
            else {
            }
        });

    });

</script>
</body>
</html>