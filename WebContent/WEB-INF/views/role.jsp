<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<div class="container">
    <!-- Example row of columns -->
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-operate">
                <a href="${ctx}/addRole">创建新条目</a>
                <a href="#">引用</a>
                <a href="#">分享</a>
        </div>
    </div>
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-context">
            <div>
                <img class="tropes-pic" src="${role.role_pic}" align="right"  hspace="50" vspace="50">
                <h1 style="margin-top: 20px;margin-bottom: 5px;"><strong>${role.role_name}</strong></h1>
                <a class="edit-button" href="${ctx}/reviseRole/${role.absolute_id}">编辑</a>
                <h2 style="color:gray;font-weight: bold;">${role.role_name}</h2>
                <p>
                <ul class="role-info" style=" background-color: #F0F0F0; width:55%;">
                    <li>出处：<a href="${ctx}/movie/${role.movie_id}">${role.role_at_movie}</a></li>
                    <li>扮演者：${role.actor}</li>
                    <li>身份职业：${role.role_profession}</li>
                    <li>国籍：${role.role_country}</li>
                </ul>
                </p>
            </div>
            <div>
                <ul class="relate-first">
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h2 style="margin-top:30px;">人物介绍</h2>
                        <p>${role.role_introduction}</p>
                    </li>
                    <li>
                        <a class="edit-button" href="#">编辑</a>
                        <h2 style="margin-top:30px;">类似角色</h2>
                    </li>
                    <c:forEach items="${similarRole}" var="otherRole">
	                    <li class="row">
	                        <div class="col-md-2">
	                            <img src="${otherRole.role_pic}"   height="100px" width="80px">
	                        </div>
	                        <div class="col-md-10">
	                            <ul class="relate-second">
	                                <li><span>${otherRole.role_name}</span><a href="${ctx}/movie/${otherRole.movie_id}"><span>《${otherRole.role_at_movie}》</span></a> <a class="relate-detail" href="${ctx}/movierole/${otherRole.id}">详情</a></li>
	             					<li>
	             						${otherRole.role_introduction}
	                                </li>
	                            </ul>
	
	                        </div>
	                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
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
	    })
	});
	function improveSubmit() {
	    //数据验证
	    //省略
	    $('#content').val($('#plotEdit').froalaEditor('html.get'));
	    console.log($('#content').val());
	    $.post("${ctx}/comment/movieRole",//提交接口
	        {
	            role_id:${role.id},
	            content: $('#content').val()//提交信息
	        },
	        function(data,status){
	            alert("评论成功");
	        });
	}
	
	function appendMoreText() {
	    $.get('${ctx}/roleComment/${role.id}',function (data,status) {
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