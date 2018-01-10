<%--
  User: limiao
  Date: 2017-09-13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="tEndStudentModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="tEndStudentForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/tEndStudent/updateSaveQH"
                  method="post">
                <input type="hidden" id="ids" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">姓名</label>
                    <div class="am-u-sm-9">
                    	<span id="name"></span>
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="phone" class="am-u-sm-3 am-form-label">电话</label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="phone" name="phone" 
                               placeholder="请输入电话" lay-verify="phone">
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="jydw" class="am-u-sm-3 am-form-label">就业单位</label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="jydw" name="jydw" 
                               placeholder="请输入就业单位" lay-verify="jydw">
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="jyxz" class="am-u-sm-3 am-form-label">就业薪资</label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="jyxz" name="jyxz" 
                               placeholder="请输入就业薪资" lay-verify="jyxz">
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="jyrq" class="am-u-sm-3 am-form-label">就业日期</label>
                    <div class="am-u-sm-9">
                    	<input type="text" class="tpl-form-input" id="jyrq" name="jyrq" placeholder="请选择就业日期"  
					  		 onclick="layui.laydate({elem: this, festival: true})">
					</div>
                </div>
                <div class="am-form-group">
					<label for="tjr" class="am-u-sm-3 am-form-label">推荐人</label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="tjr" name="tjr" 
                               placeholder="请输入就业薪资" lay-verify="tjr">
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="endState" class="am-u-sm-3 am-form-label">状态</label>
                    <div class="am-u-sm-9">
                        <select id="endState" name="endState" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="tEndStudentForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
	initFormSelect();
    var form = layui.form();
	$(function(){
		form.render();
	});
    form.verify({
        phone: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "电话必须输入的哦";
            }
            if (value.trim().length > 15) {
                return "电话最多输入15个字符哦";
            }
        },
        jydw: function (value, item) {
                if (value.trim().length > 20) {
                    return "就业单位最多输入20个字符哦";
                }
        },
        jyxz: function (value, item) {
            if (value.trim().length > 8) {
            	return "就业薪资最多输入8个字符哦";
            }
        },
        tjr: function (value, item) {
        	if (value.trim().length > 5) {
            	return "推荐人最多输入5个字符哦";
        	}
        }
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(tEndStudentForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'get',
            data: $("#tEndStudentForm").serialize(),
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
	        url: '${ctx}/common/sysCode',
	        data: {type: "end"},
	        type: 'post',
	        dataType: 'json',
	        async: false,
	        success: function (data) {
	        	addOptionforObjNM("endState",data);
	        }
	    });
    }
</script>