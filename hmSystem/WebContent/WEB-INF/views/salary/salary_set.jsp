<%--
  User: why
  Date: 2017-09-11
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
                        <li><a href="#" class="am-icon-home">学员补助</a></li>
                        <li class="am-active">发放补助</li>
                    </ol>
                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/salary/setSal" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 25%;">
                                <div class="am-custom-search">年月</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="month" id="month" name="month" class="am-form-field"> 
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">状态</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="state" name="state" lay-search style="width:150px; display:none;">
                                		<option value="">请选择</option>
                                		<option value="">请选择</option>
			                        	<option value="0">未发放</option>
			                        	<option value="1">已发放</option>
			                        </select>
                                </div>
                            </div>
                            <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                            	<span class="am-input-group-btn">
									<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field" type="submit">搜索</button>
								</span>
                            </div>
                        </form>
                        <div class="am-u-sm-12">
                            <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>银行卡号</th>
                                    <th>银行名称</th>
                                    <th>金额</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${sal.results}" var="sal">
                                    <tr>
                                        <td>${sal.createUser}</td>
                                        <td>${sal.bankNum}</td>
                                        <td>${sal.bankNm}</td>
                                        <td>${sal.salMoney}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                            	<c:choose>
                                            		<c:when test="${sal.state eq '1'}">已发放
                                            		</c:when>
                                            		<c:otherwise>
                                            			<a href="javascript:updateSalary('${sal.id }');"> 
                                            			<i class="am-icon-pencil"></i>未发放</a>
                                            		</c:otherwise>
                                            	</c:choose>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${sal}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
 var layer = layui.layer;
	 $(function(){
		 $("#month").val("${month}");
		 $("#state").val("${state}");
		 form.render();
	 });
	 function updateSalary(id){
		 /* if(confirm("确定发放吗？")){
			var month = $("#month").val();
			var state = $("#state").val();
			 location.href="${ctx}/salary/setSal?id="+id+"&month="+month+"&state="+state;
		 } */
		 layer.confirm('确定发放吗？', {icon: 3, title: '提示'}, function (index) {
		 	var month = $("#month").val();
			var state = $("#state").val();
		 	location.href="${ctx}/salary/setSal?id="+id+"&month="+month+"&state="+state;
		 });
	 }
</script>