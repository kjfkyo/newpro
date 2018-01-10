<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="roomModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="roomForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/room/save"
                  method="post">
                <input type="hidden" id="xxid" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">宿舍名称<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="name" name="name"
                               placeholder="请输入宿舍名称" lay-verify="name">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="fd" class="am-u-sm-3 am-form-label">房东<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="fd" name="fd"
                               placeholder="请输入房东姓名">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="fdPhone" class="am-u-sm-3 am-form-label">联系电话<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="fdPhone" name="fdPhone"
                               placeholder="请输入房东联系电话" lay-verify="fdPhone">
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="money" class="am-u-sm-3 am-form-label">租金<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="money"
                               name="money"
                               placeholder="请输入每月租金" lay-verify="money">
                    </div>
                </div>
                

                <div class="am-form-group">
                    <label for="startDate" class="am-u-sm-3 am-form-label">起租日期<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9" >
                        <input type="text" class="tpl-form-input" id="startDate"
                               name="startDate" placeholder="请输入起租日期" lay-verify="required"
                               onclick="layui.laydate({elem: this, festival: true})" />
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="endDate" class="am-u-sm-3 am-form-label">到期日期<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="endDate"
                               name="endDate" placeholder="请输入到期日期" lay-verify="required"
                               onclick="layui.laydate({elem: this, festival: true})" />
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="countStu" class="am-u-sm-3 am-form-label">可住人数<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="countStu"
                               name="countStu"
                               placeholder="请输入可住人数" lay-verify="countStu">
                    </div>
                </div>
				
				<div class="am-form-group">
                    <label for="addr" class="am-u-sm-3 am-form-label">地址<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="addr"
                               name="addr"
                               placeholder="请输入地址" lay-verify="addr">
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="roomForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    var form = layui.form();
    form.verify({
    	name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "宿舍名必须输入的哦";
            }
            if (value.trim().length > 48) {
                return "宿舍名最多输入48个字符哦";
            }
            /* var flag = false;
            $.ajax({
                url: "${ctx}/room/checkName",
                data: {name: value, id: $("#id").val()},
                type: "post",
                dataType: "json",
                async: false,
                success: function (data) {
                    if(data.msg=="error") {
                    	flag = true;
                    }
                }
            });
            if (flag) {
                return "宿舍名已经存在了哦";
            } */
        },
        fdPhone: function (value, item) {//value:表单值，item:表单dom对象
        	if (value.trim().length > 15) {
                return "电话最多输入15个字符哦";
            }
        },
        money: function (value, item) {
        	if (value == null || value.trim().length <= 0) {
                return "租金必须输入的哦";
            }
        },
        countStu: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "人数必须选择的哦";
            }
            if(!/^[0-9]*$/.test(value)) {
            	return "人数必须是数字";
            }
        }

    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(roomForm)', function (data) {
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#roomForm").serialize(),
            dataType: 'json',
            success: function (rs) {
            	if(rs.msg=="ok") {
	                layer.msg("保存成功", {icon: 6});
    	            freshen();
    	            layer.closeAll();
            	}else{
            		layer.msg("保存失败", {icon: 2});
            	}
            }
        });
        return false;
    });


</script>