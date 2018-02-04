<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@include file="header.jsp" %>
<div class="container">
    <!-- Example row of columns -->
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-operate">
                <a href="#">创建新条目</a>
                <a href="#">引用</a>
                <a href="#">分享</a>
        </div>
    </div>
    <div class="col-md-offset-1 col-md-10 col-sm-12">
        <div class="row tropes-context">
            <div>
                <img class="tropes-pic" src="/facgnImg/role/${role.id}.png" align="right"  hspace="50" vspace="50">
                <h1 style="margin-top: 20px;margin-bottom: 5px;"><strong>${role.role_name}</strong></h1>
                <a class="edit-button" href="#">编辑</a>
                <h2 style="color:gray;font-weight: bold;">追逐·战斗</h2>
                <p>
                <ul class="role-info" style=" background-color: #F0F0F0; width:55%;">
                    <li>出处：${role.role_at_movie}</li>
                    <li>扮演者：吴京</li>
                    <li>身份职业：${role.role_profession}</li>
                    <li>国籍：${role.role_country}</li>
                    <li>战友：邵兵、史三八、俞飞、板砖</li>
                    <li>上司：石青松、龙小云</li>
                    <li>敌人：老猫Tom Cat、敏登</li>
                    <li>女友：龙小云、RACHEL</li>
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
                    <li class="row">
                        <div class="col-md-2">
                            <img src="${ctx}/public/img/wudi.png"   height="100px" width="80px">
                        </div>
                        <div class="col-md-10">
                            <ul class="relate-second">
                                <li><span>吴迪</span><span>《空天猎》</span><a class="relate-detail" href="#">详情</a></li>
                                <li>
                                    天狼中队成员，空军战斗机飞行员，肩负救援人质和联合反恐的双重任务，与敌人在空中开
                                    展了一场智谋与勇气的极限较量。
                                </li>
                            </ul>

                        </div>
                    </li>
                    <li class="row">
                        <div class="col-md-2">
                            <img src="${ctx}/public/img/yuanlang.png" height="100px" width="80px">
                        </div>
                        <div class="col-md-10">
                            <ul class="relate-second">
                                <li><span>袁朗</span><span>《士兵突击》</span><a class="relate-detail" href="#">详情</a></li>
                                <li>
                                    A大队三中队中队长，军衔为中校。他身怀绝技，通透人性，同时心怀悲悯。
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </div>
    <hr>
</div> <!-- /container -->
<script src="js/vendor/jquery.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
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