<%--
  User: kangjianfeng
  Date: 2017-09-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="userModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="userForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/user/insertUser"
                  method="post">
                <input type="hidden" id="xxid" name="id" value="" />
                <div class="am-form-group">
                    <label for="loginName" class="am-u-sm-3 am-form-label" style="width:25%">账号</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="loginName" name="loginName" 
                               placeholder="请输入登录名称" lay-verify="loginName">
                    </div>
                    <label for="office" class="am-u-sm-3 am-form-label" style="width:15%">办事处</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="office" name="office" lay-verify="office" lay-search style="display: none;">
                            <option value="">请选择</option>
                            <c:forEach items="${ofas}" var="ofa">
                                <option value="${ofa}">${ofa}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
				<div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label" style="width:25%">姓名</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="name" name="name" 
                               placeholder="请输入员工姓名" lay-verify="name">
                    </div>
                    <label for="sex" class="am-u-sm-3 am-form-label" style="width:15%">性别</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="sex" name="sex" lay-search style="display: none;">
                        	<option value="0" selected="selected">男</option>
                        	<option value="1">女</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="birthday" class="am-u-sm-3 am-form-label" style="width:25%">出生日期</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input id="birthday" style="height:32px;width:190px;" class="laydate-icon" id="birthday" name="birthday" onclick="laydate()" />
                    </div>
                    <label for="card" class="am-u-sm-3 am-form-label" style="width:15%">身份证号</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="card" name="card" 
                               placeholder="请输入身份证号" lay-verify="card">
                    </div>
                </div>

				<div class="am-form-group">
					<label for="place" class="am-u-sm-3 am-form-label" style="width:25%">籍贯</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="place" name="place" 
                               placeholder="例如:吉林-长春" lay-verify="place">
                    </div>
                    <label for="education" class="am-u-sm-3 am-form-label" style="width:15%">学历</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="education" name="education" lay-search style="display:none;">
                        	<option value="">请选择</option>
                        	<option value="初中">初中</option>
                        	<option value="高中">高中</option>
                        	<option value="大专">大专</option>
                        	<option value="本科">本科</option>
                        </select>
                    </div>
                </div>
				
				<div class="am-form-group">
					<label for="department" class="am-u-sm-3 am-form-label" style="width:25%">部门</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="department" name="department" lay-verify="department" lay-search style="display: none;">
                            <option value="">请选择</option>
                            <c:forEach items="${deps}" var="dep">
                                <option value="${dep}">${dep}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <label for="grade" class="am-u-sm-3 am-form-label" style="width:15%">级别</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="grade" name="grade" lay-verify="grade" lay-search style="display: none;">
                            <option value="">请选择</option>
                            <c:forEach items="${gras}" var="gra">
                                <option value="${gra}">${gra}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
				
                <div class="am-form-group">
                    <label for="position" class="am-u-sm-3 am-form-label">职位</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="position" name="position" 
                               placeholder="请输入员工职位" lay-verify="position">
                    </div>
                    <label for="roles" class="am-u-sm-3 am-form-label" style="width:15%">角色</label>
                    <div class="am-u-sm-9" style="width:30%">
                    	<select id="roles" name="roles" lay-verify="roles" lay-search style="display: none;">
                            <option value="">请选择</option>
                            <c:forEach items="${roles}" var="role">
                                <option value="${role.id}">${role.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="status" class="am-u-sm-3 am-form-label">状态</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="status" name="status" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        	<option value="在职">在职</option>
                        	<option value="离职">离职</option>
                        </select>
                    </div>
                    <label for="phone" class="am-u-sm-3 am-form-label" style="width:15%">电话</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="phone" name="phone" 
                               placeholder="请输入电话" lay-verify="phone">
                    </div>
                </div>
				
				<div class="am-form-group">
                    <label for="email" class="am-u-sm-3 am-form-label">Email地址</label>
                    <div class="am-u-sm-9" style="width:75%">
                        <input type="email" class="tpl-form-input" id="email" name="email" 
                               placeholder="请输入邮箱地址" />
                    </div>
                </div>
				
                <div class="am-form-group">
                    <label for="mark" class="am-u-sm-3 am-form-label">备注</label>
                    <div class="am-u-sm-9">
                        <textarea id="mark" name="mark" class="" rows="4" id="doc-ta-1" lay-verify="basMark"></textarea>
                    </div>
                </div>
				
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="userForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
	$(function(){
		form.render();
	});
    var form = layui.form();
    form.verify({
    	loginName: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "登录名名必须输入";
            }
            if (value.trim().length >= 16) {
                return "登录名最多输入16个字符";
            }
        },
        name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "姓名必须输入";
            }
            if (value.trim().length >= 5) {
                return "姓名最多输入5个字符";
            }
        },
        roles: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "角色必须选择";
            }
        },
        phone: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "电话必须输入";
            }
            if (value.trim().length >= 15) {
                return "电话最多输入15个字符";
            }
        },
        birthday: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "出生日期必须输入";
            }
        },
        card: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "身份证号码必须输入";
            }
        },
        place: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "籍贯信息必须输入";
            }
        },
        position: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "职位必须输入";
            }
        },
        email: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "邮箱必须输入";
            }
        }
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(userForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#userForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
                freshen();
            }
        });
        return false;
    });


</script>