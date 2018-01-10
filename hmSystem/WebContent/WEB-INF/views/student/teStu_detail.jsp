<%--
  User: limiao
  Date: 2017-09-11
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
			      <td style="float:right;">QQ：</td>
			      <td><span id="qqs"></span></td>
			      <td style="float:right;">微信：</td>
			      <td><span id="wechats"></span></td>
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
			      <td style="float:right;">身份证号：</td>
			      <td><span id="cards"></span></td>
			      <td style="float:right;">性别：</td>
			      <td><span id="sexs"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">籍贯：</td>
			      <td><span id="places"></span></td>
			      <td style="float:right;">民族：</td>
			      <td><span id="nations"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">婚否：</td>
			      <td><span id="maritals"></span></td>
			      <td style="float:right;">毕业类别：</td>
			      <td><span id="eduTypes"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">专业：</td>
			      <td><span id="majors"></span></td>
			      <td style="float:right;">毕业院校：</td>
			      <td><span id="schools"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">讲师：</td>
			      <td><span id="teachers"></span></td>
			      <td style="float:right;">办事处：</td>
			      <td><span id="offices"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">缴费方式：</td>
			      <td><span id="payTypes"></span></td>
			      <td style="float:right;">贷款机构：</td>
			      <td><span id="orgs"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">紧急联系人：</td>
			      <td><span id="lxrs"></span></td>
			      <td style="float:right;">紧急联系人电话：</td>
			      <td><span id="lxrPhones"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">人事：</td>
			      <td><span id="rss"></span></td>
			      <td style="float:right;">咨询：</td>
			      <td><span id="zxs"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">放款日期：</td>
			      <td><span id="fkDays"></span></td>
			      <td style="float:right;">签约日期：</td>
			      <td><span id="qyDays"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">就业单位：</td>
			      <td><span id="jydws"></span></td>
			      <td style="float:right;">就业薪资：</td>
			      <td><span id="jyxzs"></span></td>
			    </tr>
			    <tr>
			      <td style="float:right;">就业日期：</td>
			      <td><span id="jyrqs"></span></td>
			      <td style="float:right;">推荐人：</td>
			      <td><span id="tjrs"></span></td>
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
			      <td style="float:right;">状态：</td>
			      <td colspan="3"><span id="endStates"></span></td>
			    </tr>
			  </tbody>
			</table>
        </div>
    </div>
</div>