<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="container">
    <!-- Example row of columns -->
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-operate row">
            <a href="#">创建新条目</a>
            <a href="#">引用</a>
            <a href="#">分享</a>
        </div>
    </div>
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-context">
            <div class="tropes-basic">
                <img class="tropes-pic" src="${moviePlot.plot_pic}" align="right" hspace="30" vspace="15">
                <h1 style="margin-top: 20px;margin-bottom: 5px;"><strong>${moviePlot.plot_name}.${moviePlot.plot_at_movie}</strong></h1>
                <a class="edit-button" href="${ctx}/revise/movieplot/${plot.absolute_id}">编辑</a>
                <h2 style="color:gray;font-weight: bold;">${moviePlot.plot_label_1}.${moviePlot.plot_label_2}.${moviePlot.plot_label_3}<br><small>${moviePlot.begin_time}-${moviePlot.end_time}</small></h2>
                <p>
                    ${moviePlot.plot_content}              
                </p>
            </div>
            <div class="tropes-related">
                <h2 style="margin-top: 30px;margin-bottom: 0px;font-weight:bold;">${moviePlot.plot_at_movie} 其他桥段</h2>
                <ul class="relate-first">
                	<c:forEach items="${otherPlot}" var="other">
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h3>${other.plot_name}</h3>
                        <ul class="relate-second">
                            <li><span>${other.plot_label_1}</span><span>${other.begin_time}---${other.end_time}</span><a class="relate-detail" href="${ctx}/movieplot/${other.id}">详情</a>
                                <p>${other.plot_content}</p>
                            </li>
                        </ul>
                    </li>
                    </c:forEach>
                    <!--  
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h3>爱情</h3>
                        <ul class="relate-second">
                            <li><span>劫后余生萌生爱情</span><span>38：40---45:56</span><a class="relate-detail" href="#">详情</a>
                                <p>
                                    和冷锋一起护送与治疗疫情有极大关系的Pasha撤离。
                                </p></li>
                        </ul>
                    </li>-->
                </ul>
            </div>
        </div>
    </div>
    <hr>
</div>
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
