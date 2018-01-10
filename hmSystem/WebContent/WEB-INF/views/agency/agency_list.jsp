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
                        <li><a href="#" class="am-icon-home">代理管理</a></li>
                        <li class="am-active">代理列表</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/agency/list" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 70%;">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<span class="am-input-group-btn">
	                                	<button type="button" onclick="addAgency();"
	                                            class="am-btn am-btn-default am-btn-success">
	                                        <span class="am-icon-plus"></span> 添加
	                                    </button>
                                    </span>
                                </div>
                            </div>
                        	
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">代理名称</div>
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
                                    <th>代理姓名</th>
                                    <th>联系电话</th>
                                    <th>公司名称</th>
                                    <th>返点</th>
                                    <th>维护人</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty agencys.results}" >
                                	<tr>
                                		<td colspan="7" class="am-text-middle">暂无记录</td>
                                	</tr>
                                </c:if>
                                <c:if test="${!empty agencys.results}" >
	                                <c:forEach items="${agencys.results}" var="agency">
	                                    <tr>
	                                        <td>${agency.name}</td>
	                                        <td>${agency.phone}</td>
	                                        <td>${agency.gsmc}</td>
	                                        <td>${agency.fd}</td>
	                                        <td>${agency.whr}</td>
	                                        <td>${agency.zt}</td>
	                                        <td>
	                                            <div class="tpl-table-black-operation">
	                                                <a href="javascript:;" onclick="editAgency('${agency.id}')"> <i
	                                                        class="am-icon-pencil"></i>编辑
	                                                </a> 
	                                                <a href="javascript:;" onclick="deleteAgency('${agency.id}');"
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
                            <tags:pagination pages="${agencys}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="agency_form.jsp" %>
<script type="text/javascript">
var width = document.body.clientWidth;
if(width>800){
	width = 800;
}else{
	width = width*0.7;
}
function addAgency() {
    $("#agencyForm")[0].reset();
    $("#agencyForm").attr("action", "${ctx}/agency/save");
    layer.open({
        type: 1,
        area: width+'px',
        title: '添加代理信息',
        maxmin: true,
        content: $('#agencyModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#agencyModal").css("display", "none");
        }
    });
    form.render();
}
function editAgency(id) {
    $("#agencyForm")[0].reset();
    $("#agencyForm").attr("action", "${ctx}/agency/update");
    $.ajax({
        url: '${ctx}/agency/findById',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $("#xxid").val(data.id);
            $("#name").val(data.name);
            $("#phone").val(data.phone);
            $("#gsmc").val(data.gsmc);
            $("#ywlx").val(data.ywlx);
            $("#gm").val(data.gm);
            $("#fd").val(data.fd);
            $("#whr").val(data.whr);
            $("#zt").val(data.zt);
            $("#mark").val(data.mark);
            
        }
    });
    layer.open({
        type: 1,
        area: width+'px',
        title: '修改代理信息',
        maxmin: true,
        content: $('#agencyModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#agencyModal").css("display", "none");
        }
    });
    form.render();
}

function deleteAgency(id){
	layer.confirm('确定要删除么?', {icon: 3, title: '提示'}, function (index) {
        $.ajax({
            url: '${ctx}/agency/delete',
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