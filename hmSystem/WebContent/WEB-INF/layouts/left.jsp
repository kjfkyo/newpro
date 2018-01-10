<%--
  Created by IntelliJ IDEA.
  User: limiao
  Date: 2016/12/18
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!-- 侧边导航栏 -->
<div class="left-sidebar">
    
    <!-- 菜单 -->
    <ul class="sidebar-nav">
        <li class="sidebar-nav-link">
            <a id="MM" href="${ctx}/index">
                <i class="layui-icon sidebar-nav-link-logo">&#xe609;</i>首页
            </a>
        </li>
        <c:forEach items="${MENUS}" var="m">
            <c:choose>
                <c:when test="${empty m.children}">
                    <li class="sidebar-nav-link">
                        <a id="${m.menuId}" href="${ctx}/${m.menuUrl}">
                            <i class="layui-icon sidebar-nav-link-logo">${m.menuIcon}</i>${m.menuName}
                        </a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="sidebar-nav-link">
                        <a id="${m.menuId}" href="javascript:;" class="sidebar-nav-sub-title">
                            <i class="layui-icon sidebar-nav-link-logo">${m.menuIcon}</i> ${m.menuName}
                            <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                        </a>
                        <ul class="sidebar-nav sidebar-nav-sub">
                            <c:forEach items="${m.children}" var="childern">
                                <li class="sidebar-nav-link">
                                    <a id="${childern.menuId}" class="${childern.menuPid}"
                                       href="${ctx}/${childern.menuUrl}">
                                        <span class="am-icon-angle-right sidebar-nav-link-logo"></span>${childern.menuName}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

    </ul>
</div>
<script>
    $(function () {
        var menuc = $(".sidebar-nav-link a").click(function () {
            var m_id = this.id;
            var m_Pid = this.className;
            if (m_id != null && m_id != undefined) {
                if (m_Pid.indexOf("sidebar-nav-sub-title") < 0) {
                    $.ajax({
                        url: '${ctx}/index/setMenuIdInSession',
                        type: 'post',
                        data: {menuId: m_id, menuPid: m_Pid},
                        success: function () {
                        }
                    });
                }
            }

        });

        var menuid = "${MENUID}";
        var memupid = "${MENUPID}";
        if (menuid == null || menuid == undefined || menuid == "") {
            $("#MM").addClass("active");
        } else {
            $("#" + menuid).addClass("active");
            $("#" + memupid).click();
        }


    });
</script>