$(function(){
	$.ajax({
		url: 'selectStudentAll',
	    type: 'post',
	    dataType: 'json',
	    success: function (data) {
	       var $tab=$("#mytable>tbody");
	       for(var i=0;i<data.length;i++){
	    	   $tab.append("<tr><td>"+data[i].s_id+"</td><td>"+data[i].s_name+"</td><td>"+data[i].s_age+"</td><td>"+data[i].cid.c_name+"</td><td><a href='#'>删除</a></td></tr>");
	       }
	       $("#mytable a").each(function(){
		   		$(this).click(function(){
		   			var $tr=$(this).parent().parent();
		   			var ids=$tr.find("td").eq(0).text();
		   			if(confirm("确定要删除"+$tr.find("td").eq(1).text()+"吗？")){
		   				if(del(ids)){
		   					$tr.remove();
		   					alert("删除成功！");
		   				}else{
		   					alert("删除失败！");
		   				}
		   			}
		   		});
	       });
	    }
	});
	
});

function del(idd){
	var flag=false;
	$.ajax({
		url: 'deleteStudentByIdAjax',
		data:{"s_id":idd},
	    type: 'post',
	    dataType: 'json',
	    async:false,
	    success: function (data) {
	    	if(data==1){
	    		flag=true;
	    	}
	    }
	});
	return flag;
}

