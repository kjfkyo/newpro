<%--
  User: limiao
  Date: 2017-09-11
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
                        <form id="listForm" action="${ctx}/tAdvancedStudent/list" method="get" class="layui-form am-form tpl-form-border-form tpl-form-border-br">
                        	<div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">项目组</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="search_clzId" name="search_clzId" class="am-form-field" lay-search style="width:150px; display:none;" >
                                		<option value="">请选择</option>
                                	</select>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="width: 20%;">
                                <div class="am-custom-search">状态</div>
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                	<select id="search_advState" name="search_advState" class="am-form-field" lay-search style="width:150px; display:none;">
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
									<span class="am-input-group-btn">
										<button type="button" class="am-btn  am-btn-default am-btn-success tpl-table-list-field" onclick="calss()">封班</button>
                                	</span>
                                </div>
                            </div>
                        </form>
                        <div class="am-u-sm-12">
                            <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" id="selall" onclick="toggleCheck()" /></th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>身份证号</th>
                                    <th>手机号</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${taStu.results}" var="stu">
                                    <tr>
                                    	<td>
                                    		<c:if test="${stu.claState eq '0'}">
                                    			<input type="checkbox" name="ids" onclick="getTaskIds('${stu.id}');" id="${stu.id}" value="${stu.id}" />
                                    		</c:if>
                                    	</td>
                                        <td>${stu.name}</td>
                                        <td>${stu.sex}</td>
                                        <td>${stu.card}</td>
                                        <td>${stu.phone}</td>
                                        <td>${stu.advState}</td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                            	<c:choose>
                                            		<c:when test="${stu.advState eq endState}">
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
                            <tags:pagination pages="${taStu}"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="taStu_form.jsp" %>
<%@include file="taStu_detail.jsp" %>
<%@include file="all_clzss.jsp" %>
 <script>
 	// 初始化下拉框
 	initSelect();
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
	        url: '${ctx}/tAdvancedStudent/update',
	        data: {id: id},
	        type: 'post',
	        dataType: 'json',
	        success: function (data) {
	            $("#ids").val(data.id);
	            $("#name").html(data.name);
	            $("#phone").val(data.phone);
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
	            $("#advState").val(data.advState);
	            $("#qq").val(data.qq);
	            $("#wechat").val(data.wechat);
	            $("#fkDay").val(data.fkDay);
	            $("#qyDay").val(data.qyDay);
	            $("#advMark").val(data.advMark);
	            form.render();
	        }
	    });
	    var index = layer.open({
	        type: 1,
	        id: 'update',
	        area: '800px',
	        title: '修改学员信息',
	        maxmin: true,
	        content: $('#tAdvancedStudentModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	        end: function () {
	            $("#tAdvancedStudentModal").css("display", "none");
	        }
	    });
	}
	function detailStu(id){
	    $.ajax({
	        url: '${ctx}/tAdvancedStudent/detail',
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
	            $("#advStates").html(data.advState);
	            $("#qqs").html(data.qq);
	            $("#wechats").html(data.wechat);
	            $("#fkDays").html(data.fkDay);
	            $("#qyDays").html(data.qyDay);
	            $("#advMarks").html(data.advMark);
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
	
	var arrayIds = [];
	//全选单击事件
	function toggleCheck(){
		var selall=document.getElementById("selall");
		var ids=document.getElementsByName("ids");
		if(selall.checked){
			for(var i=0;i<ids.length;i++){
				if(!ids[i].checked){
					ids[i].checked=true;
					arrayIds.splice(0,0,ids[i].value);
				}
			}
		}else{
			for(var i=0;i<ids.length;i++){
				if(ids[i].checked){
					ids[i].checked=false;
				}
			}
			arrayIds.splice(0,arrayIds.length);
		}
	}
	//单选单击事件
	function getTaskIds(id){
		var id = document.getElementById(id);
		if(id.checked){
			arrayIds.splice(0,0,id.value);
		}else{
			for(var i=0; i<arrayIds.length; i++) { 
				if(arrayIds[i] == id.value) { 
					arrayIds.splice(i, 1); 
					break;	 
				} 
			} 
		}
	}
	function calss(){
		var arrayId = "";
		for(var i=0; i<arrayIds.length; i++){
			if(i == arrayIds.length-1){
				arrayId += arrayIds[i];
			}else{
				arrayId += arrayIds[i] + ",";
			}
		}
		if(arrayIds.length > 0 ){
			$("#allClzssForm")[0].reset();
			$("#arrayId").val(arrayId);
			/*
			layer.confirm('确定要将选中的学员进行封班么?', {icon: 3, title: '提示'}, function (index) {
				 $.ajax({
			        url: '${ctx}/tEndStudent/clzss',
			        type: 'post',
			        data: {arrayId: arrayId},
			        dataType: 'json',
			        success: function (result) {
			            layer.msg("保存成功", {icon: 6});
			            freshen();
			        }
			    });
			 });*/
			layer.open({
		        type: 1,
		        area: '600px',
		        title: '选择项目组',
		        maxmin: true,
		        content: $('#allClzssModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
		        end: function () {
		            $("#allClzssModal").css("display", "none");
		        }
		    });
		}else{
			layer.msg("请选择要封班的学员", {icon: 3});
		}
	}
	
	function initSelect(){
		$.ajax({
	        url: '${ctx}/common/sysCode',
	        data: {type: "adv"},
	        type: 'post',
	        dataType: 'json',
	        async: false,
	        success: function (data) {
	        	addOptionforObjNM("search_advState",data);
	        }
	    });
		$.ajax({
	        url: '${ctx}/common/otherCode',
	        data:{tname:'T_BASI_CLZSS',filer:'1=1 order by create_time desc'},
	        type: 'post',
	        async:false,
	        dataType: 'json',
	        async: false,
	        success: function (data) {
	        	addOptionforObj("search_clzId",data);
	        	$("#search_clzId > option:eq(1)").replaceWith("<option value='0'>未分组</option>");
	        	$("#search_clzId").prepend("<option value=''>请选择</option>");
	        	form.render();
	        }
	    });
	}
</script>