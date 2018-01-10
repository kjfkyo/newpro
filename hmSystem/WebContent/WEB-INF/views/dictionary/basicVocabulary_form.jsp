<%--
  User: liqingwei
  Date: 2017-09-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="TBasiCodeModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="TBasiCodeForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/TBasiCode/save"
                  method="post">
                <input type="hidden" id="xxid" name="id" value="">
                
                <div class="am-form-group">
                    <label for="Name" class="am-u-sm-3 am-form-label">词汇<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="Name" name="Name"
                               placeholder="请输入词汇" lay-verify="Name">
                        <%-- <small>请填写标题文字10-20字左右。</small>--%>
                    </div>
                </div>
 				
                        <input type="hidden" value="${flag}" id="flag" name="flag" lay-verify="flag">
                

                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="TBasiCodeForm"
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
        	Name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "词汇必须输入的哦";
            }
            if (value.trim().length > 30) {
                return "词汇最多输入30个字符哦";
            }
          
           
        },
       

    });
    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(TBasiCodeForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#TBasiCodeForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
               
              window.location.href="${ctx}/TBasiCode/list?type="+result;
            
            }
        });
        return false;
    });


</script>