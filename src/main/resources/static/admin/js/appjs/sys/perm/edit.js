
$(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {

		update();
	}
});


function update() {
	var perm = $('#signupForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/admin/sys/perm/update",
		data : perm, // 你的formid
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
            permId : {
                required : true
            }
        },
        messages : {
            permId : {
                required : icon + "请输入角色Id"
            }
        },
        rules : {
            menuId : {
                required : true
            }
        },
        messages : {
            menuId : {
                required : icon + "请输入菜单Id"
            }
        }
	});
}