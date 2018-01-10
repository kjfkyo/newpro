<%--
  User: why
  Date: 2017-11-06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="updateStuModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
	<div class="widget am-cf">
        <div class="widget-body am-fr">
			<form id="tEndStudentForm"
				class="layui-form am-form tpl-form-border-form tpl-form-border-br"
				action="${ctx}/tEndStudent/updateStu" method="post">
                <input type="hidden" id="stuId" name="stuId" value="">
				<table class="layui-table" lay-skin="nob">
					<tbody>
						<tr>
							<td style="float: right;">姓名：</td>
							<td><input type="text" class="tpl-form-input" id="name"
								name="name" placeholder="请输入姓名" lay-verify="names"></td>
							<td style="float: right;">年龄：</td>
							<td><input type="text" class="tpl-form-input" id="age"
								name="age" placeholder="请输入年龄" lay-verify="ages"></td>
						</tr>
						<tr>
							<td style="float: right;">电话：</td>
							<td><input type="text" class="tpl-form-input" id="phone"
								name="phone" placeholder="请输入电话" lay-verify="phone"></td>
							<td style="float: right;">学历：</td>
							<td><input type="text" class="tpl-form-input" id="edu"
								name="edu" placeholder="请输入学历" lay-verify="edu"></td>
						</tr>
						<tr>
							<td style="float: right;">QQ：</td>
							<td><input type="text" class="tpl-form-input" id="qq"
								name="qq" placeholder="请输入QQ号码" lay-verify="qq"></td>
							<td style="float: right;">微信：</td>
							<td><input type="text" class="tpl-form-input" id="wechat"
								name="wechat" placeholder="请输入微信号码" lay-verify="wechat"></td>
						</tr>
						<tr>
							<td style="float: right;">来源：</td>
							<td><input type="text" class="tpl-form-input" id="source"
								name="source" placeholder="请输入来源" lay-verify="source"></td>
							<td style="float: right;">资源获取人：</td>
							<td><input type="text" class="tpl-form-input" id="getpeo"
								name="getpeo" placeholder="请输入资源获取人" lay-verify="getpeo"></td>
						</tr>
						<tr>
							<td style="float: right;">渠道：</td>
							<td><input type="text" class="tpl-form-input" id="channel"
								name="channel" placeholder="请输入渠道" lay-verify="channel"></td>
							<td style="float: right;">渠道详情：</td>
							<td><input type="text" class="tpl-form-input"
								id="channelDetail" name="channelDetail" placeholder="请输入渠道详情"
								lay-verify="channelDetail"></td>
						</tr>
						<tr>
						<td style="float: right;">身份证号：</td>
							<td><input type="text" class="tpl-form-input" id="card"
								name="card" placeholder="请输入身份证号" lay-verify="card"></td>
							<td style="float: right;">性别：</td>
							<td>
							<select id="sex" name="sex" lay-search style="display: none;">
			                        	<option value="">请选择</option>
			                        	<option value="男">男</option>
			                        	<option value="女">女</option>
			                        </select>
							</td>
						</tr>
						<tr>
							<td style="float: right;">籍贯：</td>
							<td><input type="text" class="tpl-form-input" id="place"
								name="place" placeholder="请输入籍贯" lay-verify="place"></td>
							<td style="float: right;">民族：</td>
							<td><input type="text" class="tpl-form-input" id="nation"
								name="nation" placeholder="请输入民族" lay-verify="nation"></td>
						</tr>
						<tr>
							<td style="float: right;">婚否：</td>
							<td><select id="marital" name="marital" lay-search style="display: none;">
	                        	<option value="未婚">未婚</option>
	                        	<option value="已婚">已婚</option>
	                        	</select></td>
							<td style="float: right;">毕业类别：</td>
							<td><select id="eduType" name="eduType" lay-search style="display: none;">
	                        	<option value="应届">应届</option>
	                        	<option value="往届">往届</option>
	                        </select></td>
						</tr>
						<tr>
							<td style="float: right;">专业：</td>
							<td><input type="text" class="tpl-form-input" id="major"
								name="major" placeholder="请输入专业" lay-verify="major"></td>
							<td style="float: right;">毕业院校：</td>
							<td><input type="text" class="tpl-form-input" id="school"
								name="school" placeholder="请输入毕业院校" lay-verify="school"></td>
						</tr>
						<tr>
							<td style="float: right;">讲师：</td>
							<td>
							<select id="teacher" name="teacher" lay-search style="display: none;">
	                        	<option value="">请选择</option>
	                        </select></td>
							<td style="float: right;">办事处：</td>
							<td><select id="office" name="office" lay-search style="display: none;">
	                        	<option value="">请选择</option>
	                        </select></td>
						</tr>
						<tr>
							<td style="float: right;">缴费方式：</td>
							<td> <select id="payType" name="payType" lay-search style="display: none;">
                        	<option value="分期">分期</option>
                        	<option value="全款">全款</option>
                        	<option value="现金分期">现金分期</option>
                        </select></td>
							<td style="float: right;">贷款机构：</td>
							<td><select id="org" name="org" lay-search style="display: none;">
	                        	<option value="">请选择</option>
	                        </select></td>
						</tr>
						<tr>
							<td style="float: right;">紧急联系人：</td>
							<td><input type="text" class="tpl-form-input" id="lxr"
								name="lxr" placeholder="请输入紧急联系人" lay-verify="lxr"></td>
							<td style="float: right;">紧急联系人电话：</td>
							<td><input type="text" class="tpl-form-input" id="lxrPhone"
								name="lxrPhone" placeholder="请输入紧急联系人电话" lay-verify="lxrPhone"></td>
						</tr>
						<tr>
							<td style="float: right;">人事：</td>
							<td><select id="rs" name="rs" lay-search style="display: none;">
	                        	<option value="">请选择</option>
	                        </select></td>
							<td style="float: right;">咨询：</td>
							<td><select id="zx" name="zx" lay-search style="display: none;">
	                        	<option value="">请选择</option>
	                        </select></td>
						</tr>
						<tr>
							<td style="float: right;">放款日期：</td>
							<td><input type="text" class="tpl-form-input" id="fkDay"
								name="fkDay" placeholder="请输入放款日期" lay-verify="fkDay"
								onclick="layui.laydate({elem: this, festival: true})"></td>
							<td style="float: right;">签约日期：</td>
							<td><input type="text" class="tpl-form-input" id="qyDay"
								name="qyDay" placeholder="请输入签约日期" lay-verify="qyDay"
								onclick="layui.laydate({elem: this, festival: true})"></td>
						</tr>
					</tbody>
				</table>
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
	$(function(){
		form.render();
	});
	var form = layui.form();
	//监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
	form.on('submit(tEndStudentForm)', function (data) {
	    layer.closeAll();
	    $.ajax({
	        url: '${ctx}/tEndStudent/updateStu',
	        type: 'post',
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
            url: '${ctx}/common/getUser',
            type: 'post',
            data:{role:"rs"},
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("rs",data);
            	addOptionforObjNM("zx",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/getUser',
            type: 'post',
            data:{role:"teacher"},
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("teacher",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "ofa"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("office",data);
            }
        });
    	$.ajax({
            url: '${ctx}/common/sysCode',
            data: {type: "mon"},
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
            	addOptionforObjNM("org",data);
            }
        });
    }
</script>


