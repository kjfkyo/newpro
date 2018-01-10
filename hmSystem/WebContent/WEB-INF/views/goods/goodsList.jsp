<%--
  User: kangjiangfeng
  Date: 2017-09-19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx}/static/plugin/ztree/css/metroStyle/metroStyle.css">
<script type="text/javascript" src="${ctx}/static/plugin/ztree/js/jquery.ztree.all.min.js"></script>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="${ctx}/goods/selectTBasiCode" class="am-icon-home">资产类型管理</a></li>
                        <li class="am-active">资产管理</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" onclick="addRole();"
                                                class="am-btn am-btn-default am-btn-success">
                                            <span class="am-icon-plus"></span> 添加类型
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="am-u-sm-12">
                            <table width="100%"
                                   class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th>资产类型</th>
                                    <th>总量</th>
                                    <th>空闲</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${codes.results}" var="code">
                                    <tr>
                                        <td>${code.name}</td>
                                        <td>
                                        	<c:forEach items="${count }" var="counts">
                                        		<c:if test="${code.name==counts.key }">
	                                        		${counts.value }
	                                        	</c:if>
                                        	</c:forEach>
                                        </td>
                                        <td>
                                        	<c:forEach items="${countNull }" var="cns">
                                        		<c:if test="${code.name==cns.key }">
	                                        		${cns.value }
	                                        	</c:if>
                                        	</c:forEach>
										</td>
                                        <td width="30%">
                                            <div class="tpl-table-black-operation">
                                            	<a href="javascript:;" onclick="editCode('${code.name}')"> <i
                                                        class="am-icon-pencil"></i>
                                                        详情
                                                </a>
                                            	<a href="javascript:;" onclick="resetCode('${code.id}','${code.name}');"
                                                        class="am-icon-pencil">修改</a>
                                                 <a href="javascript:;" onclick="deleteCode('${code.id}');"
                                                        class="am-icon-pencil">删除
                                            </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${codes}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="goodsForm.jsp" %>
<%@include file="Goodsdetail.jsp" %>
<script>
    function addRole() {
        $("#goodsForm")[0].reset();
        $("#goodsForm").attr("action", "${ctx}/goods/insertGoods");
        $("#edu").css("display", "none");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加资产类型',
            maxmin: true,
            content: $('#goodsModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsModal").css("display", "none");
            }
        });
        form.render();
    }

    function deleteCode(id) {
    	$.ajax({
            url: '${ctx}/goods/editCode',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	var code=data[0];
            	$("#ids").val(code.id);
            	$("#name").html(code.name);
            	$("#createUsers").html(code.createUser);
            	$("#createTimes").html(getLocalTime(code.createTime));
            	$("#updateUsers").html(code.updateUser);
            	$("#updateTimes").html(getLocalTime(code.updateTime));
            	var s=data[1];
            	$("#sum").html(s);
            	var nn=data[2];
            	$("#nullsx").html(nn);
            	var x=data[3];
            	$("#xxx").html(x);
            	var u=data[4];
            	$("#notnull").html(u);
            	var d=data[5];
            	$("#donk").html(d);
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '删除资产类型',
            maxmin: true,
            content: $('#goodsDetailModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsDetailModal").css("display", "none");
            }
        });
    }
    function resetCode(id,name){
    	$("#goodsForm")[0].reset();
        $("#goodsForm").attr("action", '${ctx}/goods/updateCodes');
        $.ajax({
            url: '${ctx}/goods/editObjectCode',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	$("#xxid").val(data.id);
            	$("#names").val(data.name);
            	$("#createTime").val(data.createTime);
            	$("#createUser").val(data.createUser);
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '修改资产类型',
            maxmin: true,
            content: $('#goodsModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsModal").css("display", "none");
            }
        });
    }
    function editCode(type){//查看详情
    	location.href="${ctx}/goods/selectGogdsAllByCodeType?type="+type;
    }
    
    
    function getLocalTime(nS) {  
        var date = new Date(nS);
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var day = date.getDate();
        return year+"-"+month+"-"+day;
    }
</script>