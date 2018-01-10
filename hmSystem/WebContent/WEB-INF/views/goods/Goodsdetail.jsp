<%--
  User: kangjianfeng
  Date: 2017-09-19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="goodsDetailModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
	<div class="widget am-cf">
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
			      <td style="float:right;">资产类型名称：</td>
			      <td colspan="3"><span id="name"></span></td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">创建用户：</td>
			      <td colspan="3"><span id="createUsers"></span></td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">创建时间：</td>
			      <td colspan="3">
			      	<span id="createTimes"></span>
			      </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">最后修改用户：</td>
			      <td colspan="3"><span id="updateUsers"></span></td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">最后修改时间：</td>
			      <td colspan="3">
			      	<span id="updateTimes"></span>
			      </td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">详情：</td>
			      <td colspan="3">
			      		该资产类型下有
			      	<span id="sum"></span>
			      	个物品,
			      		目前已借出
						<span id="notnull"></span>
						个，
						闲置<span id="nullsx"></span>个，
						已损坏<span id="xxx"></span>个,
						丢失<span id="donk"></span>个
				  </td>
			    </tr>
			    <tr align="center">
			    	<td colspan="4">
			    		<input class="am-btn am-btn-primary tpl-btn-bg-color-success"
			    		lay-submit type="button" onclick="deletesCode()" value="确定删除" />
			    	</td>
			    </tr>
			  </tbody>
			</table>
			<input type="hidden" id="ids" name="ids"/>
        </div>
    </div>
</div>
<script type="text/javascript">
	function deletesCode(){
		var idd=$("#ids").val();
		layer.confirm('确定要删除该类型吗?', {icon: 3, title:'提示'}, function(index){
			$.ajax({
			   url:'${ctx}/goods/deleteCode',
			   type:'post',
			   data:{id:idd},
			   dataType:'json',
			   success:function (result) {
			     layer.msg("操作成功", {icon: 6});
			     layer.close(index);
			     layer.closeAll();
			     freshen();
			   }
			});
		});
	}
</script>