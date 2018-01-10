<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="freeRoomModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="freeRoomForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/room/insertStu"
                  method="post">
                <input type="hidden" id="stuId" name="stuId" value="">

				<div class="am-form-group">
                    <label for="roomId" class="am-u-sm-3 am-form-label">宿舍名称<span
                            class="tpl-form-line-small-title">&nbsp;&nbsp;</span></label>
                    <div class="am-u-sm-9">
                        <select id="roomId" name="roomId" lay-verify="roomId" lay-search style="display: none;">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="freeRoomForm"
                                class="am-btn am-btn-primary tpl-btn-bg-color-success ">保存
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
	//初始化下拉框
	initSelectRoom();
	$(function(){
		form.render();
	});
    var form = layui.form();
    form.verify({
    	roomId: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "宿舍必须选择的哦";
            }
        },

    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(freeRoomForm)', function (data) {
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#freeRoomForm").serialize(),
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
	
    function initSelectRoom(){
    	$.ajax({
            url: '${ctx}/room/freeRoom',
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	addOptionforObj("roomId",data);
            }
        });
    }

</script>