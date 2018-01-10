<%--
  User: limiao
  Date: 2017-09-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="salaryModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="studentSalaryForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/salary/updateSalary"
                  method="post">
                <input type="hidden" id="primaryId" name="primaryId" value="">
                <input type="hidden" id="stuId" name="stuId" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label" >姓名</label>
                    <div class="am-u-sm-9" >
                    	<input type="text" class="tpl-form-input" id="name" name="name" 
                               placeholder="请输入姓名" lay-verify="name">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="bankNm" class="am-u-sm-3 am-form-label" >银行名称</label>
                    <div class="am-u-sm-9" >
                        <select id="bankNm" name="bankNm" lay-search style="display: none;">
                       	 <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="bankNum" class="am-u-sm-3 am-form-label" >银行卡号</label>
                    <div class="am-u-sm-9" >
                        <input type="text" class="tpl-form-input" id="bankNum" name="bankNum" 
                               placeholder="请输入银行卡号" lay-verify="bankNum">
                    </div>
                </div>

				<div class="am-form-group">
                    <label for="salMoney" class="am-u-sm-3 am-form-label" >金额</label>
                    <div class="am-u-sm-9" >
                        <input type="text" class="tpl-form-input" id="salMoney" name="salMoney" 
                               placeholder="请输入金额" lay-verify="salMoney">
                    </div>
                </div>
                
                
                <div style="text-align: center;">
                	备注：该学员已经发放<span id="count" style="color: #ff0000"></span>次补助
                </div>
                
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="studentSalaryForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
	$(function(){
		initSelectClz();
	});
    var form = layui.form();
    form.verify({
    	name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "姓名必须输入的哦";
            }
        },
        bankNum: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "银行卡号必须输入的哦";
            }
        },
        salMoney: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "金额必须输入的哦";
            }
        	if(value > 1000){
        		return "金额必须小于等于1000";
        	}
        }
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(studentSalaryForm)', function (data) {
    	layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'get',
            data: $("#studentSalaryForm").serialize(),
            dataType: 'json',
            success: function (data) {
            	if(data.msg=="ok") {
	                layer.msg("保存成功", {icon: 6});
	                freshen();
            	}else{
            		layer.msg("保存失败", {icon: 2});
            	}
            }
        });
        return false;
    });
    function initSelectClz(){
    	$.ajax({
            url: '${ctx}/salary/getBankNm',
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	addOptionforObjNM("bankNm",data);
            }
        });
    }
</script>