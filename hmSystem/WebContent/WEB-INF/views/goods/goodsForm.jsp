<%--
  User: kangjianfeng
  Date: 2017-09-19
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="goodsModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="goodsForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/goods/insertGoods"
                  method="post">
                <input type="hidden" id="xxid" name="id" />
                <div class="am-form-group">
                    <label for="names" class="am-u-sm-3 am-form-label" style="width:30%">资产类型名称</label>
                    <div class="am-u-sm-9" style="width:70%">
                        <input type="text" class="tpl-form-input" id="names" name="name" 
                               placeholder="请输入资产类型" lay-verify="names">
                    </div>
                </div>
				
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="goodsForm"
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
		form.render();
	});
    var form = layui.form();
    form.verify({
    	names: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "资产类型必须输入";
            }
        }
    });
    form.on('submit(goodsForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url:data.form.action,
            type:'post',
            data:$("#goodsForm").serialize(),
            dataType:'json',
            success:function (result) {
            	if(result=="nos"){
            		layer.msg("该名称已存在，请重新添加！", {icon: 2});
            	}else{
            		layer.msg("保存成功", {icon: 6});
            	}
            	freshen();
            }
        });
        return false;
    });
</script>