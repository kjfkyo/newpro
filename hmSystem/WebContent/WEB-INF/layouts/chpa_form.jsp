<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="chpaModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="chpaForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/Chpa/update"
                  method="post">
                <input type="hidden" id="id" name="id" value="">
               

                <div class="am-form-group">
                    <label for="oldpa" class="am-u-sm-3 am-form-label">旧密码<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="oldpa" name="oldpa"
                               placeholder="请输入旧密码" lay-verify="oldpa">
                    </div>
                </div>

                <div class="am-form-group" id="passwordDiv">
                    <label for="password" class="am-u-sm-3 am-form-label">新密码 <span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="password" class="tpl-form-input" id="password" name="password"
                               placeholder="请输入新密码" lay-verify="password">
                    </div>
                </div>

                <div class="am-form-group" id="plainPasswordDiv">
                    <label for="plainPassword" class="am-u-sm-3 am-form-label">重复密码 <span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="password" class="tpl-form-input" id="plainPassword"
                               name="plainPassword"
                               placeholder="请再次输入密码" lay-verify="plainPassword">
                    </div>
                </div>

               

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="chpaForm"
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
    	oldpa: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "密码必须输入的哦";
            }
            if (value.trim().length > 30) {
                return "密码最多输入30个字符哦";
            }
            var bo = false;
            $.ajax({
                url: "${ctx}/Chpa/vali",
                data: {oldpa:$("#oldpa").val()},
                type: "post",
                dataType: "json",
                async: false,
                success: function (data) {
                    bo = data;
                }
            });
            if (!bo) {
                return "密码错误";
            }
        },
      
      
        password: function (value, item) {
            
                if (value == null || value.trim().length <= 0) {
                    return "密码必须输入的哦";
                }
                if (value != $("#plainPassword").val()) {
                    return "两次输入的密码不一样哦";
                }
           

        },
        plainPassword: function (value, item) {
            
                if (value == null || value.trim().length <= 0) {
                    return "重复密码必须输入的哦";
                }
                if (value != $("#password").val()) {
                    return "两次输入的密码不一样哦";
                }
           
        }
      
    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(chpaForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: {plainPassword:$("#plainPassword").val()},
            dataType: 'json',
            success: function (result) {
            
            	
                layer.msg("保存成功", {icon: 6});
            	
                freshen();
            }
        });
        return false;
    });


</script>