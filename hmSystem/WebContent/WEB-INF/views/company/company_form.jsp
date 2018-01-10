<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="companyModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="companyForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/company/save"
                  method="post">
                <input type="hidden" id="xxid" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">企业名称<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="name" name="name"
                               placeholder="请输入名称" lay-verify="name">
                    </div>
                 </div>
                 <div class="am-form-group">
                    <label for="zt" class="am-u-sm-3 am-form-label">状态</label>
                    <div class="am-u-sm-9">
                    	<select id="zt" name="zt" lay-search style="display: none;">
                        	<option value="">请选择</option>
                        	<option value="合作">合作</option>
                        	<option value="无合作">无合作</option>
                        </select>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="lxr" class="am-u-sm-3 am-form-label">联系人<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="lxr" name="lxr"
                               placeholder="请输入联系人姓名" lay-verify="lxr">
                    </div>
                </div>
                <div class="am-form-group">
                    <label for="lxdh" class="am-u-sm-3 am-form-label">联系电话<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="lxdh" name="lxdh"
                               placeholder="请输入联系电话" lay-verify="lxdh">
                    </div>
                </div>
                
                <div class="am-form-group">
                    <label for="address" class="am-u-sm-3 am-form-label">地址<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9" >
                        <input type="text" class="tpl-form-input" id="address"
                               name="address" placeholder="请输入企业地址"/>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="whr" class="am-u-sm-3 am-form-label">维护人<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9" >
                        <input type="text" class="tpl-form-input" id="whr"
                               name="whr" placeholder="请输入维护人" lay-verify="whr"/>
                    </div>
                </div>
                
                
                <div class="am-form-group">
                    <label for="mark" class="am-u-sm-3 am-form-label">备注</label>
                    <div class="am-u-sm-9">
                        <textarea id="mark" name="mark" class="" rows="4" id="doc-ta-1"></textarea>
                    </div>
                </div>
                
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="companyForm"
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
                return "企业名称必须输入的哦";
            }
            if (value.trim().length > 48) {
                return "企业名称最多输入48个字符哦";
            }
            /* var flag = false;
            $.ajax({
                url: "${ctx}/company/checkName",
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
        lxdh: function (value, item) {//value:表单值，item:表单dom对象
        	if (value.trim().length < 1) {
                return "电话必须输入哦";
            }
        	if (value.trim().length > 15) {
                return "电话最多输入15个字符哦";
            }
        },
        lxr: function (value, item) {
        	if (value == null || value.trim().length <= 0) {
                return "联系人必须输入的哦";
            }
        },
        whr: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "维护人必须输入的哦";
            }
        }

    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(companyForm)', function (data) {
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#companyForm").serialize(),
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