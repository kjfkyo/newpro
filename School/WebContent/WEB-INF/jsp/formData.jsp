<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	function check(){
		var s_age=$("#s_age").val();
		if(s_age<=18&&s_age>=8){
			return true;
		}else{
			layer.msg('不开心。。', {icon: 5});
			return false;
		}
	}
</script>
<div id="formDiv" style="display: none;" >
<form id="stuForm" action="" onsubmit="return check()">
	<div class="widget am-cf">
        <div class="widget-body am-fr">
        	<div class="layui-form-item">
			    <label class="layui-form-label">姓名</label>
			    <div class="layui-input-block">
			    <input type="hidden" name="s_id" id="s_id" />
			      <input type="text" id="s_name" name="s_name" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" style="width: 160px;">
			    </div>
			  </div>
        	<div class="layui-form-item">
			    <label class="layui-form-label">年龄</label>
			    <div class="layui-input-block">
			      <input type="text" name="s_age" id="s_age" required  lay-verify="required" placeholder="请输入年龄" autocomplete="off" class="layui-input" style="width: 160px;">
			    </div>
			  </div>
        	<div class="layui-form-item">
			    <label class="layui-form-label">班级</label>
			    <div class="layui-input-block">
			      <select name="cid.c_id" id="cid">
			      	<c:forEach items="${claList }" var="sclass">
			      		<option value="${sclass.c_id }">${sclass.c_name }</option>
			      	</c:forEach>
			      </select>
			    </div>
			  </div>
        	<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit>立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
        </div>
    </div>
	</form>
</div>