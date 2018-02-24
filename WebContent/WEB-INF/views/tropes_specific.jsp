<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>

<div class="container">
    <!-- Example row of columns -->
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-operate row">
            <a href="${ctx}/addMoviePlot">创建新条目</a>
            <a href="#">引用</a>
            <a href="#">分享</a>
        </div>
    </div>
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-context">
            <div class="tropes-basic">
                <img class="tropes-pic" src="${moviePlot.plot_pic}" align="right" hspace="30" vspace="15">
                <h1 style="margin-top: 20px;margin-bottom: 5px;"><strong>${moviePlot.plot_name}.${moviePlot.plot_at_movie}</strong></h1>
                <a class="edit-button" href="${ctx}/reviseMoviePlot/${moviePlot.absolute_id}">编辑</a>
                <h2 style="color:gray;font-weight: bold;">${moviePlot.label}<br><small>${moviePlot.begin_time}-${moviePlot.end_time}</small></h2>
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
                            <li><span>${other.label}</span><span>${other.begin_time}---${other.end_time}</span><a class="relate-detail" href="${ctx}/movieplot/${other.id}">详情</a>
                                <p>${other.plot_content}</p>
                            </li>
                        </ul>
                    </li>
                    </c:forEach>
                   
                </ul>
            </div>
        </div>
    </div>
    <hr>
</div>
<div class="container">
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <h2>评论</h2>
        <div id="usercomments">
           
        </div>
        <div class="row tropes-context">
            <button id="getmore" type="button" class="btn btn-light btn-block" onclick="appendMoreText()">查看更多</button>
        </div>
        <div class="row tropes-context">
            <div class="fr-area" id="plotEdit">
                <p>
                </p>
            </div>
            <textarea id="content" class="form-control hide" rows="3"name="content"></textarea>
            <button name="submit" id="submit" class="submit-button" type="submit" onclick="improveSubmit()">提交</button>
        </div>
    </div>
</div>

<script src="${ctx}/public/js/vendor/jquery.js"></script>
<script src="${ctx}/public/js/vendor/bootstrap.min.js"></script>
<script src="${ctx}/public/js/froala/froala_editor.pkgd.min.js"></script>
<script src="${ctx}/public/js/froala/languages/zh_cn.js"></script>
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
	    $('#plotEdit').froalaEditor({
	        toolbarButtons: ['bold', 'italic', 'underline', '|', 'undo', 'redo'],
	        pluginsEnabled: ['paragraphFormat', 'align', 'lists'],
	        heightMin: 150,
	        language: 'zh_cn',
	    });
	});
	
	function improveSubmit() {
	    //数据验证
	    //省略
	    //为什么这个就不提醒 评论成功呢？？？？角色哪里也不提醒
	    $('#content').val($('#plotEdit').froalaEditor('html.get'));
	    console.log($('#content').val());
	    $.post("${ctx}/comment/moviePlot",//提交接口
	        {
	            movie_plot_id:${moviePlot.id},
	            content: $('#content').val()//提交信息
	        },
	        function(data,status){
	            alert("评论成功");
	        });
	}
	
	function appendMoreText() {
	    $.get('${ctx}/moviePlotComment/${moviePlot.id}',function (data,status) {
	        //console.log(data);
	        var i;
	        for(i=0;i<data.length;i++){
	            commentdiv = '<div class="row tropes-context"> <div class="user-comments"> <div class="col-md-2 column"> <img alt="140x140" src="resource/hmbb.png"/> </div> <div class="col-md-10 column"> <h5>'+data[i].name+'</h5> '+data[i].comment+'<a>点赞</a> </div> <div class="col-md-2 column"> </div> </div> </div>';
	            $("#usercomments").append(commentdiv);
	        }
	    });
	}

</script>
</body>
</html>
