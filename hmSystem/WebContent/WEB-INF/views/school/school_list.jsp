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
                        <li><a href="#" class="am-icon-home">高校管理</a></li>
                        <li class="am-active">高校列表</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/school/list" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 70%;">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<span class="am-input-group-btn">
	                                	<button type="button" onclick="addSchool();"
	                                            class="am-btn  am-btn-default am-btn-success tpl-table-list-field">
	                                        <span class="am-icon-plus"></span> 添加
	                                    </button>
                                    </span>
                                </div>
                            </div>
                        	
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">高校名称</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="search_name" class="am-form-field" value="${param.search_name}" placeholder="请输入名称"> 
                                </div>
                            </div>
                            
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 10%;">
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
                                    <th>高校名称</th>
                                    <th>联系人</th>
                                    <th>联系电话</th>
                                    <th>职务</th>
                                    <th>维护人</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty schools.results}" >
                                	<tr>
                                		<td colspan="7" class="am-text-middle">暂无记录</td>
                                	</tr>
                                </c:if>
                                <c:if test="${!empty schools.results}" >
	                                <c:forEach items="${schools.results}" var="school">
	                                    <tr>
	                                        <td>${school.name}</td>
	                                        <td>${school.lxr}</td>
	                                        <td>${school.lxdh}</td>
	                                        <td>${school.zw}</td>
	                                        <td>${school.whr}</td>
	                                        <td>${school.zt}</td>
	                                        <td>
	                                            <div class="tpl-table-black-operation">
	                                                <a href="javascript:;" onclick="editSchool('${school.id}')"> <i
	                                                        class="am-icon-pencil"></i>编辑
	                                                </a> 
	                                                <a href="javascript:;" onclick="deleteSchool('${school.id}');"
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
                            <tags:pagination pages="${schools}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="school_form.jsp" %>
<script type="text/javascript">
var width = document.body.clientWidth;
if(width>600){
	width = 600;
}else{
	width = width*0.7;
}
function addSchool() {
    $("#schoolForm")[0].reset();
    $("#schoolForm").attr("action", "${ctx}/school/save");
    layer.open({
        type: 1,
        area: width+'px',
        title: '添加高校',
        maxmin: true,
        content: $('#schoolModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#schoolModal").css("display", "none");
        }
    });
    form.render();
}
function editSchool(id) {
    $("#schoolForm")[0].reset();
    $("#schoolForm").attr("action", "${ctx}/school/update");
    $.ajax({
        url: '${ctx}/school/findById',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $("#xxid").val(data.id);
            $("#name").val(data.name);
            $("#lxr").val(data.lxr);
            $("#lxdh").val(data.lxdh);
            $("#zw").val(data.zw);
            $("#cc").val(data.cc);
            $("#lx").val(data.lx);
            $("#gm").val(data.gm);
            $("#zybz").val(data.zybz);
            $("#whr").val(data.whr);
            $("#mark").val(data.mark);
            $("#zt").val(data.zt);
        }
    });
    layer.open({
        type: 1,
        area: width+'px',
        title: '修改高校',
        maxmin: true,
        content: $('#schoolModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#schoolModal").css("display", "none");
        }
    });
    form.render();
}

function deleteSchool(id){
	layer.confirm('确定要删除么?', {icon: 3, title: '提示'}, function (index) {
        $.ajax({
            url: '${ctx}/school/delete',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	if(data.msg=="ok") {
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