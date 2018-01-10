<%--
  User: limiao
  Date: 2017-09-08
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">学员管理</a></li>
                        <li class="am-active">添加学员</li>
                    </ol>
            <form id="tBasiStudentForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/tBasiStudent/addSave" 
                  method="post">
                <input type="hidden" id="id" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">姓名</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="name" name="name" 
                               placeholder="请输入学员姓名" lay-verify="name">
                    </div>
                    <label for="age" class="am-u-sm-3 am-form-label" style="width:15%">年龄</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="age" name="age" lay-search style="display: none;">
                            <c:forEach items="${ages}" var="age">
                                <option value="${age}">${age}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="phone" class="am-u-sm-3 am-form-label">电话</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="phone" name="phone" 
                               placeholder="请输入电话" lay-verify="phone">
                    </div>
                    <label for="edu" class="am-u-sm-3 am-form-label" style="width:15%">学历</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="edu" name="edu" lay-search style="display: none;">
                        	<option value="无学历">无学历</option>
                        	<option value="初中">初中</option>
                        	<option value="高中">高中</option>
                        	<option value="中专">中专</option>
                        	<option value="大专">大专</option>
                        	<option value="本科">本科</option>
                        	<option value="硕士">硕士</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="source" class="am-u-sm-3 am-form-label">来源</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="source" name="source" lay-search style="display: none;">
                        	<option value="下载">下载</option>
                        	<option value="咨询">咨询</option>
                        	<option value="投递">投递</option>
                        	<option value="微聊">微聊</option>
                        	<option value="拓展">拓展</option>
                        	<option value="转介绍">转介绍</option>
                        </select>
                    </div>
                    <label for="getpeo" class="am-u-sm-3 am-form-label" style="width:15%">资源获取人</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="getpeo" name="getpeo" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="channel" class="am-u-sm-3 am-form-label">渠道</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select onchange="initChannel(this)" lay-ignore id="channel" name="channel" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        	<option value="网咨">网资</option>
                        	<option value="代理">代理</option>
                        	<option value="高校">高校</option>
                        	<option value="地面">地面</option>
                        </select>
                    </div>
                    <label for="channelDetail" class="am-u-sm-3 am-form-label" style="width:15%">渠道详情</label>
                    <div class="am-u-sm-9" style="width:30%">
                    	<select id="channelDetail" name="channelDetail" lay-search style="display: none;">
                    		<option value="">请选择</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="basState" class="am-u-sm-3 am-form-label">状态</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="basState" name="basState" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                    <label for="doorday" class="am-u-sm-3 am-form-label" style="width:15%">上门日期</label>
                    <div class="am-u-sm-9" style="width:30%">
					  <input type="text" class="tpl-form-input" id="doorday" name="doorday" placeholder="请选择上门日期"  
					  		 lay-verify="doorday" onclick="layui.laydate({elem: this, festival: true})">
					</div>
                </div>

                <div class="am-form-group">
                    <label for="basMark" class="am-u-sm-3 am-form-label">备注</label>
                    <div class="am-u-sm-9">
                        <textarea id="basMark" name="basMark" class="" rows="4" id="doc-ta-1" lay-verify="basMark"></textarea>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="tBasiStudentForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>
			</div>
			</div>
        </div>
    </div>
</div>

<script>
    var form = layui.form();
    //初始化下拉框
	initSelect();
	$(function(){
		form.render();
	});
    form.verify({
        name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "姓名必须输入的哦";
            }
            if (value.trim().length > 5) {
                return "姓名最多输入5个字符哦";
            }
        },
        phone: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "电话必须输入的哦";
            }
            if (value.trim().length > 15) {
                return "电话最多输入15个字符哦";
            }
        },
        channel: function (value, item) {
            var channel = $("#channel").val();
            

        },
        doorday: function (value, item) {//状态改为上门时，必须添加上门时间
        	var basState = $("#basState").val();
            if (basState == '${endState}' ) {
            	if (value == null || value.trim().length <= 0) {
                    return "上门日期必须输入的哦";
                }
            }
        },
        basMark: function (value, item) {//来源是转介绍的，必须添加备注信息
            if (value.trim().length > 50) {
                return "备注最多输入50个字符哦";
            }
        }
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(tBasiStudentForm)', function (data) {
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#tBasiStudentForm").serialize(),
            dataType: 'json',
            success: function (result) {
            	if(result=="error"){
            		layer.msg("该学生信息已存在，不可重复录入！", {icon: 6});
                }else{
            		layer.msg("保存成功", {icon: 6});
            	}
            }
        });
        $("#tBasiStudentForm")[0].reset();
        return false;
    });
	
    function initSelect(){
    	$.ajax({
            url: '${ctx}/common/getUser',
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("getpeo",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "bas"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("basState",data);
            }
        });
    }

    function initChannel(obj){
    	var val = $(obj).val();
    	var list;
    	if(val=="网咨"){
    		$.ajax({
                url: '${ctx}/common/sysCode',
                data: {type: "net"},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (data) {
                	list = data;	
                }
            });
    	}else if(val=="地面"){
    		$.ajax({
                url: '${ctx}/common/sysCode',
                data: {type: "lan"},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (data) {
                	list = data;	
                }
            });
    	}else if(val=="高校"){
    		$.ajax({
                url: '${ctx}/common/otherCode',
                data: {tname: "t_basi_school"},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (data) {
                	list = data;	
                }
            });
    	}else if(val=="代理"){
    		$.ajax({
                url: '${ctx}/common/otherCode',
                data: {tname: "t_basi_agency"},
                type: 'post',
                dataType: 'json',
                async: false,
                success: function (data) {
                	list = data;	
                }
            });
    	}
    	addOptionforObjNM("channelDetail",list);
    	form.render();
    }
</script>