<%--
  User: limiao
  Date: 2017-09-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="tAdvancedStudentModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="tAdvancedStudentForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/tAdvancedStudent/updateSave"
                  method="post">
                <input type="hidden" id="ids" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label" style="width:15%">姓名</label>
                    <div class="am-u-sm-9" style="width:30%">
                    	<span id="name"></span>
                    </div>
                    <label for="card" class="am-u-sm-3 am-form-label" style="width:20%">身份证号</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="card" name="card" 
                               placeholder="请输入身份证号" lay-verify="card">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="sex" class="am-u-sm-3 am-form-label" style="width:15%">性别</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="sex" name="sex" lay-search style="display: none;">
                        	<option value="男">男</option>
                        	<option value="女">女</option>
                        </select>
                    </div>
                    <label for="phone" class="am-u-sm-3 am-form-label" style="width:20%">电话</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="phone" name="phone" 
                               placeholder="请输入电话" lay-verify="phone">
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="place" class="am-u-sm-3 am-form-label" style="width:15%">籍贯</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="place" name="place" 
                               placeholder="请输入籍贯" lay-verify="place">
                    </div>
                    <label for="nation" class="am-u-sm-3 am-form-label" style="width:20%">民族</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="nation" name="nation" 
                               placeholder="请输入民族" lay-verify="nation">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="marital" class="am-u-sm-3 am-form-label" style="width:15%">婚否</label>
                    <div class="am-u-sm-9" style="width:30%">
                    	<select id="marital" name="marital" lay-search style="display: none;">
                        	<option value="未婚">未婚</option>
                        	<option value="已婚">已婚</option>
                        </select>
                    </div>
                    <label for="eduType" class="am-u-sm-3 am-form-label" style="width:20%">毕业类别</label>
                    <div class="am-u-sm-9" style="width:30%">
                    	<select id="eduType" name="eduType" lay-search style="display: none;">
                        	<option value="应届">应届</option>
                        	<option value="往届">往届</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                	<label for="school" class="am-u-sm-3 am-form-label" style="width:15%">毕业院校</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="school" name="school" 
                               placeholder="请输入毕业院校">
                    </div>
                    <label for="major" class="am-u-sm-3 am-form-label" style="width:20%">专业</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="major" name="major" 
                               placeholder="请输入专业">
                    </div>
                </div>
                
				<div class="am-form-group">
                    <label for="teacher" class="am-u-sm-3 am-form-label" style="width:15%">讲师</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="teacher" name="teacher" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                    <label for="office" class="am-u-sm-3 am-form-label" style="width:20%">办事处</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="office" name="office" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="payType" class="am-u-sm-3 am-form-label" style="width:15%">缴费方式</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="payType" name="payType" lay-search style="display: none;">
                        	<option value="分期">分期</option>
                        	<option value="全款">全款</option>
                        	<option value="现金分期">现金分期</option>
                        </select>
                    </div>
                    <label for="org" class="am-u-sm-3 am-form-label" style="width:20%">贷款机构</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="org" name="org" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                </div>
				
				<div class="am-form-group">
                    <label for="lxr" class="am-u-sm-3 am-form-label" style="width:15%">紧急联系人</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="lxr" name="lxr" 
                               placeholder="请输入紧急联系人" lay-verify="lxr">
                    </div>
                    <label for="lxrPhone" class="am-u-sm-3 am-form-label" style="width:20%">紧急联系人电话</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="lxrPhone" name="lxrPhone" 
                               placeholder="请输入紧急联系人电话" lay-verify="lxrPhone">
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="rs" class="am-u-sm-3 am-form-label" style="width:15%">人事</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="rs" name="rs" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                    <label for="zx" class="am-u-sm-3 am-form-label" style="width:20%">咨询</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="zx" name="zx" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="qq" class="am-u-sm-3 am-form-label" style="width:15%">QQ</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="qq" name="qq" 
                               placeholder="请输入qq号码">
                    </div>
                    <label for="wechat" class="am-u-sm-3 am-form-label" style="width:20%">微信</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="wechat" name="wechat" 
                               placeholder="请输入微信号码">
                    </div>
                </div>
                
                <div class="am-form-group">
					<label for="qyDay" class="am-u-sm-3 am-form-label" style="width:15%">签约日期</label>
                    <div class="am-u-sm-9" style="width:30%">
					  <input type="text" class="tpl-form-input" id="qyDay" name="qyDay" placeholder="请选择签约日期"  
					  		 onclick="layui.laydate({elem: this, festival: true})">
					</div>
					<label for="fkDay" class="am-u-sm-3 am-form-label" style="width:20%">放款日期</label>
                    <div class="am-u-sm-9" style="width:30%">
					  <input type="text"class="tpl-form-input" id="fkDay" name="fkDay" placeholder="请选择放款日期"  
					  		 onclick="layui.laydate({elem: this, festival: true})">
					</div>
                </div>
                
                <div class="am-form-group">
                    
                </div>
                
                <div class="am-form-group">
                    <label for="advState" class="am-u-sm-3 am-form-label" style="width:15%">状态</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="advState" name="advState" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                    <label for="" class="am-u-sm-3 am-form-label" style="width:20%"></label>
                    <div class="am-u-sm-9" style="width:30%">
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="advState" class="am-u-sm-3 am-form-label" style="width:15%">备注</label>
                    <div class="am-u-sm-9" style="width:85%">
                        <textarea id="advMark" name="advMark" class="" rows="4" id="doc-ta-1"></textarea>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="tAdvancedStudentForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
	//初始化表单下拉框
	initFormSelect();
	$(function(){
		form.render();
	});
    var form = layui.form();
    form.verify({
    	card: function (value, item) {//value:表单值，item:表单dom对象
    		var advState = $("#advState").val();
        	if(advState == '${endState}'){
	            if (value == null || value.trim().length <= 0) {
	                return "身份证号必须输入的哦";
	            }
	            if (value.trim().length != 18) {
	                return "身份证号必须18位";
	            }
        	}
            if (value.trim().length > 18) {
                return "身份证号最多输入18个字符哦";
            }
        },
        phone: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "电话必须输入的哦";
            }
            if (value.trim().length > 12) {
                return "电话最多输入12个字符哦";
            }
        },
        place: function (value, item) {
            if (value.trim().length > 10) {
                return "籍贯最多输入10个字符哦";
            }
        },
        nation: function (value, item) {
            if (value.trim().length > 5) {
            	return "民族最多输入5个字符哦";
            }
        },
        lxr: function (value, item) {
            if (value.trim().length > 5) {
            	return "紧急联系人最多输入5个字符哦";
            }
        },
        lxrPhone: function (value, item) {
        	if (value.trim().length > 15) {
            	return "紧急联系人电话最多输入15个字符哦";
        	}
        },
        fkDay: function(value, item){
        	var advState = $("#advState").val();
        	if(advState == '${endState}'){
        		if (value == null || value.trim().length <= 0) {
                    return "放款日期必须输入的哦";
                }
        	}
        },
        qyDay: function(value, item){
        	var advState = $("#advState").val();
        	if(advState == '${endState}'){
        		if (value == null || value.trim().length <= 0) {
                    return "签约日期必须输入的哦";
                }
        	}
        }
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(tAdvancedStudentForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'get',
            data: $("#tAdvancedStudentForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
                freshen();
            }
        });
        return false;
    });
    
    function initFormSelect(){
    	$.ajax({
            url: '${ctx}/common/getUser',
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("rs",data);
            	addOptionforObjNM("zx",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/getUser',
            type: 'post',
            data:{role:"teacher"},
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("teacher",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "adv"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("advState",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "ofa"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("office",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "mon"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("org",data);
            }
        });
    }
</script>