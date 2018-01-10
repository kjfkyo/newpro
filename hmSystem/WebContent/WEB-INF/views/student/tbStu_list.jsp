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
                        <li><a href="#" class="am-icon-home">学员管理</a></li>
                        <li class="am-active">学员列表</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/tBasiStudent/list" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width:20%;">
                                <div class="am-custom-search">状态:</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
	                            	<select id="search_basState" name="search_basState" lay-search style="width:100px;display: none;">
	                            		<option value="">请选择</option>
			                        </select>
		                        </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width:20%">
                            	<div class="am-custom-search">姓名:</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="search_name" class="tpl-form-input" value="${param.search_name}" placeholder="请输入姓名"> 
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width:20%">
                            	<div class="am-custom-search">电话:</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<input type="text" name="search_phone" class="tpl-form-input" value="${param.search_phone}" placeholder="请输入电话"> 
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width:40%">
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
                                    <th>手机号</th>
                                    <th>来源</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbStu.results}" var="stu">
                                    <tr>
                                    	<td>${stu.name}</td>
                                        <td>${stu.phone}</td>
                                        <td>${stu.source}</td>
                                        <td>${stu.createUser}</td>
                                        <td><fmt:formatDate value="${stu.createTime}" pattern="yyyy-MM-dd"/></td>
                                        <td>${stu.basState}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                            	<c:choose>
                                            		<c:when test="${stu.basState eq endState}">
                                            			<a href="javascript:detailStu('${stu.id}');"> 
                                            			<i class="am-icon-pencil"></i>查看详细</a>
                                            		</c:when>
                                            		<c:otherwise>
                                            			<a href="javascript:editStu('${stu.id}');"> 
                                            			<i class="am-icon-pencil"></i>编辑</a>
                                            		</c:otherwise>
                                            	</c:choose>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${tbStu}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="tbStu_form.jsp" %>
<%@include file="tbStu_detail.jsp" %>
 <script>
//初始化下拉框
initSelect();
 $(function(){
	 $("#search_basState option[value='${search_basState}']").attr("selected",true);
	 form.render();
 });
function editStu(id) {
    $("#tBasiStudentForm")[0].reset();
    $("#tBasiStudentForm").attr("action", "${ctx}/tBasiStudent/updateSave");
    $.ajax({
        url: '${ctx}/tBasiStudent/update',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
            $("#ids").val(data.id);
            $("#name").val(data.name);
            $("#age").val(data.age);
            $("#phone").val(data.phone);
            $("#edu").val(data.edu);
            $("#source").val(data.source);
            $("#getpeo").val(data.getpeo);
            $("#channel").val(data.channel);
            if(typeof(data.channelDetail) != "undefined" && data.channelDetail != ""){
	            $("#channelDetail").empty();
	            $("#channelDetail").append("<option value='"+data.channelDetail+"'>"+data.channelDetail+"</option>");
	            $("#channelDetail").val(data.channelDetail);
            }
            $("#basState").val(data.basState);
            $("#doorday").val(data.doorday);
            $("#basMark").val(data.basMark);
            form.render();
        }
    });
    var index = layer.open({
        type: 1,
        id: 'update',
        area: '800px',
        title: '修改学员信息',
        maxmin: true,
        content: $('#tBasiStudentModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#tBasiStudentModal").css("display", "none");
        }
    });
}
function detailStu(id){
    $.ajax({
        url: '${ctx}/tBasiStudent/detail',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
        	var cdate = new Date(data.createTime);
            var createTime = cdate.getFullYear()+"年"+(cdate.getMonth()+1)+"月"+cdate.getDate()+"日 ";
            var udate = new Date(data.updateTime);
            var updateTime = udate.getFullYear()+"年"+(udate.getMonth()+1)+"月"+udate.getDate()+"日 ";
            $("#names").html(data.name);
            $("#ages").html(data.age);
            $("#phones").html(data.phone);
            $("#edus").html(data.edu);
            $("#sources").html(data.source);
            $("#getpeos").html(data.getpeo);
            $("#channels").html(data.channel);
            $("#channelDetails").html(data.channelDetail);
            $("#basStates").html(data.basState);
            $("#doordays").html(data.doorday);
            $("#createTimes").html(createTime);
            $("#createUsers").html(data.createUser);
            $("#updateTimes").html(updateTime);
            $("#updateUsers").html(data.updateUser);
            $("#basMarks").html(data.basMark);
        }
    });
    var index = layer.open({
        type: 1,
        area: '800px',
        title: '学员详细',
        maxmin: true,
        content: $('#stuDetailModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#stuDetailModal").css("display", "none");
        }
    });
}
function initSelect(){
	$.ajax({
        url: '${ctx}/common/sysCode',
        data: {type: "bas"},
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (data) {
        	addOptionforObjNM("search_basState",data);
        }
    });
}
</script>