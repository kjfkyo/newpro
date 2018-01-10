<%--
  User: limiao
  Date: 2017-09-13
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
                        <li><a href="#" class="am-icon-home">分配宿舍</a></li>
                        <li class="am-active">学员搜索</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/room/stuList" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 25%;">
                                <div class="am-custom-search">项目组</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="search_clzId" name="search_clzId" lay-search style="width:150px; display:none;" >
                                		<option value="">请选择</option>
                                	</select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 25%;">
                                <div class="am-custom-search">姓名</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="search_name" class="am-form-field" value="${param.search_name}" placeholder="请输入姓名"> 
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
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
                                    <th>姓名</th>
                                    <th>身份证号</th>
                                    <th>手机号</th>
                                    <th>项目组</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty stus.results}" >
                                	<tr>
                                		<td colspan="5" class="am-text-middle">暂无记录</td>
                                	</tr>
                                </c:if>
                                <c:if test="${!empty stus.results}" >
	                                <c:forEach items="${stus.results}" var="stu">
	                                    <tr>
	                                        <td>${stu.NAME}</td>
	                                        <td>${stu.CARD}</td>
	                                        <td>${stu.PHONE}</td>
	                                        <td>${stu.CLZSSNAME}</td>
	                                        <td>
	                                            <div class="tpl-table-black-operation">
	                                                <a href="javascript:;" onclick="editStu('${stu.ID}')"> <i
	                                                        class="am-icon-pencil"></i>选宿舍
	                                                </a> 
	                                            </div>
	                                        </td>
	                                    </tr>
	                                </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                            <tags:pagination pages="${stus}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="free_form.jsp" %>
 <script>
 initSelect();
 $(function(){
	 $("#search_clzId").val("${search_clzId}");
	 form.render();
 });
function initSelect() {
	$.ajax({
        url: '${ctx}/common/otherCode',
        data:{tname:'T_BASI_CLZSS',filer:"to_date(end_date,'yyyy-MM-dd')>add_months(sysdate,-6) order by create_time desc"},
        type: 'post',
        async:false,
        dataType: 'json',
        success: function (data) {
        	addOptionforObj("search_clzId",data);
        }
    });
 }
function editStu(id) {
	$("#freeRoomForm")[0].reset();
	
	$("#stuId").val(id);
	
	layer.open({
        type: 1,
        area: '600px',
        title: '选择宿舍',
        maxmin: true,
        content: $('#freeRoomModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#freeRoomModal").css("display", "none");
        }
    });
    form.render();
}

</script>