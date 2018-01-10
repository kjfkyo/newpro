<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/app.css">
    <script type="text/javascript" src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/layui/lay/dest/layui.all.js"></script>
</head>
<body data-type="login">
<script src="${ctx}/static/amazeui/js/theme.js"></script>
<div class="am-g tpl-g">
    <!-- 风格切换 
    <div class="tpl-skiner">
        <div class="tpl-skiner-toggle am-icon-cog">
        </div>
        <div class="tpl-skiner-content">
            <div class="tpl-skiner-content-title">
                选择主题
            </div>
            <div class="tpl-skiner-content-bar">
                <span class="skiner-color skiner-white" data-color="theme-white"></span>
                <span class="skiner-color skiner-black" data-color="theme-black"></span>
            </div>
        </div>
    </div>
    -->
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo">

            </div>
            <form class="layui-form am-form tpl-form-line-form" action="${ctx}/login" method="post">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="username" name="username" placeholder="请输入账号"
                           lay-verify="username">
                </div>

                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" name="password" placeholder="请输入密码"
                           lay-verify="password">

                </div>
                <div class="am-form-group">
                    <button lay-submit lay-filter="loginForm"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/static/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/amazeui/js/app.js"></script>
<script>
    $(document).ready(function () {
        var form = layui.form();
        form.verify({
            username: function (value, item) {//value:表单值，item:表单dom对象
                if (value == null || value.trim().length <= 0) {
                    return "用户名必须输入的哦";
                }
                if (value.trim().length > 30) {
                    return "用户名最多输入30个字符哦";
                }
            },
            password: function (value, item) {
                if (value == null || value.trim().length <= 0) {
                    return "密码必须输入的哦";
                }
            }

        });
        layui.form().on('submit(loginForm)', function (data) {
            layer.msg(data);
            return false;
        });
    });
</script>
</body>
</html>

