
$(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {

		update();
	}
});


function update() {
	var backup = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/admin/sys/backup/update",
		data : backup, // 你的formid
		async : false,
		error : function(request) {
			alert("操作失败。若重复操作失败，请联系管理员。");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg(r.msg);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(r.msg);
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