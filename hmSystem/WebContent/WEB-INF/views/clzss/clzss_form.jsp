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
                <div class="am-form-group" style="40px">
                </div>
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">项目组名称</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="name" name="name" 
                               placeholder="请输项目组名称" lay-verify="name">
                    </div>
                    <label for="teaId" class="am-u-sm-3 am-form-label" style="width:15%">工程师</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <select id="teaId" name="teaId" lay-search style="display: none;">
                            <option value="">请选择</option>
                            <c:forEach items="${user}" var="u">
                                <option value="${u.name}">${u.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                
                <div class="am-form-group">
                    <label for="qq" class="am-u-sm-3 am-form-label">QQ群</label>
                    <div class="am-u-sm-9" style="width:30%">
                        <input type="text" class="tpl-form-input" id="qq" name="qq" 
                               placeholder="请输QQ群" lay-verify="qq">
                    </div>
                    <label for="startDate" class="am-u-sm-3 am-form-label" style="width:15%">开班日期</label>
                    <div class="am-u-sm-9" style="width:30%">
					  <input type="text" class="tpl-form-input" id="startDate" name="startDate" placeholder="请选择开班日期"  
					  		 lay-verify="startDate" onclick="layui.laydate({elem: this, festival: true})">
					</div>
                </div>
				<div class="am-form-group">
                    <label for="endDate" class="am-u-sm-3 am-form-label" style="width:25%">结课日期</label>
                    <div class="am-u-sm-9" style="width:30%">
					  <input type="text" class="tpl-form-input" id="endDate" name="endDate" placeholder="请选择结课日期"  
					  		 lay-verify="endDate" onclick="layui.laydate({elem: this, festival: true})">
					</div>
					<label class="am-u-sm-3 am-form-label" style="width:15%"></label>
                    <div class="am-u-sm-9" style="width:30%">
					</div>
                </div>
                <div class="am-form-group">
                    <label for="mark" class="am-u-sm-3 am-form-label">备注</label>
                    <div class="am-u-sm-9">
                        <textarea id="mark" name="mark" class="" rows="4" id="mark" lay-verify="mark"></textarea>
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
	$(function(){
		form.render();
	});
    var form = layui.form();
    form.verify({
        name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "项目组名必须输入的哦";
            }
            if (value.trim().length > 15) {
                return "项目组名最多输入15个字符哦";
            }
        },
        qq: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "QQ群必须输入的哦";
            }
            if (value.trim().length > 15) {
                return "QQ群最多输入15个字符哦";
            }
        },
     
        startDate: function (value, item) {//状态改为上门时，必须添加上门时间
            	if (value == null || value.trim().length <= 0) {
                    return "开班日期必须输入的哦";
                }
        }
        
    });

  //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(tAdvancedStudentForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: '${ctx}/clzss/updateClzss',
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

</script>