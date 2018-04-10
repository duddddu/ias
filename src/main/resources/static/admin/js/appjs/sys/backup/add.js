//var menuTree;

$(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

function save() {

	var backup = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/admin/sys/backup/save",
		data : backup, // 你的formid

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
			backupId : {
				required : true
			}
		},
		messages : {
			backuperId : {
				required : icon + "请输入备份人Id"
			}
		}
	});
}