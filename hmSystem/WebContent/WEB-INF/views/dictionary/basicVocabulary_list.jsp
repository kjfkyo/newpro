<%--
  User: liqingwei
  Date: 2017-09-11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">数据词典维护</a></li>
                        <li class="am-active">基本词汇维护</li>
                    </ol>

                    <div class="widget-body  am-fr">
                    	
                        <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                            <div class="am-form-group">
                                <div class="am-btn-toolbar">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button type="button" onclick="addTBasiCode();"
                                                class="am-btn am-btn-default am-btn-success">
                                            <span class="am-icon-plus"></span> 添加
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form id="listForm" action="${ctx}/TBasiCode/list" method="get">
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="float: right;">
                                <div class="am-custom-search">关键字</div>
                                <div
                                        class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" name="keyword" class="am-form-field" value="${keyword}"
                                           placeholder="请输入关键字查询"> 
                                           <input type="hidden" id="type" name="type" class="am-form-field" value="${flag}">
                                        <span
                                        class="am-input-group-btn">
									<button
                                            class="am-btn  am-btn-default am-btn-success tpl-table-list-field"
                                            type="submit">查询</button>
								</span>
                                </div>
                            </div>
                        </form>
                        
                        <form id="Form" action="${ctx}/TBasiCode/list" method="get">
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4" style="float: right;">
                                <div class="am-custom-search">词汇类别</div>
                                <div
                                        class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                   <select id="type" name="type" lay-verify="type" lay-search style="height:33px;font-size:13px;width:200px;" onchange="submit();">
                            			<option value="1">请选择</option>
                            			
                              			<option value="dep" <c:if test="${'dep'==flag}"><c:out value="selected=selected"/></c:if>>部门</option>
                           				<option value="gra" <c:if test="${'gra'==flag}"><c:out value="selected=selected"/></c:if>>级别</option>
                           				<option value="ofa" <c:if test="${'ofa'==flag}"><c:out value="selected=selected"/></c:if>>办事处</option>
                           				<option value="bas" <c:if test="${'bas'==flag}"><c:out value="selected=selected"/></c:if>>基础学员状态</option>
                           				<option value="adv" <c:if test="${'adv'==flag}"><c:out value="selected=selected"/></c:if>>中级学员状态</option>
                           				<%-- <option value="nom" <c:if test="${'nom'==flag}"><c:out value="selected=selected"/></c:if>>正式学员状态</option> --%>
                           				<option value="end" <c:if test="${'end'==flag}"><c:out value="selected=selected"/></c:if>>正式学员状态</option>
                           				<option value="mon" <c:if test="${'mon'==flag}"><c:out value="selected=selected"/></c:if>>贷款机构</option>
                           				<option value="ban" <c:if test="${'ban'==flag}"><c:out value="selected=selected"/></c:if>>银行</option>
                           				<option value="net" <c:if test="${'net'==flag}"><c:out value="selected=selected"/></c:if>>网络</option>
                           				<option value="lan" <c:if test="${'lan'==flag}"><c:out value="selected=selected"/></c:if>>地面</option>
                        			</select>
                          
                                        
									
								</span>
                                </div>
                            </div>
                        </form>
                        <div class="am-u-sm-12">
                            <table width="100%"
                                   class="am-table am-table-compact am-table-striped tpl-table-black "
                                   id="example-r">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>词汇</th>
                                    <th>创建时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%int i = 0; %>
                                <c:forEach items="${tBasiCode.results}" var="tBasiCode">
                                    <tr>
                                        <td><%=++i %></td>
                                       
                                        <td>${tBasiCode.name}</td>
                                       
                                        <td><fmt:formatDate value="${tBasiCode.createTime}"
                                                            pattern="yyyy-MM-dd"/></td>
                                        <td>
                                            <div class="tpl-table-black-operation">
                                                <a href="javascript:;" onclick="editTBasiCode('${tBasiCode.id}')"> <i
                                                        class="am-icon-pencil"></i>编辑
                                                </a> 
                                                <a href="javascript:;" onclick="deleteUser('${tBasiCode.id}');"
                                                        class="tpl-table-black-operation-del"> <i
                                                    class="am-icon-trash"></i> 删除
                                            	</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <tags:pagination pages="${tBasiCode}" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="basicVocabulary_form.jsp" %>
<script>

    function addTBasiCode() {
    	if($("#type").val()=="1"){
      		 layer.msg("请选择类别", {icon: 5,anim:6,time:1000});
      		 return ;
    	}
        $("#TBasiCodeForm")[0].reset();
        $("#TBasiCodeForm").attr("action", "${ctx}/TBasiCode/save");
        $("#passwordDiv").css("display", "");
        $("#plainPasswordDiv").css("display", "");
        layer.open({
            type: 1,
            area: '800px',
            title: '添加词汇',
            maxmin: true,
            content: $('#TBasiCodeModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#TBasiCodeModal").css("display", "none");
            }
        });
        form.render();
    }

    function editTBasiCode(id) {
        $("#TBasiCodeForm")[0].reset();
        $("#TBasiCodeForm").attr("action", "${ctx}/TBasiCode/save");
        $("#passwordDiv").css("display", "none");
        $("#plainPasswordDiv").css("display", "none");
        $.ajax({
            url: '${ctx}/TBasiCode/findTBasiCodeById',
            data: {id: id},
            type: 'post',
            dataType: 'json',
            success: function (data) {
            	 $("#xxid").val(data.id);
                $("#Name").val(data.name);
                form.render();
            }
        });
        var index = layer.open({
            type: 1,
            id: 'update',
            area: '800px',
            title: '修改办公点名称',
            maxmin: true,
            content: $('#TBasiCodeModal'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            end: function () {
                $("#TBasiCodeModal").css("display", "none");
            }
        });
    }

    function deleteUser(id) {
        layer.confirm('确定要删除么?', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                url: '${ctx}/TBasiCode/deleteTBasiCodeById',
                data: {id: id},
                type: 'post',
                success: function (result) {
                    layer.msg("删除成功", {icon: 6});
                    window.location.href="${ctx}/TBasiCode/list?type="+ $("#type").val();
                }
            });
            layer.close(index);
        });

    }

   
</script>