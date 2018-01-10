/**
*	添加Select下拉列表
*	@param SelObj 需要操作的SELECT列表ID
*	@param values 需要添加的值（二维数组[[显示值,本身值]]）
*/
function addOptionforArr(selObjId,values) {
	var SelObj = document.getElementById(selObjId);
	SelObj.options.length=0;
	SelObj.options.add(new Option("请选择",""));
	SelObj.options.add(new Option("请选择",""));
	for(var i=0;i<values.length;i++)
	{
		SelObj.options.add(new Option(values[i][0],(typeof(values[i][1])=="undefined"?values[i][0]:values[i][1])));
	}
}
/**
*	添加Select下拉列表
*	@param SelObj 需要操作的SELECT列表ID
*	@param values 需要添加的值（对象方式[{"NAME":"显示值","ID":"本身值"}...]）
*/
function addOptionforObj(selObjId,values) {
	var SelObj = document.getElementById(selObjId);
	SelObj.options.length=0;
	SelObj.options.add(new Option("请选择",""));
	SelObj.options.add(new Option("请选择",""));
	for(var i=0;i<values.length;i++) {
		var obj = values[i];
		if(typeof(obj["NAME"])!="undefined" && obj["NAME"]!=null && obj["NAME"].length>0)
		SelObj.options.add(new Option(obj["NAME"],(typeof(obj["ID"])=="undefined"?obj["ID"]:obj["ID"])));
	}
}
/**
*	添加Select下拉列表
*	@param SelObj 需要操作的SELECT列表ID
*	@param values 需要添加的值（对象方式[{"NAME":"显示值","NM":"本身值"}...]）
*/
function addOptionforObjNM(selObjId,values) {
	var SelObj = document.getElementById(selObjId);
	SelObj.options.length=0;
	SelObj.options.add(new Option("请选择",""));
	SelObj.options.add(new Option("请选择",""));
	for(var i=0;i<values.length;i++) {
		var obj = values[i];
		if(typeof(obj["NAME"])!="undefined" && obj["NAME"]!=null && obj["NAME"].length>0)
			SelObj.options.add(new Option(obj["NAME"],(typeof(obj["NM"])=="undefined"?obj["NM"]:obj["NM"])));
	}
}
/**
*	匹配Select下拉列表值
*	@param SelObj 需要操作的SELECT列表对象ID
*	@param val 需要匹配的值
*/
function changeSelectOption(selObjId,val) {
	var SelObj = document.getElementById(selObjId);
	if (!SelObj) return;
	var options = SelObj.options;
	if (!options) return;
	for ( var i=0; i<options.length;i++) {
		var cvalue = options[i].value;
		if (cvalue == val) {
			try {
				options[i].selected = true;
				break;
			} catch (e) {alert(e)}
			return;
		}
	}
}
/*
 * 返回系统时间字符串（格式:YYYY-MM-DD）
 */
function newCutrrentDate(){
	var d = new Date();
	var s="";
	s += d.getFullYear() + "-";
	s += d.getMonth()<9?'0'+(d.getMonth() + 1)+"-":(d.getMonth() + 1)+"-";
	s += (d.getDate()+'').length==1?'0'+d.getDate():d.getDate();
	return s;
}

/*
 * 返回系统时间字符串（格式:YYYY-MM-DD H:m:s）
 */
function getCutrrentDate(){
	var d = new Date();
	var s="";
	s += d.getFullYear() + "-";
	s += d.getMonth()<9?'0'+(d.getMonth() + 1)+"-":(d.getMonth() + 1)+"-";
	s += (d.getDate()+'').length==1?'0'+d.getDate():d.getDate();

	s += "  "+d.getHours()+":";       //获取当前小时数(0-23)
	s += d.getMinutes()+":";     //获取当前分钟数(0-59)
	s += d.getSeconds();
	return s;
}
/*
 * 返回指定时间字符串（格式:YYYY年MM月DD日）
 * @param date 需转换的字符串(2008-08-08)
 */
function newDateChina( date ){
	if(date.length<=0) return "";
	var   s=date.split("-");
    var   d=new Date(parseInt(s[0]*1),parseInt(s[1]*1)-1,parseInt(s[2]*1));//直接用 parseInt()转换数据超过8(例如08,09)直接变成0 所以先乘1在转换
	var s="";
	var year = d.getFullYear()+"";
	if(year.length==1) year = "190"+year;
	if(year.length==2) year = "19"+year;
	s += year + "年";
	s += d.getMonth()<9?'0'+(d.getMonth() + 1)+"月":(d.getMonth() + 1)+"月";
	s += (d.getDate()+'').length==1?'0'+d.getDate()+ "日":d.getDate() + "日";
	return s;
}
/**
 * 添加Select下拉列表
 *	@param SelObj 需要操作的SELECT列表ID
 *	@param type 该下拉框在code表中标识类型
 */
function initSelectInCode(selObjId,type){
	$.ajax({
        url: '${ctx}/common/sysCode',
        data:{type:type},
        type: 'post',
        dataType: 'json',
        success: function (data) {
        	addOptionforObj(selObjId,data);
        }
    });
}
//验证字符长度
function checkInputLength(str){
	if(!str.length>0&&str.length<=16){
		return false;
	}
	return true;
}
//验证非法字符
function checkInputCharacter(str){
	var reg=/^[()!@#$%^&*<>?/\|\[\]+=-.,~`]+$/;
	if(reg.test(str)){
		return false;
	}
	return true;
}










