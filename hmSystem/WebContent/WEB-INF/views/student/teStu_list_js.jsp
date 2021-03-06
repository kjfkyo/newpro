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
                        <li><a href="#" class="am-icon-home">学员管理</a></li>
                        <li class="am-active">学员列表</li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <form id="listForm" action="${ctx}/tEndStudent/listJS" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">项目组</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="search_clzId" name="search_clzId" lay-search style="width:150px; display:none;" >
                                		<option value="">请选择</option>
                                	</select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">状态</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="search_endState" name="search_endState" lay-search style="display: none;">
			                        	<option value="">请选择</option>
			                        </select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">姓名</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="search_name" class="am-form-field" value="${param.search_name}" placeholder="请输入姓名"> 
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">电话</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<input type="text" name="search_phone" class="am-form-field" value="${param.search_phone}" placeholder="请输入电话"> 
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
                                    <th>性别</th>
                                    <th>身份证号</th>
                                    <th>手机号</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${teStu.results}" var="stu">
                                    <tr>
                                    	<td>${stu.name}</td>
                                        <td>${stu.sex}</td>
                                        <td>${stu.card}</td>
                                        <td>${stu.phone}</td>
                                        <td>
                                     			<select onchange="editStu('${stu.id}',this.value)">
                                     				<c:forEach items="${states}" var="state">
                                     					<option value="${state.NAME}" <c:if test="${stu.endState eq state.NAME}">selected</c:if>>${state.NAME}</option>
                                     				</c:forEach>
                                     			</select>
                                        </td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                            	<a href="javascript:detailStu('${stu.id}');"> 
                                            		<i class="am-icon-pencil"></i>查看详细</a>
                                            	<a href="javascript:updateStu('${stu.id}');"> 
                                            			<i class="am-icon-pencil"></i>编辑</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${teStu}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="teStu_detail.jsp" %>
<%@include file="teStu_form_js.jsp" %>
 <script>
 initSelect();
 var form = layui.form();
 $(function(){
	 $("#search_clzId").val("${search_clzId}");
	 $("#search_endState").val("${search_endState}");
 });
function editStu(id,endState) {
	layer.confirm('确定要修改学员状态么?', {icon: 3, title: '提示'}, function (index) {
		$.ajax({
	        url: '${ctx}/tEndStudent/updateSaveJS',
	        type: 'post',
	        data: {endState: endState, id: id},
	        dataType: 'json',
	        success: function (result) {
	            layer.msg("保存成功", {icon: 6});
	            freshen();
	        }
	    });
    });
}
function detailStu(id){
    $.ajax({
        url: '${ctx}/tEndStudent/detail',
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
            $("#cards").html(data.card);
            $("#sexs").html(data.sex);
            $("#places").html(data.place);
            $("#nations").html(data.nation);
            $("#maritals").html(data.marital);
            $("#eduTypes").html(data.eduType);
            $("#majors").html(data.major);
            $("#schools").html(data.school);
            $("#teachers").html(data.teacher);
            $("#offices").html(data.office);
            $("#payTypes").html(data.payType);
            $("#orgs").html(data.org);
            $("#lxrs").html(data.lxr);
            $("#lxrPhones").html(data.lxrPhone);
            $("#rss").html(data.rs);
            $("#zxs").html(data.zx);
            $("#qqs").html(data.qq);
            $("#wechats").html(data.wechat);
            $("#fkDays").html(data.fkDay);
            $("#qyDays").html(data.qyDay);
            $("#endStates").html(data.endState);
            $("#jydws").html(data.jydw);
            $("#jyxzs").html(data.jyxz);
            $("#jyrqs").html(data.jyrq);
            $("#tjrs").html(data.tjr);
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
function initSelect() {
	$.ajax({
		url : '${ctx}/tEndStudent/getClzss',
		type : 'post',
		async : false,
		dataType : 'json',
		success : function(data) {
			addOptionforObj("search_clzId", data);
			$("#search_clzId > option:eq(1)").replaceWith("<option value='0'>未分组</option>");
        	$("#search_clzId").prepend("<option value=''>请选择</option>");
        	form.render();
		}
	});
	$.ajax({
        url: '${ctx}/common/sysCode',
        data: {type: "end"},
        type: 'post',
        dataType: 'json',
        async: false,
        success: function (data) {
        	addOptionforObjNM("search_endState",data);
        }
    });
}
function updateStu(id) {
    $("#tEndStudentForm")[0].reset();
    $("#tEndStudentForm").attr("action", "${ctx}/tEndStudent/updateStu");
    $.ajax({
        url: '${ctx}/tEndStudent/detail',
        data: {id: id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
        	$("#stuId").val(id);
            $("#name").val(data.name);
            $("#age").val(data.age);
            $("#phone").val(data.phone);
            $("#edu").val(data.edu);
            $("#source").val(data.source);
            $("#getpeo").val(data.getpeo);
            $("#channel").val(data.channel);
            $("#channelDetail").val(data.channelDetail);
            $("#card").val(data.card);
            $("#sex").val(data.sex);
            $("#place").val(data.place);
            $("#nation").val(data.nation);
            $("#marital").val(data.marital);
            $("#eduType").val(data.eduType);
            $("#major").val(data.major);
            $("#school").val(data.school);
            $("#teacher").val(data.teacher);
            $("#office").val(data.office);
            $("#payType").val(data.payType);
            $("#org").val(data.org);
            $("#lxr").val(data.lxr);
            $("#lxrPhone").val(data.lxrPhone);
            $("#rs").val(data.rs);
            $("#zx").val(data.zx);
            $("#qq").val(data.qq);
            $("#wechat").val(data.wechat);
            $("#fkDay").val(data.fkDay);
            $("#qyDay").val(data.qyDay);
            form.render();
        }
    });
    var index = layer.open({
        type: 1,
        area: '800px',
        title: '学员详细',
        maxmin: true,
        content: $('#updateStuModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
        end: function () {
            $("#updateStuModal").css("display", "none");
        }
    });
}
</script>