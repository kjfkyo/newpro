<%--
  User: limiao
  Date: 2017-06-30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript" src="${ctx}/static/plugin/echarts.min.js"></script>
<div class="tpl-content-wrapper">
    <div class="row-content am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                <div class="widget am-cf">
                    <ol class="am-breadcrumb">
                        <li><a href="#" class="am-icon-home">首页</a></li>
                    </ol>

                    <div class="widget-body  am-fr">
                        <div id="tongji" style="height:450px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>


    function getTimeData() {
        var dateData = null;
        $.ajax({
            url: "${ctx}/index/getTime",
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
                dateData = data;
            }
        });
        return eval(dateData);
    }

    function getDataJson() {
        var dataJson = null;
        $.ajax({
            url: "${ctx}/index/getLogData",
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
                dataJson = data;
            }
        });
        return eval(dataJson);
    }

    var t_echarts = echarts.init(document.getElementById("tongji"));
    option = {
        title: {
            text: '近15日系统访问情况统计',
            x: 'center',
            textStyle: {       // 属性lineStyle控制线条样式
                fontWeight: 'bolder',
                color: '#1e90ff',
                shadowBlur: 10
            }
        },
        tooltip: {
            trigger: 'axis'
        },
        grid: {left: '5%', right: '5%'},
        toolbox: {
            show: true,
            feature: {
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            axisLabel: {
                interval: 0,
                rotate: 15,
                textStyle: {       // 属性lineStyle控制线条样式
                    fontWeight: 'bolder',
                    color: '#1e90ff',
                    shadowBlur: 10
                }
            },
            data: getTimeData()
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                interval: 0,
                rotate: 15,
                textStyle: {       // 属性lineStyle控制线条样式
                    fontWeight: 'bolder',
                    color: '#1e90ff',
                    shadowBlur: 10
                }
            },
        },
        series: [
            {
                name: '访问量',
                type: 'line',
                smooth: true,
                symbolSize: 8,
                symbol: 'circle',
                data: getDataJson()
            }
        ]
    };
    t_echarts.setOption(option);
    window.onresize = function () {
        t_echarts.resize();
    }
</script>