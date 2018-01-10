<%--
  User: limiao
  Date: 2017-06-29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="roleModal" class="am-u-sm-12 am-u-md-12 am-u-lg-12" style="display: none;">
    <div class="widget am-cf">
        <div class="widget-body am-fr">
            <form id="roleForm" class="layui-form am-form tpl-form-border-form tpl-form-border-br"
                  action="${ctx}/role/save"
                  method="post">
                <input type="text" id="ids" name="id" value="">
                <div class="am-form-group">
                    <label for="name" class="am-u-sm-3 am-form-label">角色名称<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <input type="text" class="tpl-form-input" id="name" name="name"
                               placeholder="请输入角色名称" lay-verify="name">
                        <%-- <small>请填写标题文字10-20字左右。</small>--%>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="explains" class="am-u-sm-3 am-form-label">说明<span
                            class="tpl-form-line-small-title">&nbsp;&nbsp;</span></label>
                    <div class="am-u-sm-9">
                        <textarea id="explains" name="explains" class="" rows="4" id="doc-ta-1"></textarea>
                    </div>
                </div>

                <div class="am-form-group">
                    <label for="roles" class="am-u-sm-3 am-form-label">功能权限<span
                            class="tpl-form-line-small-title">*</span></label>
                    <div class="am-u-sm-9">
                        <ul id="treeDemo" class="ztree"></ul>
                    </div>
                </div>
                <input type="hidden" id="menuIds" name="menuIds" value="" lay-verify="menuIds">
                <div class="am-form-group">
                    <div class="am-u-sm-9 am-u-sm-push-3">
                        <button lay-submit lay-filter="roleForm"
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
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            onCheck: nodesCheck
        }

    };

    function nodesCheck(event, treeId, treeNode) {
        var menuIds = "";
        var nodes = zTreeObj.getCheckedNodes(true);
        if (nodes != null) {
            for (var i = 0, len = nodes.length; i < len; i++) {
                menuIds += nodes[i].id + ","
            }

        }
        if (menuIds != "") {
            $("#menuIds").val(menuIds.substr(0, menuIds.length - 1));
        }
    }
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var menus = eval('${menus}');
    var zNodes = getZNodes();
    function getZNodes() {
        var nodejson = "";
        for (var i = 0, len = menus.length; i < len; i++) {
            nodejson += "{id:'" + menus[i].menuId + "',pId:'" + menus[i].menuPid + "',name:'" + menus[i].menuName + "'},";
        }
        nodejson = nodejson.substr(0, nodejson.length - 1);
        return eval("[" + nodejson + "]");
    }

    $(document).ready(function () {
        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });

    form.verify({
        name: function (value, item) {//value:表单值，item:表单dom对象
            if (value == null || value.trim().length <= 0) {
                return "角色名称必须输入的哦";
            }
        },
        menuIds: function (value, item) {
            if (value == null || value.trim().length <= 0) {
                return "功能权限必须选择的哦";
            }
        }
    });

    //监听submiit提交事件，但真正的提交工作交给ajax处理，不是由form的action处理
    form.on('submit(roleForm)', function (data) {
        layer.closeAll();
        $.ajax({
            url: data.form.action,
            type: 'post',
            data: $("#roleForm").serialize(),
            dataType: 'json',
            success: function (result) {
                layer.msg("保存成功", {icon: 6});
                freshen();
            }
        });
        return false;
    });


</script>