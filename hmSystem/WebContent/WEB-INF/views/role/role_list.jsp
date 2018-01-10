<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx}/static/plugin/ztree/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${ctx}/static/plugin/ztree/js/jquery.ztree.all.min.js"></script>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">系统管理</a></li>
                        <li class="am-active">角色管理</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" onclick="addRole();"
                                                class="am-btn am-btn-default am-btn-success">
                                            <span class="am-icon-plus"></span> 添加
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form id="listForm" action="${ctx}/role/list" method="get">
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="float: right;">
                                <div class="am-custom-search">关键字</div>
                                <div
                                        class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="keyword" class="am-form-field" value="${keyword}"
                                           placeholder="请输入关键字查询"> <span
                                        class="am-input-group-btn">
									<button
                                            class="am-btn  am-btn-default am-btn-success tpl-table-list-field"
                                            type="submit">查询</button>
								</span>
                                </div>
                            </div>
                        </form>
                        <div class="am-u-sm-12">
                            <table width="100%"
                                   class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>角色名称</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
                                    <th>说明</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${roles.results}" var="role">
                                    <tr>
                                        <td>${role.id}</td>
                                        <td>${role.name}</td>
                                        <td>${role.createUser}</td>
                                        <td><fmt:formatDate value="${role.createTime}"
                                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td>${role.explains}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;" onclick="editRole('${role.id}')"> <i
                                                        class="am-icon-pencil"></i>
                                                    编辑
                                                </a> <a href="javascript:;" onclick="deleteRole('${role.id}');"
                                                        class="tpl-table-black-operation-del"> <i
                                                    class="am-icon-trash"></i> 删除
                                            </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${roles}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="role_form.jsp" %>
<script>
    function addRole() {
        $("#roleForm")[0].reset();
        $("#roleForm").attr("action", "${ctx}/role/save");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加角色',
            maxmin: true,
            content: $('#roleModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#roleModal").css("display", "none");
            }
        });
        form.render();
    }

    function deleteRole(id) {
        layer.confirm('删除角色后使用该角色的用户将无法正常使用系统，确定要删除么?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: '${ctx}/role/delete',
                data: {id: id},
                type: 'post',
                success: function () {
                    layer.msg("删除成功", {icon: 6});
                    freshen();
                }
            });
            layer.close(index);
        });

    }

    function editRole(id) {
        $("#roleForm")[0].reset();
        $("#roleForm").attr("action", "${ctx}/role/update");
        $.ajax({
            url: '${ctx}/role/findRoleById',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
                $("#ids").val(data.id);
                $("#name").val(data.name);
                $("#explains").val(data.explains);
                var roleMenu = data.menuIds;
                if (roleMenu != null && roleMenu.length > 0) {
                    var menus = roleMenu.split(",");
                    for (var i = 0, len = menus.length; i < len; i++) {
                        var _node = zTreeObj.getNodeByParam("id", menus[i], null);
                        zTreeObj.checkNode(_node, true, false, true);
                    }
                }
                form.render();
            }
        });
        layer.open({
            type: 1,
            area: '800px',
            title: '修改角色',
            maxmin: true,
            content: $('#roleModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#roleModal").css("display", "none");
            }
        });
        form.render();
    }  
</script>