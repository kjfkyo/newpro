<%--
  User: limiao
  Date: 2017-09-08
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
                        <li><a href="#" class="am-icon-home">项目管理</a></li>
                        <li class="am-active">项目列表</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/clzss/list" method="get">
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width:30%">
                            	<div class="am-custom-search">项目组名称:</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<input type="text" name="name" class="am-form-field" value="${param.name}" placeholder="请输入项目组名称"> 
                                	<span class="am-input-group-btn">
										<button class="am-btn  am-btn-default am-btn-success tpl-table-list-field" type="submit">查询</button>
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
                                    <th>项目组名称</th>
                                    <th>开班日期</th>
                                    <th>结课日期</th>
                                    <th>QQ群</th>
                                    <th>工程师</th>
                                    <th>创建人</t>
                                    <th>最后修改人</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${p.results}" var="stu">
                                    <tr>
                                    	<td>${stu.name}</td>
                                        <td>${stu.startDate}</td>
                                        <td>${stu.endDate}</td>
                                        <td>${stu.qq}</td>
                                        <td>${stu.teaId}</td>
                                        <td>${stu.createUser}</td>
                                        <td>${stu.updateUser}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                            		<a href="javascript:;" onclick="detailRoom('${stu.id}','${stu.name}');"
	                                                        class="tpl-table-black-operation-del"> <i
	                                                    class="am-icon-bars"></i> 详情
	                                            	</a>
                                            			<a href="javascript:editStu('${stu.id}');"> 
                                            			<i class="am-icon-pencil"></i>编辑</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${p}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="clzss_form.jsp" %>

 <script>
 var layer = layui.layer;
	 $(function(){
		 $("#search_clzId").val("${search_clzId}");
		 $("#search_advState").val("${search_advState}");
		 form.render();
	 });
	function editStu(id) {
	    $("#tAdvancedStudentForm")[0].reset();
	    $("#tAdvancedStudentForm").attr("action", "${ctx}/tAdvancedStudent/updateSave");
	    $.ajax({
	        url: '${ctx}/clzss/update',
	        data: {id: id},
	        type: 'post',
	        dataType: 'json',
	        success: function (data) {
	        	$("#ids").val(data.id);
	        	$("#id").val(data.id)
	        	$("#name").val(data.name)
	        	$("#startDate").val(data.startDate)
                $("#endDate").val(data.endDate)
                $("#qq").val(data.qq)
                $("#teaId").val(data.teaId)
                $("#createUser").val(data.createUser)
                $("#updateTime").val(data.updateTime)
                $("#startDate").val(data.startDate)
                $("#updateUser").val(data.updateUser)
	            $("#mark").val(data.mark);
	            
	            form.render();
	        }
	    });
	    var index = layer.open({
	        type: 1,
	        id: 'update',
	        area: '800px',
	        title: '修改项目组信息',
	        maxmin: true,
	        content: $('#tAdvancedStudentModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	        end: function () {
	            $("#tAdvancedStudentModal").css("display", "none");
	        }
	    });
	}
	function detailRoom(id,name) {
		window.location.href ='${ctx}/clzss/roomstu?search_id='+id+"&search_name="+name;
	}
</script>