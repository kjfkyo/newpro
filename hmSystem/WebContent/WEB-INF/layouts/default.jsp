<%--
  Created by IntelliJ IDEA.
  User: limiao
  Date: 2016/12/18
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <%-- <link rel="icon" href="${ctx}/static/favicon.ico"/> --%>
    <link rel="stylesheet" href="${ctx}/static/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/amazeui.min.css"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="${ctx}/static/amazeui/css/app.css">
    <link rel="stylesheet" href="${ctx}/static/styles/default.css">
    <script type="text/javascript" src="${ctx}/static/jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/layui/lay/dest/layui.all.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/laydate.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/public.js"></script>
    <script>

        //页面一打开就执行弹层
        layer.ready(function () {
            var index = layer.load();
            setTimeout(function () {
                layer.close(index);
            }, 1000);

        });
    </script>
    <sitemesh:head/>
</head>

<body data-type="index">
<script src="${ctx}/static/amazeui/js/theme.js"></script>
<%@ include file="/WEB-INF/layouts/header.jsp" %>
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
<%@ include file="/WEB-INF/layouts/left.jsp" %>
<!-- 内容区域 -->

<sitemesh:body/>


<%@ include file="/WEB-INF/layouts/footer.jsp" %>

<script type="text/javascript" src="${ctx}/static/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${ctx}/static/amazeui/js/amazeui.datatables.min.js"></script>
<script type="text/javascript" src="${ctx}/static/amazeui/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="${ctx}/static/amazeui/js/app.js"></script>
</body>
</html>