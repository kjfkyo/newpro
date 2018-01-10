<%--
  User: limiao
  Date: 2017-09-09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="stuDetailModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
	<div class="widget am-cf">
        <div class="widget-body am-fr">
        	<table class="layui-table" lay-skin="nob">
			  <colgroup>
			    <col width="150">
			    <col width="200">
			    <col width="150">
			    <col width="200">
			  </colgroup>
			  <tbody>
			    <tr>
			      <td style="float:right;">姓名：</td>
			      <td><span id="names"></span></td>
			      <td style="float:right;">年龄：</td>
			      <td><span id="ages"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">电话：</td>
			      <td><span id="phones"></span></td>
			      <td style="float:right;">学历：</td>
			      <td><span id="edus"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">来源：</td>
			      <td><span id="sources"></span></td>
			      <td style="float:right;">资源获取人：</td>
			      <td><span id="getpeos"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">渠道：</td>
			      <td><span id="channels"></span></td>
			      <td style="float:right;">渠道详情：</td>
			      <td><span id="channelDetails"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">状态：</td>
			      <td><span id="basStates"></span></td>
			      <td style="float:right;">上门日期：</td>
			      <td><span id="doordays"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">创建人：</td>
			      <td><span id="createUsers"></span></td>
			      <td style="float:right;">创建时间：</td>
			      <td><span id="createTimes"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">最后修改人：</td>
			      <td><span id="updateUsers"></span></td>
			      <td style="float:right;">最后修改时间：</td>
			      <td><span id="updateTimes"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">备注：</td>
			      <td colspan="3"><span id="basMarks"></span></td>
			    </tr>
			  </tbody>
			</table>
        </div>
    </div>
</div>