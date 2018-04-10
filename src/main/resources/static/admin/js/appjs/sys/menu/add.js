//var menuTree;
var prefix = "/admin/sys/menu"
$(function() {
	validateRule();
	//打开图标列表
	$("#ico-btn").click(function(){
		layer.open({
			type: 2,
			title: '图标列表',
			content: '/FontIconList.html',
			area: ['480px', '90%'],
			success: function(){
				//
			}
		});
	});
});
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

function save() {

	var perm = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : prefix + "/save",
		data : $('#signupForm').serialize(),
		async : false,
		error : function(request) {
			alert("操作失败。若重复操作失败，请联系管理员。");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引

				parent.layer.close(index);

			} else {
				parent.layer.msg(data.msg);
			}
		}
	});
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			permId : {
				required : true
			}
		},
		messages : {
            name : {
                required : icon + "请输入菜单名"
            },
            type : {
                required : icon + "请选择菜单类型"
            }
        }
	});
}