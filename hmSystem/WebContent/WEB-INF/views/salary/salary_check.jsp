<%--
  User: why
  Date: 2017-09-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="tpl-content-wrapper">
	<div class="row-content am-cf">
		<div class="row">
			<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
				<div class="widget am-cf">
					<ol class="am-breadcrumb">
						<li><a href="#" class="am-icon-home">学员补助</a></li>
						<li class="am-active">补助审核</li>
					</ol>
					<div class="widget-body  am-fr">
						<form id="listForm" action="${ctx}/salary/salCheck" method="get"
							class="layui-form am-form tpl-form-border-form tpl-form-border-br">
							<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
								<div class="am-custom-search">项目组</div>
								<div
									class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
									<select id="search_clzId" name="search_clzId" lay-search
										style="width: 150px; display: none">
										<option value="">请选择</option>
										<option value="">请选择</option>
										<c:forEach items="${tBasiClzssList}" var="classList">
											<option value="${classList.id }">${classList.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div
								class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
								<span class="am-input-group-btn">
									<button
										class="am-btn  am-btn-default am-btn-success tpl-table-list-field"
										type="submit">搜索</button>
								</span>
							</div>
						</form>
						<div class="am-u-sm-12">
							<table width="100%"
								class="am-table am-table-compact am-table-striped tpl-table-black "
								id="example-r">
								<thead>
									<tr>
										<th>姓名</th>
										<th>性别</th>
										<th>手机号</th>
										<th>身份证号</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="i" value="0"></c:set>
									<c:forEach items="${sal.results}" var="stu">
										<tr>
											<td>${stu.name}</td>
											<td>${stu.sex}</td>
											<td>${stu.phone}</td>
											<td>${stu.card}</td>
											<td>
												<div class="tpl-table-black-operation">
													<c:choose>
														<c:when test="${stu.endState eq '0'}">
															<a href="javascript:updateStuSal('${stu.id}','${stu.name}','1');">
																<i class="am-icon-pencil"></i>修改
															</a>
														</c:when>
														<c:when test="${stu.endState eq '1'}">
															已发放
														</c:when>
														<c:otherwise>
															<a href="javascript:insertStuSal('${stu.id}','${stu.name}','0');">
																<i class="am-icon-pencil"></i>添加
															</a>
														</c:otherwise>
													</c:choose>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<tags:pagination pages="${sal}" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="salary_form.jsp"%>
<script>
	var layer = layui.layer;
	$(function(){
		$("#search_clzId").val("${search_clzId}");
		form.render();
	});
	function updateStuSal(id, name, flag) {
		$("#studentSalaryForm")[0].reset();
		$("#studentSalaryForm").attr("action", "${ctx}/salary/updateSalary");
		$("#name").val(name);
		$("#name").prop("readonly","true");
		$.ajax({
			url : '${ctx}/salary/updatePre',
			data : {id:id, flag:flag},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				$("#primaryId").val(data.id);
				$("#bankNum").val(data.bankNum);
				$("#salMoney").val(data.salMoney);
				$("#count").html(data.state);
				//changeSelectOption("bankNm",data.bankNm);
				$("#bankNm").val(data.bankNm);
				form.render();
			}
		});
		var index = layer.open({
			type : 1,
			id : 'update',
			area : '600px',
			title : '修改补助',
			maxmin : true,
			content : $('#salaryModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			end : function() {
				$("#salaryModal").css("display", "none");
			}
		});
	}
	function insertStuSal(id, name, flag) {
		$("#studentSalaryForm")[0].reset();
		$("#studentSalaryForm").attr("action", "${ctx}/salary/insertSalary");
		$("#name").val(name);
		$("#name").prop("readonly","true");
		$("#stuId").val(id);
		$.ajax({
			url : '${ctx}/salary/updatePre',
			data : {id:id, flag:flag},
			type : 'post',
			dataType : 'json',
			success : function(data) {
				if(data==null){
					$("#count").html(0);
				}else{
					$("#count").html(data.state);
				}
				form.render();
			}
		});
		var index = layer.open({
			type : 1,
			id : 'update',
			area : '600px',
			title : '添加补助',
			maxmin : true,
			content : $('#salaryModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
			end : function() {
				$("#salaryModal").css("display", "none");
			}
		});
	}
</script>
