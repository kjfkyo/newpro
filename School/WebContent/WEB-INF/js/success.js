$(function(){
//	layer.confirm('确定要删除该物资吗?', 
//			{icon: 3, title:'提示'}, function(index){
//		
//	});
});

function tanchuceng(){
		$("#stuForm")[0].reset();
		$("#stuForm").attr("action","insertStudent");
		layer.open({
			type:1,
			title:'注册信息',
			area:['600px','400px'],
			content: $('#formDiv'),
			maxmin:true,
			end:function(){
				 $("#formDiv").css("display", "none");
			}
		});
}

function updateStudent(s_id){
	$("#stuForm")[0].reset();
	$("#stuForm").attr("action","updateStudentById");
	$.ajax({
        url: 'selectStudentById',
        data: {"s_id":s_id},
        type: 'post',
        dataType: 'json',
        success: function (data) {
        	$("#s_id").val(data.s_id);
        	$("#s_name").val(data.s_name);
        	$("#s_age").val(data.s_age);
        	$("#cid").val(data.c_id);
        }
    });
	layer.open({
		type:1,
		title:'修改信息',
		area:['600px','400px'],
		content: $('#formDiv'),
		maxmin:true,
		end:function(){
			 $("#formDiv").css("display", "none");
		}
	});
}