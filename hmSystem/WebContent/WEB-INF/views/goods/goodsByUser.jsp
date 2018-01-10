<%--
  User: kangjianfeng
  Date: 2017-09-21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="goodsByUserModel" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
	<div class="widget am-cf">
		<form id="goodsByUserForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action=""
                  method="post">
        <div class="widget-body am-fr">
        	<table class="layui-table" lay-skin="nob">
			  <colgroup>
			    <col width="150">
			    <col width="200">
			    <col width="150">
			    <col width="200">
			  </colgroup>
			  <tbody>
			    <tr>
			      <td style="float:right;">物资名称：</td>
			      <td colspan="3">
			      	<input type="hidden" id="fakeid" name="id" />
			      	<input type="text" class="tpl-form-input" id="namesxabc" name="name" 
                               placeholder="请输入资产名称" lay-verify="namesxabc" readonly="readonly">
			      </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">状态：</td>
			      <td colspan="3">
				  	<select id="statesxa" name="state" lay-verify="deppa" 
				  	lay-search style="display: none;" onchange="selectUserByDep()">
                    	<option value="0" selected="selected">请选择状态</option>
                    	<option value="损坏">损坏</option>
                    	<option value="丢失">丢失</option>
                    </select>
				  </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">部门：</td>
			      <td colspan="3">
				  	<select id="deppa" name="deppa" lay-ignore
				  	 style="display: none;">
                    	<option value="0" selected>请选择部门</option>
                    </select>
				  </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">人员：</td>
			      <td colspan="3">
			      	<select id="usersq" name="usersq" lay-ignore style="display: none;">
                    	<option value="0">请选择</option>
                    </select>
			      </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;"><span style="color:red;">提示：</span></td>
			      <td colspan="3">
			      	<span style="color:red;">
			      		如果物资没有损坏或丢失请不要选择状态！
			      		如果不选择部门和人员，即视为已归还！
			      	</span>
			      </td>
			    </tr>
			    
			    <tr align="center">
			    	<td colspan="2">
			    		<button lay-submit lay-filter="goodsByUserForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
			    	</td>
			    	<td colspan="2">
			    		<input class="am-btn am-btn-primary tpl-btn-bg-color-success"
			    		lay-submit type="button" onclick="deletesCode()" value="取消" />
			    	</td>
			    </tr>
			  </tbody>
			</table>
        </div>
        </form>
    </div>
</div>
<script type="text/javascript">
	
	$(function(){
		form.render();
	});
	var form = layui.form();
	form.on('submit(goodsByUserForm)', function (data) {
		var d=$("#deppa").val();
		var u=$("#usersq").val();
		if(u=="0"){
			if(d!="0"){
				layer.msg("人员选项不能为空！", {icon: 6});
				return false;
			}
		}
		$.ajax({
		    url:data.form.action,
		    type:'post',
		    data:$("#goodsByUserForm").serialize(),
		    dataType:'json',
		    success:function (res) {
		    	layer.msg("保存成功", {icon: 6});
		    	layer.closeAll();
		    	freshen();
		    }
		});
	    return false;
	});
	
	function deletesCode(){
		layer.closeAll();
	}
	
	function selectUserByDep(){
		var depss=$("#deppa").val();
		$.ajax({
		   url:"${ctx}/goods/selectUserByDep",
		   type:'post',
		   data:{"depa":depss},
		   dataType:'json',
		   success:function (d) {
			   for(var i=0;i<d.length;i++){
		            $("#usersq").append("<option value='"+d[i]+"'>"+d[i]+"</option>"); 
		       }
		   }
		});	
	}
</script>