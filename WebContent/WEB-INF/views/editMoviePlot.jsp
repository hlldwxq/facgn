<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<%@page import="com.bridgePlot.entity.MoviePlot"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<link rel="stylesheet" href="${ctx}/public/css/bootstrap.css">
<style>
    body {
        padding-top: 100px;
        background: #f2f2f2;
    }
     .modal img {
         width: 400px;
         height: 400px;
     }
</style>
<link rel="stylesheet" href="${ctx}/public/css/cropper.min.css">
<link rel="stylesheet" href="${ctx}/public/css/froala/froala_editor.pkgd.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css">
<div class="container">
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="tropes-context row">
            <form  name="form" method="post" action="${ctx}/reviseMoviePlot/${plot.absolute_id}"  enctype="multipart/form-data" onsubmit="improveSubmit()">
            <div class="tropes-basic">
                <h2 style="float: right"><small>新增电影桥段</small></h2>

                <input name="plot_name" class="title-input" type="text" placeholder="输入标题" style="font-size: 36px" value="${plot.plot_name}·${plot.plot_at_movie}">
                <!--之后改进为有限制的控件-->
                <div>
                    <div class="label-content" label="0">
                    </div>
                    <input type="button" value="+" class="title-add" title="添加标签" target=".label-content">
                    <input id="label" type="text" name="label" style="display: none" value="${plot.label}">
                </div>
                <input name="pasttime" class="title-input" type="text" placeholder="输入桥段间隔" style="font-size: 22px;color: grey;margin-bottom: 20px" value="${plot.begin_time}-${plot.end_time}">
                <div class="col-xs-9 row">
                    <div class="fr-area" id="plotEdit">
                        <p>${plot.plot_content}</p>
                    </div>
                </div>
                <textarea id="content" class="form-control hide" rows="3"name="plot_content"></textarea>
                <div class="col-xs-3 row" style="margin-left: 20px;padding-right: 0">
                    <div class="crop-picture">
                        <div style="min-height:1px;line-height:160px;text-align:center;position:relative;"
                             ontouchstart="">
                            <div style='display:table;width:100%;height:320px;box-shadow: 1px 0 2px 2px rgba(0, 0, 0, 0.12);border-top: 2px solid #d0492d;padding: 1px;margin-bottom: 10px;background: url("${ctx}/public/img/selectImg.jpg");background-size:contain;' data-target="#modal" data-toggle="modal">
                                <span style="display: table-cell; vertical-align: middle; "><img id="view" style='width:100%;' src="${plot.plot_pic}"></span>
                            </div>
                            <input id="cutImage" type="text" class="hide" name="cutImage">
                            <input id="isNew" name="isNew" class="hide" type="text" value="0">
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
<div class="modal fade" id="modal" aria-labelledby="modalLabel" role="dialog" tabindex="-1">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <label class="modal-title" id="modalLabel">裁剪封面图像</label>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div>
                    <img id="image" src="${plot.plot_pic}" alt="Picture">
                </div>
            </div>
            <div class="modal-footer">
                <div class=""
                     style="width:65%;height:30px;background-color:#d0492d;color: #FFFFFF;font-size: 14px;text-align:center;line-height:32px;outline:none;position:relative;display: inline-block" >
                    点击上传封面
                    <input type="file" id="inputImage" name="image" style="cursor:pointer;opacity:0;filter:alpha(opacity=0);width:100%;height:100%;position:absolute;top:0;left:0;" accept=".jpg,.jpeg,.png,.gif,.bmp,.tiff">

                </div>
                <div id="confirmCut" style="width:30%;height:30px;background-color:#d0492d;color: #FFFFFF;font-size: 14px;text-align:center;line-height:32px;outline:none;position:relative;display: inline-block;cursor: pointer">
                    确定
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
    <p>&copy;2017 中国传媒大学智能标签实验室</p>
</footer>
</div> <!-- /container -->
<script src="${ctx}/public/js/vendor/jquery.js"></script>
<script src="${ctx}/public/js/vendor/bootstrap.min.js"></script>
<script src="${ctx}/public/js/froala/froala_editor.pkgd.min.js"></script>
<script src="${ctx}/public/js/froala/languages/zh_cn.js"></script>
<script src="${ctx}/public/js/cropper/cropper.min.js"></script>
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
        $('.title-add').click(function () {
            labelBox=$($(this).attr('target'));
            num=labelBox.attr('label')*1+1;
            label=$('<input class="title-input title-label" type="text" placeholder="输入标签" value="">');
            label.blur(function () {
                if($(this).val()=='')
                {
                    num=$(this).parent().attr('label')*1;
                    if(num<=1)
                        return;
                    num--;
                    $(this).parent().attr('label',num)
                    $(this).remove()
                    if(num<4)
                    {
                        $('.title-add').css({display:'inline-block'});
                    }
                }
            })
            labelBox.append(label);
            labelBox.attr('label',num);
            if(num>=4)
                $(this).css({display:'none'});
            label.focus();
        })
        var labelContent=$('#label').val().split('·')
        for(var i=0;i<labelContent.length;i++)
        {
            $('.title-add').click();
            $($('.title-add').attr('target')).children().last().val(labelContent[i])
        }
    });
    $(function () {
        var $image = $('#image');
        var cropBoxData;
        var canvasData;
        var options={
            autoCropArea: 0.7,
            viewMode:2,
            ready: function () {
                $image.cropper('setCanvasData', canvasData);
                $image.cropper('setCropBoxData', cropBoxData);
            }
        }
        $('#modal').on('shown.bs.modal', function () {
            $image.cropper(options);
        })
        $('#confirmCut').on('click', function () {
            cropBoxData = $image.cropper('getCropBoxData');
            cropPicData = $image.cropper('getData');
            console.log(cropBoxData)
            console.log(cropPicData)
            $('#view').attr('src',$image.cropper('getCroppedCanvas',{}).toDataURL('image/jpeg'))
            $('button[data-dismiss="modal"]').click()
            $('#isNew').val(1)
            //$image.cropper('destroy');
        });
        // Import image
        var $inputImage = $('#inputImage');

        if (URL) {
            $inputImage.change(function () {
                var files = this.files;
                var file;
                if (!$image.data('cropper')) {
                    return;
                }
                if (files && files.length) {
                    file = files[0];
                    if (/^image\/\w+$/.test(file.type)) {
                        var uploadedImageURL = URL.createObjectURL(file);
                        $image.cropper('destroy').attr('src', uploadedImageURL).cropper(options);
                        $inputImage.val('');
                    } else {
                        window.alert('请选择正确的图片文件');
                    }
                }
            });
        } else {
            $inputImage.prop('disabled', true).parent().addClass('disabled');
        }
    });
    function improveSubmit() {
        //数据验证
        //省略
        var label='';
        var allLabel=$('.title-label')
        for(var i=0;i<allLabel.length;i++)
        {
            label+=$(allLabel[i]).val()+(i==allLabel.length-1?'':'·')
        }
        $('#label').val(label);
        $('#content').val($('#plotEdit').froalaEditor('html.get'));
        //console.log($('#content').val());
        $('#cutImage').val($('#view').attr('src'))
        return true
    }
</script>
</body>
</html>