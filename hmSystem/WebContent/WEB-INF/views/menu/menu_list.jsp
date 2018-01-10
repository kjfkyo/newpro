<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<style>
    .layui-show {
        margin: 0 auto;
    }
</style>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">

        <div class="row">
            <div class="am-u-sm-6 am-u-md-6 am-u-lg-3">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">系统管理</a></li>
                        <li class="am-active">菜单管理</li>
                    </ol>
                    <ul class="am-tree" id="menu_tree"></ul>
                </div>
            </div>
            <div id="detail" class="am-u-sm-12 am-u-md-12 am-u-lg-9" style="display: none;">
                <div class="widget am-cf">
                    <div class="widget-body  widget-body-lg am-fr">
                        <form id="menuForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br" action=""
                              method="post">
                            <div class="am-form-group">
                                <label for="menuPidName" class="am-u-sm-3 am-form-label">上级菜单<span
                                        class="tpl-form-line-small-title">*</span></label>
                                <div class="am-u-sm-9">
                                    <select id="menuPid" name="menuPid" lay-verify="menuPid" lay-search
                                            style="display: none;">
                                        <option value="0">根目录</option>
                                        <c:forEach items="${menus}" var="menu">
                                            <option value="${menu.menuId}">${menu.menuName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="menuName" class="am-u-sm-3 am-form-label">菜单名称<span
                                        class="tpl-form-line-small-title">*</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" class="tpl-form-input" id="menuName" name="menuName" value=""
                                           lay-verify="required" placeholder="请输入菜单名称">
                                </div>
                                <input type="hidden" id="menuId" name="menuId" value=""/>
                            </div>

                            <div class="am-form-group" id="passwordDiv">
                                <label for="menuUrl" class="am-u-sm-3 am-form-label">URL<span
                                        class="tpl-form-line-small-title">*</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" class="tpl-form-input" id="menuUrl" name="menuUrl" value=""
                                           placeholder="请输入URL,无URL填写/" lay-verify="required">
                                </div>
                            </div>

                            <div class="am-form-group" id="plainPasswordDiv">
                                <label for="menuIcon" class="am-u-sm-3 am-form-label">图标<span
                                        class="tpl-form-line-small-title">&nbsp;&nbsp;</span></label>
                                <div class="am-u-sm-9">
                                    <input type="text" class="tpl-form-input" id="menuIcon"
                                           name="menuIcon" value="">
                                </div>
                            </div>

                            <div class="am-form-group">
                                <label for="orderId" class="am-u-sm-3 am-form-label">排序<span
                                        class="tpl-form-line-small-title">&nbsp;&nbsp;</span></label>
                                <div class="am-u-sm-9">
                                    <input type="number" class="tpl-form-input" id="orderId" name="orderId" value="">
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <button lay-submit lay-filter="updateForm"
                                            class="am-btn am-btn-primary tpl-btn-bg-color-success ">修改当前菜单
                                    </button>
                                    <button lay-submit lay-filter="saveForm"
                                            class="am-btn am-btn-success tpl-btn-bg-color-success ">新增为子菜单
                                    </button>
                                    <button type="button" onclick="deleteMenu();"
                                            class="am-btn am-btn-danger tpl-btn-bg-color-success ">删除当前菜单
                                    </button>
                                    <button type="button" onclick="falseDelete();"
                                            class="am-btn am-btn-danger tpl-btn-bg-color-success ">隐藏当前菜单
                                    </button>
                                </div>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var form = layui.form();

    layui.tree({
        elem: '#menu_tree',  //传入元素选择器
        nodes: ${trees},
        click: function (node) {
            $("#detail").fadeOut(150);
            var menuId = node.id;
            $.ajax({
                url: '${ctx}/menu/findMenuById',
                data: {menuId: menuId},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    $("#menuForm")[0].reset();
                    var pid = data.menuPid;
                    $("#menuPid ").val(pid);
                    $("#menuName").val(data.menuName);
                    $("#menuId").val(data.menuId);
                    $("#menuUrl").val(data.menuUrl);
                    $("#menuIcon").val(data.menuIcon);
                    $("#orderId").val(data.orderId);
                    $("#detail").fadeIn(500);
                    form.render();
                }
            });
        }
    });

    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(saveForm)', function (data) {
        $.ajax({
            url: "${ctx}/menu/saveChildren",
            type: 'post',
            data: $("#menuForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
                window.location.href = '${ctx}/menu/tree';
            }
        });
        return false;
    });

    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(updateForm)', function (data) {
        $.ajax({
            url: "${ctx}/menu/update",
            type: 'post',
            data: $("#menuForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
                window.location.href = '${ctx}/menu/tree';
            }
        });
        return false;
    });

    function deleteMenu() {
        layer.confirm('删除菜单会连同子菜单一起删除，确定要删除【' + $("#menuName").val() + '】菜单么?', {
            icon: 3,
            title: '提示'
        }, function (index) {
            $.ajax({
                url: "${ctx}/menu/delete",
                type: 'post',
                data: {menuId: $("#menuId").val()},
                dataType: 'json',
                success: function (result) {
                    layer.msg("保存成功", {icon: 6});
                    window.location.href = '${ctx}/menu/tree';
                }
            });
            layer.close(index);
        });
    }
    
    function falseDelete() {
        layer.confirm('隐藏菜单会连同子菜单一起隐藏，确定要隐藏【' + $("#menuName").val() + '】菜单么?', {
            icon: 3,
            title: '提示'
        }, function (index) {
            $.ajax({
                url: "${ctx}/menu/falseDelete",
                type: 'post',
                data: {menuId: $("#menuId").val()},
                dataType: 'json',
                success: function (result) {
                    layer.msg("保存成功", {icon: 6});
                    window.location.href = '${ctx}/menu/tree';
                }
            });
            layer.close(index);
        });
    }
</script>