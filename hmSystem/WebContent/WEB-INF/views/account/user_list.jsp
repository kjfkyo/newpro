<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">系统管理</a></li>
                        <li class="am-active">用户管理</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" onclick="addUser();"
                                                class="am-btn am-btn-default am-btn-success">
                                            <span class="am-icon-plus"></span> 添加
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form id="listForm" action="${ctx}/user/list" method="get">
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
                                    <th>登录名</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users.results}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.loginName}</td>
                                        <td>${user.name}</td>
                                        <td>${user.roles}</td>
                                        <td><fmt:formatDate value="${user.createTime}"
                                                            pattern="yyyy-MM-dd"/></td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;" onclick="editUser('${user.id}')"> <i
                                                        class="am-icon-pencil"></i>编辑
                                                </a> 
                                                <a href="javascript:;" onclick="deleteUser('${user.id}');"
                                                        class="tpl-table-black-operation-del"> <i
                                                    class="am-icon-trash"></i> 删除
                                            	</a>
                                            	<a href="javascript:;" onclick="falseDeletes('${user.id}');"
                                                        class="tpl-table-black-operation-del"> <i
                                                    class="am-icon-trash"></i> 隐藏
                                            	</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${users}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="user_form.jsp" %>
<script>
    function addUser() {
        $("#userForm")[0].reset();
        $("#userForm").attr("action", "${ctx}/user/save");
        $("#passwordDiv").css("display", "");
        $("#plainPasswordDiv").css("display", "");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加用户',
            maxmin: true,
            content: $('#userModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#userModal").css("display", "none");
            }
        });
        form.render();
    }

    function editUser(id) {
        $("#userForm")[0].reset();
        $("#userForm").attr("action", "${ctx}/user/update");
        $("#passwordDiv").css("display", "none");
        $("#plainPasswordDiv").css("display", "none");
        $.ajax({
            url: '${ctx}/user/findUserById',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
                $("#ids").val(data.id);
                $("#loginName").val(data.loginName);
                $("#name").val(data.name);
                $("#roles").val(data.roles);
                form.render();
            }
        });
        var index = layer.open({
            type: 1,
            id: 'update',
            area: '800px',
            title: '修改用户',
            maxmin: true,
            content: $('#userModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#userModal").css("display", "none");
            }
        });
    }

    function deleteUser(id) {
        layer.confirm('确定要删除么?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: '${ctx}/user/delete',
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

    function falseDelete(id) {
        layer.confirm('确定要将该用户隐藏么?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: '${ctx}/user/falseDelete',
                data: {id: id},
                type: 'post',
                success: function () {
                    layer.msg("隐藏成功", {icon: 6});
                    freshen();
                }
            });
            layer.close(index);
        });

    }
</script>