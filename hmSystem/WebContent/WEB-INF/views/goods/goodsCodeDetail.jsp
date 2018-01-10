<%--
  User: kangjianfeng
  Date: 2017-09-19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="goodsCodeModals" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
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
			      <td style="float:right;">物资名称：</td>
			      <td colspan="3"><span id="namess"></span></td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">物资类型：</td>
			      <td colspan="3"><span id="typess"></span></td>
			    </tr>
			    
			    <tr>
			      <td style="float:right;">物资状态：</td>
			      <td colspan="3"><span id="states"></span></td>
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
			      <td style="float:right;">使用情况：</td>
			      <td colspan="3"><span id="markss"></span></td>
			    </tr>
			    <tr align="center">
			    	<td colspan="4">
			    		<input class="am-btn am-btn-primary tpl-btn-bg-color-success"
			    		lay-submit type="button" onclick="deletesCode()" value="关闭窗口" />
			    	</td>
			    </tr>
			  </tbody>
			</table>
        </div>
    </div>
</div>
<script type="text/javascript">
	function deletesCode(){
		layer.closeAll();
	}
</script>