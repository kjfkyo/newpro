<%--
  User: kangjiangfeng
  Date: 2017-09-09
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
                        <li><a href="#" class="am-icon-home">员工管理</a></li>
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
                        <div class="am-u-sm-12">
                            <table width="100%"
                                   class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>部门</th>
                                    <th>职位</th>
                                    <th>手机号</th>
                                    <th>工作地点</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users.results}" var="user">
                                    <tr>
                                        <td>${user.name}</td>
                                        <td>${user.department}</td>
                                        <td>${user.position}</td>
                                        <td>${user.phone}</td>
                                        <td>${user.office}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;" onclick="editUser('${user.id}')"> <i
                                                        class="am-icon-pencil"></i>
                                                        修改
                                                </a> <a href="javascript:;" onclick="resetUserPwd('${user.id}');"
                                                        class="am-icon-pencil"> 重置密码
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
<%@include file="userPageForm.jsp" %>
<script>
    function addRole() {
        $("#userForm")[0].reset();
        $("#userForm").attr("action", "${ctx}/user/insertUser");
        $("#edu").css("display", "none");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加员工',
            maxmin: true,
            content: $('#userModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#userModal").css("display", "none");
            }
        });
        form.render();
    }

    function resetUserPwd(id) {
    	layer.confirm('确定要重置密码么?', {icon: 3, title: '提示'}, function (index) {
    		$.ajax({
                url: '${ctx}/user/resetUserPwd',
                data: {id: id},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    if(data=='yes'){
                    	layer.msg("保存成功", {icon: 6});
                    }else{
                    	alert("no");
                    }
                }
            });
    	});
    }
    function editUser(id){
    	$("#userForm")[0].reset();
        $("#userForm").attr("action", "${ctx}/user/updateUserInfo");
        $.ajax({
            url: '${ctx}/user/editUser',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	$("#xxid").val(id);
                $("#loginName").val(data.loginName);
                $("#office").val(data.office);
                $("#name").val(data.name);
                $("#sex").val(data.sex);
                $("#birthday").val(data.birthday);
                $("#card").val(data.card);
                $("#place").val(data.place);
                $("#education").val(data.education);
                $("#department").val(data.department);
                $("#grade").val(data.grade);
                $("#position").val(data.position);
                $("#roles").val(data.roles);
                $("#status").val(data.status);
                $("#phone").val(data.phone);
                $("#email").val(data.email);
                $("#mark").val(data.mark);
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '修改员工信息',
            maxmin: true,
            content: $('#userModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#userModal").css("display", "none");
            }
        });
    }
</script>