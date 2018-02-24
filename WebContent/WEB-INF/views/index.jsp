<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<script src="${ctx}/public/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<div class="banner">
    <div class="container">
        <div class="col-md-12 text-center">
            <img src="${ctx}/public/img/templogo.png" height="100%">
        </div>
        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-12">
            <br> <br>
            <div class="search-group">
            	<form method="post" action="${ctx}/search">
	                <input class="form-control search-box" type="text" name="search" placeholder="输入桥段、角色和电影名称">
	                <button class="search-button"><span class="glyphicon glyphicon-search"></span></button>
                </form>
            </div>

        </div>
    </div>
</div>
<div class="main-panel">
    <div class="container">
        <div class="control-panel">
            <div class="control-button">
                <span class="glyphicon glyphicon-th"></span>高级筛选
                <ul class="first-level" style="width: 500%">
                    <li>
                        <h4>类型:</h4>
                        <ul class="second-level">
                            <li>喜剧</li>
                            <li>动作</li>
                            <li>爱情</li>
                            <li>亲情</li>
                            <li>战斗</li>
                            <li>喜剧</li>
                            <li>动作</li>
                            <li>爱情</li>
                            <li>亲情</li>
                            <li>战斗</li>
                            <li>喜剧</li>
                            <li>动作</li>
                            <li>爱情</li>
                            <li>亲情</li>
                            <li>战斗</li>
                        </ul>
                    </li>
                    <li class="divide-line"></li>
                    <li>
                        <h4>题材:</h4>
                        <ul class="second-level">
                            <li>电影</li>
                            <li>动画</li>
                            <li>漫画</li>
                            <li>游戏</li>
                            <li>电影</li>
                        </ul>
                    </li>
                    <li class="divide-line"></li>
                    <li>
                        <h4>年龄:</h4>
                        <ul class="second-level">
                            <li>10+</li>
                            <li>20+</li>
                            <li>30+</li>
                            <li>40+</li>
                            <li>50+</li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="control-button"><span class="glyphicon glyphicon-sort"></span>排序
                <ul class="first-level vertical-list">
                    <li>人气</li>
                    <li class="divide-line"></li>
                    <li>拼音</li>
                </ul></div>
            <div id="plotRandom" class="control-button"><span class="glyphicon glyphicon-random"></span>随机</div>
            <div class="control-button">关键字：</div>
            <a href="${ctx}/addMoviePlot"><div class="control-button pull-right"><span class="glyphicon glyphicon-plus"></span>电影桥段</div></a>
            <a href="${ctx}/addPlot"><div class="control-button pull-right"><span class="glyphicon glyphicon-plus"></span>新增桥段</div></a>
            <a href="${ctx}/addRole"><div class="control-button pull-right"><span class="glyphicon glyphicon-plus"></span>新增角色</div></a>
        </div>
        <div id="plotWrapper" class="waterfall" style="opacity: 0">
            
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/1.jpg" class="img-responsive"></a>
                    <h4>场面</h4>
                    <p>宏大场面</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/2.jpg" class="img-responsive"></a>
                    <h4>奋斗</h4>
                    <p>个人的奋斗</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/3.jpg" class="img-responsive"></a>
                    <h4>战斗</h4>
                    <p>黄雀在后</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/4.jpg" class="img-responsive"></a>
                    <h4>亲情</h4>
                    <p>父女相认</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/5.jpg" class="img-responsive"></a>
                    <h4>动作</h4>
                    <p>致命一击</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/6.jpg" class="img-responsive"></a>
                    <h4>追逐</h4>
                    <p>汽车追逐</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/7.jpg" class="img-responsive"></a>
                    <h4>战斗</h4>
                    <p>弓箭巧斗现代武器</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/8.jpg" class="img-responsive"></a>
                    <h4>追逐</h4>
                    <p>小巷追逐</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/9.jpg" class="img-responsive"></a>
                    <h4>喜剧</h4>
                    <p>团圆结局</p>
                </div>
            </div>
            <div class="plot-box">
                <div class="plot-content">
                    <a href="#"><img src="/facgnImg/plot/10.jpg" class="img-responsive"></a>
                    <h4>科幻</h4>
                    <p>外星人来临</p>
                </div>
            </div>
        </div>
        <div class="shift-filter">
            <p id="plotClick" class="on">桥段</p>
            <p class="divide-line"></p>
            <p id="roleClick" class="">角色</p>
        </div>
    </div>
    <div class="container">
        <div class="page-controller">
            <div id="pageTop" class="page-button">
                <span class="glyphicon glyphicon-chevron-up"></span>
            </div>
            <div id="newPlot" class="page-button">
                <span class="glyphicon glyphicon-plus"></span>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <!-- Example row of columns -->

    <hr>

    <footer>
        <p>&copy;2017 中国传媒大学智能标签实验室</p>
    </footer>
</div> <!-- /container -->
<script src="${ctx}/public/js/vendor/jquery.js"></script>
<script src="${ctx}/public/js/vendor/bootstrap.min.js"></script>
<script src="${ctx}/public/js/vendor/masonry.pkgd.min.js"></script>
<script src="${ctx}/public/js/vendor/imagesloaded.pkgd.min.js"></script>
<script src="${ctx}/public/js/main.js"></script>
<script>
    $(document).ready(function () {
        var $container = $('#plotWrapper');
        var plotdata = [
            {'img': 'resource/poster/1.jpg', 'type': '卢本伟牛逼', 'name': '致命一击', 'url': ''},
            {'img': 'resource/poster/2.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/3.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/4.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/5.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/6.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/7.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/8.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'},
            {'img': 'resource/poster/9.jpg', 'type': '卢本伟牛逼', 'name': '致命一击'}
        ];
        function updata(data) {
            var plotbox = '';
            var temp = [];
            for (var i=0; i<data.length; i++)
            {
                temp.push(i);
            }
            for (var i=0;i<data.length;i++)
            {
                var rand = parseInt(Math.random() * (temp.length));
                plotbox += '<div class="plot-box"><div class="plot-content"> <a href="'+data[temp[rand]].url+'"><img src="'+data[temp[rand]].img+'" class="img-responsive"></a> <h4>'+data[temp[rand]].type+'</h4> <p>'+data[temp[rand]].name+'</p> </div> </div>';
                temp.splice(rand,1);
            }
            plotbox=$(plotbox);
            $container.imagesLoaded(function () {
                $container.append(plotbox).masonry('appended',plotbox)
            });
        }
        $container.imagesLoaded(function () {
            $container.masonry({
                itemSelector: '.plot-box',
                singleMode: true,
                isAnimated: true,
                percentPosition: true,
                columnWidth:'.plot-box'
            });
        });
        $container.animate({opacity:1});
        $(document).scroll(function () {
            var distance=$(document).scrollTop();
            //console.log(distance);
            if(distance>=300)
            {
                $('#navbarSearch').css({opacity:1});
                $('.page-controller').css({display:'block'});
                $('.page-controller').css({opacity:1})
            }
            else
            {
                $('#navbarSearch').css({opacity:0});
                $('.page-controller').css({opacity:0});
                $('.page-controller').css({display:'none'});
            }
            if(distance>=430)
            {
                $('.shift-filter').css({position:'fixed'});
            }
            else
            {
                $('.shift-filter').css({position:'absolute'});
            }
            if(distance+$(window).height()+20 >= $(document).height())
            {
                $.get("getMore",function(data,status){
                    updata(data);
                    plotdata = plotdata.concat(data)
                });

                //$('#addmore').click()
            }
        });
        //$container.on( 'click', '.plot-box', function() {
            // remove clicked element
          //  console.log(this)
            //$container.masonry( 'remove', this )
            // layout remaining item elements
              //  .masonry('layout');
        //});
        $('#plotRandom').click(function (){
            //$container.masonry('remove',$container[0].children);
            $container.masonry('remove',$container[0].childNodes);
            updata(plotdata);
            $container.masonry('layout')
            }
        )
        
        $('#pageTop').click(function () {
            $("html").animate({scrollTop:0}, 500);
        })
        $('#plotClick').click(function () {
            if($(this).hasClass('on'))return
            else
            {
                $(this).addClass('on')
                $('#roleClick').removeClass('on')
            }
        })
        $('#roleClick').click(function () {
            if($(this).hasClass('on'))return
            else
            {
                $(this).addClass('on')
                $('#plotClick').removeClass('on')
            }
        })
    });

</script>
</body>
</html>