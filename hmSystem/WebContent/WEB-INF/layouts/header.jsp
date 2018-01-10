<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<header>

    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <a href="javascript:;"><img src="${ctx}/static/images/logo.png" alt=""></a>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
                    <span>

                </span>
        </div>
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <shiro:user>
                        <a href="javascript:addUser();">欢迎你, <span><shiro:principal property="name"/></span> </a>
                    </shiro:user>
                </li>
                <!-- 退出 -->
                <li class="am-text-sm">
                    <a href="${ctx}/logout">
                        <span class="am-icon-sign-out"></span> 退出
                    </a>
                </li>
            </ul>
        </div>
    </div>

</header>
<%@include file="chpa_form.jsp" %>
<script>
 function addUser() {
        $("#chpaForm")[0].reset();
        $("#chpaForm").attr("action", "${ctx}/Chpa/update");
      
        layer.open({
            type: 1,
            area: '800px',
            title: '修改密码',
            maxmin: true,
            content: $('#chpaModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#chpaModal").css("display", "none");
            }
        });
        form.render();
 }
 </script>