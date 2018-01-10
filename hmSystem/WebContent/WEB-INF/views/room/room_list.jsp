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
                        <li><a href="#" class="am-icon-home">宿舍管理</a></li>
                        <li class="am-active">房屋管理</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" onclick="addRoom();"
                                                class="am-btn am-btn-default am-btn-success">
                                            <span class="am-icon-plus"></span> 添加
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
                                    <th>宿舍名称</th>
                                    <th>房东</th>
                                    <th>联系电话</th>
                                    <th>到期日期</th>
                                    <th>租金</th>
                                    <th>地址</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty rooms.results}" >
                                	<tr>
                                		<td colspan="7" class="am-text-middle">暂无记录</td>
                                	</tr>
                                </c:if>
                                <c:if test="${!empty rooms.results}" >
	                                <c:forEach items="${rooms.results}" var="room">
	                                    <tr>
	                                        <td>${room.name}</td>
	                                        <td>${room.fd}</td>
	                                        <td>${room.fdPhone}</td>
	                                        <td>${room.endDate}</td>
	                                        <td>${room.money}</td>
	                                        <td>${room.addr}</td>
	                                        <td>
	                                            <div class="tpl-table-black-operation">
	                                            	<a href="javascript:;" onclick="detailRoom('${room.id}','${room.name}');"
	                                                        class="tpl-table-black-operation-del"> <i
	                                                    class="am-icon-bars"></i> 详情
	                                            	</a>
	                                                <a href="javascript:;" onclick="editRoom('${room.id}')"> <i
	                                                        class="am-icon-pencil"></i>编辑
	                                                </a> 
	                                                <a href="javascript:;" onclick="deleteRoom('${room.id}');"
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
                            <tags:pagination pages="${rooms}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="room_form.jsp" %>
<script type="text/javascript">
var width = document.body.clientWidth;
if(width>800){
	width = 800;
}else{
	width = width*0.7;
}
function addRoom() {
    $("#roomForm")[0].reset();
    $("#roomForm").attr("action", "${ctx}/room/save");
    $("#passwordDiv").css("display", "");
    $("#plainPasswordDiv").css("display", "");
    layer.open({
        type: 1,
        area: width+'px',
        title: '添加宿舍',
        maxmin: true,
        content: $('#roomModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#roomModal").css("display", "none");
        }
    });
    form.render();
}
function editRoom(id) {
    $("#roomForm")[0].reset();
    $("#roomForm").attr("action", "${ctx}/room/update");
    $.ajax({
        url: '${ctx}/room/findRoomById',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $("#xxid").val(data.id);
            $("#name").val(data.name);
            $("#fd").val(data.fd);
            $("#fdPhone").val(data.fdPhone);
            $("#money").val(data.money);
            $("#startDate").val(data.startDate);
            $("#endDate").val(data.endDate);
            $("#countStu").val(data.countStu);
            $("#addr").val(data.addr);
        }
    });
    layer.open({
        type: 1,
        area: width+'px',
        title: '修改宿舍',
        maxmin: true,
        content: $('#roomModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#roomModal").css("display", "none");
        }
    });
    form.render();
}

function deleteRoom(id){
	layer.confirm('确定要删除么?请核对该宿舍学员住宿情况', {icon: 3, title: '提示'}, function (index) {
        $.ajax({
            url: '${ctx}/room/delete',
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

function detailRoom(id,name) {
	window.location.href = '${ctx}/room/roomstu?search_id='+id+"&search_name="+name;
}
</script>