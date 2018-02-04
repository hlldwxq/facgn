<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<%@page import="com.bridgePlot.entity.Plot"%>
<%@page import="com.bridgePlot.entity.MoviePlot"%>
<link rel="stylesheet" href="${ctx}/public/css/froala/froala_editor.pkgd.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
<div class="container">
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-context row">
        	
            <form  name="form" method="post" action="${ctx}/add"  enctype="multipart/form-data" onsubmit="improveSubmit()">
            
            <div class="tropes-basic">
                <h2 style="float: right"><small>新增桥段</small></h2>
				<c:if test="${plot!=null}">
					<input name="edittick" class="hide" type="text" value="${plot.edit_tick}">
					<input name="absoluteid" class="hide" type="text" value="${plot.absolute_id}">
					<input name="plotpic" class="hide" type="text" value="${plot.plot_pic}">
				</c:if>
                <input name="plotname" class="title-input" type="text" placeholder="输入标题" style="font-size: 36px" value="${plot.plot_name}">
                <!--之后改进为有限制的控件-->
                <input name="label" class="title-input" type="text" placeholder="输入类型，“·”号分隔" style="font-size: 30px;color: grey;margin-bottom: 20px" value="${plot.plot_label_1}·${plot.plot_label_2}·${plot.plot_label_3}">
                
                <input name="pasttime" class="title-input" type="text" placeholder="输入桥段间隔" style="font-size: 22px;color: grey;margin-bottom: 20px" value="">
               
                <div class="col-xs-9 row">
                    <div class="fr-area" id="plotEdit">
                        <p>
                            ${plot.plot_content}
                        </p>
                    </div>
                </div>
                <textarea id="content" class="form-control hide" rows="3"name="content"></textarea>
                <div class="col-xs-3 row" style="margin-left: 20px;padding-right: 0">
                    <div class="ycupload-mainbox">
                        <div style="min-height:1px;line-height:160px;text-align:center;position:relative;" ontouchstart="">
                            <div class="cover-wrap" style="display:none;position:fixed;left:0;top:0;width:100%;height:100%;background: rgba(0, 0, 0, 0.4);z-index: 1000;text-align:center;">
                                <div class="" style="width:900px;height:600px;margin:100px auto;background-color:#FFFFFF;overflow: hidden;">
                                    <div id="clipArea" style="margin:10px;height:520px;"></div>
                                    <div id="clipBtn" class="submit-button" style="width:120px;height:36px;margin: 0 auto;">保存图片</div>
                                </div>
                            </div>
                            <div style='width:100%;height:280px;box-shadow: 1px 0 2px 2px rgba(0, 0, 0, 0.12);border-top: 2px solid #d0492d;padding: 5px;margin-bottom: 10px'>
                                
                                <c:if test="${plot!=null}">
                                	<div id="view" style='width:100%;height:100%;background-image:url("${plot.plot_pic}");'></div>
                                </c:if>
                                <c:if test="${plot==null}">
                                	<div id="view" style='width:100%;height:100%;background-image:url("public/img/tropes-1.png");'></div>
                                </c:if>
                                <input id="cutImage" type="text" class="hide" name="cutImage">
                            </div>

                            <div class="" style="width:100%;height:30px;background-color:#d0492d;color: #FFFFFF;font-size: 14px;text-align:center;line-height:32px;outline:none;position:relative;">
                                                                                     点击上传封面
                                <input type="file" id="file" name="image" style="cursor:pointer;opacity:0;filter:alpha(opacity=0);width:100%;height:100%;position:absolute;top:0;left:0;">
                                <input id="isNew" name="isNew" class="hide" type="text" value="0">

                            </div>

                        </div>
                    </div>

                </div>
            </div>
            <div class="col-md-offset-4 col-md-4">
                <input name="submit" id="submitEdit" class="submit-button" type="submit" value="提交桥段">
            </div>
            </form>
        </div>
    </div>

</div>
<hr>

<%@include file="foot.jsp" %>
<script src="${pageContext.request.contextPath}/public/js/froala/froala_editor.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/public/js/froala/languages/zh_cn.js"></script>
<script src="${pageContext.request.contextPath}/public/js/cover_js/iscroll-zoom.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/public/js/cover_js/hammer.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/public/js/cover_js/lrz.all.bundle.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/public/js/cover_js/jquery.photoClip.min.js" type="text/javascript" charset="utf-8"></script>
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
            heightMin: 280,
            language: 'zh_cn',
        })
        var clipArea = new bjj.PhotoClip("#clipArea", {
            size: [300, 400],// 截取框的宽和高组成的数组。默认值为[260,260]
            outputSize: [300, 400], // 输出图像的宽和高组成的数组。默认值为[0,0]，表示输出图像原始大小
            //outputType: "jpg", // 指定输出图片的类型，可选 "jpg" 和 "png" 两种种类型，默认为 "jpg"
            file: "#file", // 上传图片的<input type="file">控件的选择器或者DOM对象
            view: "#view", // 显示截取后图像的容器的选择器或者DOM对象
            ok: "#clipBtn", // 确认截图按钮的选择器或者DOM对象
            loadStart: function () {
                // 开始加载的回调函数。this指向 fileReader 对象，并将正在加载的 file 对象作为参数传入
                $('.cover-wrap').fadeIn();
                console.log("照片读取中");
            },
            loadComplete: function () {
                // 加载完成的回调函数。this指向图片对象，并将图片地址作为参数传入
                console.log("照片读取完成");
            },
            //loadError: function(event) {}, // 加载失败的回调函数。this指向 fileReader 对象，并将错误事件的 event 对象作为参数传入
            clipFinish: function (dataURL) {
                // 裁剪完成的回调函数。this指向图片对象，会将裁剪出的图像数据DataURL作为参数传入
                $('.cover-wrap').fadeOut();
                $('#view').css('background-size', '100% 100%');
                $('#isNew').val(1)
                //console.log(dataURL);
            }
        });
    });
    function improveSubmit() {
        //数据验证
        //省略
        $('#content').val($('#plotEdit').froalaEditor('html.get'));
        console.log($('#content').val());
        var reg=/^url\("(.*)"\)$/
        $('#cutImage').val($('#view').css('background-image').match(reg)[1])
    }
</script>