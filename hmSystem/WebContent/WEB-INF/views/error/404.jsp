<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>404</title>
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/app.css">
    <script type="text/javascript" src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
</head>

<body data-type="widgets">
<script src="${ctx}/static/amazeui/js/theme.js"></script>
<!-- 内容区域 -->
<div class="tpl-page-state">
    <div class="tpl-page-state-title am-text-center tpl-error-title">404</div>
    <div class="tpl-error-title-info">页面找不到啦</div>
    <div class="tpl-page-state-content tpl-error-content">
        <p>对不起,没有找到您所需要的页面,可能是URL不确定,或者页面已被移除。</p>
        <button type="button" onclick="window.location.href=${ctx}/"
                class="am-btn am-btn-secondary am-radius tpl-error-btn">返回首页
        </button>
    </div>
</div>
</body>

</html>