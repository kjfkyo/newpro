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
                        <li><a href="${ctx}/room/list" class="am-icon-home">宿舍管理</a></li>
                        <li class="am-active">【${name}】详情</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12">
                            <table width="100%"
                                   class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>紧急联系人</th>
                                    <th>紧急联系人电话</th>
                                    <th>项目组</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty stus.results}" >
                                	<tr>
                                		<td colspan="6" class="am-text-middle">暂无记录</td>
                                	</tr>
                                </c:if>
                                <c:if test="${!empty stus.results}" >
	                                <c:forEach items="${stus.results}" var="stu">
	                                    <tr>
	                                        <td>${stu.NAME}</td>
	                                        <td>${stu.PHONE}</td>
	                                        <td>${stu.LXR}</td>
	                                        <td>${stu.LXRPHONE}</td>
	                                        <td>${stu.CLZSSNAME}</td>
	                                        <td>
	                                            <div class="tpl-table-black-operation">
	                                                <a href="javascript:;" onclick="editStu('${stu.ID}')"> <i
	                                                        class="am-icon-pencil"></i>换宿舍
	                                                </a> 
	                                                <a href="javascript:;" onclick="deleteStu('${stu.ID}');"
	                                                        class="tpl-table-black-operation-del"> <i
	                                                    class="am-icon-trash"></i> 删除
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
<script type="text/javascript">

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

function deleteStu(id) {
	layer.confirm('确定要从宿舍移除该学员吗?', {icon: 3, title: '提示'}, function (index) {
		$.ajax({
	        url: '${ctx}/room/delrs',
	        type: 'post',
	        data: {stuId: id},
	        dataType: 'json',
	        success: function (result) {
	        	if(result.msg=="ok") {
	                layer.msg("删除成功", {icon: 6});
    	            freshen();
            	}else{
            		layer.msg("删除失败", {icon: 2});
            	}
	        },
	        error:function () {
            	layer.msg("删除失败", {icon: 2});
            }
	    });
		layer.close(index);
    });
}
</script>