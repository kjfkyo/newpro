<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="allClzssModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="allClzssForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/tEndStudent/clzss"
                  method="post">
                <input type="hidden" id="arrayId" name="arrayId" value="">

				<div class="am-form-group">
                    <label for="clzId" class="am-u-sm-3 am-form-label">项目组名称<span
                            class="tpl-form-line-small-title">&nbsp;&nbsp;</span></label>
                    <div class="am-u-sm-9">
                        <select id="clzId" name="clzId" lay-verify="clzId" lay-search style="display: none;">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="allClzssForm"
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
	initSelectClzss();
	$(function(){
		form.render();
	});
    var form = layui.form();
    form.verify({
    	clzId: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "项目组必须选择的哦";
            }
        },

    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(allClzssForm)', function (data) {
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#allClzssForm").serialize(),
            dataType: 'json',
            success: function (rs) {
            	if(rs.state=='200'){
	   	            layer.closeAll();
	                layer.msg("操作成功", {icon: 6});
	   	            freshen();
            	}else if(rs.state=='401'){
	   	            layer.closeAll();
            		layer.msg("您没有权限，请联系您的主管操作！", {icon: 5});
            	}else{
	   	            layer.closeAll();
            		layer.msg("操作失败！", {icon: 2});
            	}
            }
        });
        return false;
    });
	
    function initSelectClzss(){
    	$.ajax({
    		url: '${ctx}/common/otherCode',
            data:{tname:'T_BASI_CLZSS',filer:"to_date(end_date,'yyyy-MM-dd')>sysdate order by create_time desc"},
            type: 'post',
            async: false,
            dataType: 'json',
            success: function (data) {
            	addOptionforObj("clzId",data);
            }
        });
    }

</script>