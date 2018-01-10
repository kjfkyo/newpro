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
                                            <span class="am-icon-plus"></span> 添加物资
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
                                    <th>资产名称</th>
                                    <th>资产状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${goods.results}" var="good">
                                    <tr>
                                        <td>${good.name}</td>
                                        <td>${good.state}</td>
                                        <td width="30%">
                                            <div class="tpl-table-black-operation">
                                            	<a href="javascript:;" onclick="editGoods('${good.id}')"> <i
                                                        class="am-icon-pencil"></i>
                                                        详情
                                                </a>
                                            	<a href="javascript:;" onclick="resetGoodsss('${good.id}');"
                                                        class="am-icon-pencil">修改</a>
                                                 <a href="javascript:;" onclick="deleteGoodss('${good.id}');"
                                                        class="am-icon-pencil">删除
                                            </a>
                                            <a href="javascript:;" onclick="useGoodss('${good.id}');"
                                                        class="am-icon-pencil">使用
                                            </a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${goods}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="goodsAllListForm.jsp" %>
<%@include file="goodsCodeDetail.jsp" %>
<%@include file="updateGoods.jsp" %>
<%@include file="goodsByUser.jsp" %>
<script>
    function addRole() {
        $("#goodsCodeForm")[0].reset();
        $("#goodsCodeForm").attr("action", "${ctx}/goods/insertCodeGoods");
        $("#edu").css("display", "none");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加资产',
            maxmin: true,
            content: $('#goodsCodeModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsCodeModal").css("display", "none");
            }
        });
        form.render();
    }

    function deleteGoodss(id) {
    	layer.confirm('确定要删除该物资吗?', {icon: 3, title:'提示'}, function(index){
    		$.ajax({
                url: '${ctx}/goods/deleteGoodss',
                data: {id: id},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                	layer.msg("删除成功", {icon: 6});
                	freshen();
                }
            });
    	});
    }
    function resetGoodsss(id){
    	$("#goodsCodeFormxxs")[0].reset();
        $("#goodsCodeFormxxs").attr("action", "${ctx}/goods/updateGoods");
    	$.ajax({
            url: '${ctx}/goods/editGoods',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	$("#iiiid").val(data.id);
            	$("#namesx").val(data.name);
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '修改资产名称',
            maxmin: true,
            content: $('#goodsCodeModalsx'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsCodeModalsx").css("display", "none");
            }
        });
    }
    function editGoods(id){
    	$.ajax({
            url: '${ctx}/goods/editObjectGoods',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	$("#namess").html(data.name);
            	$("#typess").html(data.type);
            	$("#states").html(data.state);
            	$("#markss").html(data.mark);
            	$("#createUsers").html(data.createUser);
            	$("#createTimes").html(getLocalTime(data.createTime));
            	$("#updateTimes").html(getLocalTime(data.updateTime));
            	$("#updateUsers").html(data.updateUser);
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '查看资产信息',
            maxmin: true,
            content: $('#goodsCodeModals'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsCodeModals").css("display", "none");
            }
        });
    }
    
    function useGoodss(id){
    	$("#goodsByUserForm")[0].reset();
        $("#goodsByUserForm").attr("action", "${ctx}/goods/updateCodeGoods");
    	$.ajax({
            url: '${ctx}/goods/selectGoodsCodeUser',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	var goods=data[0];
            	var list=data[1];
            	$("#fakeid").val(goods.id);
            	$("#namesxabc").val(goods.name);
            	for(var i=0;i<list.length;i++){
                	$("#deppa").append("<option value='"+list[i]+"'>"+list[i]+"</option>"); 
            	}
            }
        });
        var index = layer.open({
            type: 1,
            area: '800px',
            title: '资产使用人',
            maxmin: true,
            content: $('#goodsByUserModel'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#goodsByUserModel").css("display", "none");
            }
        });
        $("#deppa").change( function() {
        	  selectUserByDep();
        });
    }
    
    function getLocalTime(nS) {  
        var date = new Date(nS);
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        var day = date.getDate();
        return year+"-"+month+"-"+day;
    }
</script>