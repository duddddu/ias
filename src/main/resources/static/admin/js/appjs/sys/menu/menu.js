var prefix = "/admin/sys/menu";
$(function() {
    load();
});

var load = function ()  {
    $('#exampleTable')
        .bootstrapTreeTable(
            {
                id: 'id',
                code: 'id',
                parentCode: 'parentId',
                type: "GET", // 请求数据的ajax类型
                url: prefix + '/list', // 请求数据的ajax的url
                ajaxParams: {sort:'sort'}, // 请求数据的ajax的data属性
                expandColumn: '1',// 在哪一列上面显示展开按钮
                striped: true, // 是否各行渐变色
                bordered: true, // 是否显示边框
                expandAll: false, // 是否全部展开
                // toolbar : '#exampleToolbar',
                columns : [
                    {
                        field : 'id', // 列字段名
                        title : '序号' // 列标题
                    },
                    {
                        field : 'name',
                        title : '名称',
                    },
                    {
                        title: '图标',
                        field: 'icon',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            return item.icon == null ? ''
                                : '<i class="' + item.icon
                                + ' fa-lg"></i>';
                        }
                    },
                    {
                        title: '地址',
                        valign: 'center',
                        field: 'url'
                    },
                    {
                        title: '菜单标识',
                        valign: 'center',
                        field: 'perms'
                    },
                    {
                        title: '类型',
                        field: 'type',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            if (item.type === 0) {
                                return '<span class="label label-primary">目录</span>';
                            }
                            if (item.type === 1) {
                                return '<span class="label label-success">菜单</span>';
                            }
                            if (item.type === 2) {
                                return '<span class="label label-warning">按钮</span>';
                            }
                        }
                    },
                    {
                        field : 'sort',
                        title : '排序'
                    },
                    {
                        field : 'display',
                        title : '显示'
                    },
                    {
                        field : 'createTime',
                        title : '创建时间'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        valign: 'center',
                        /*formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d;*/
                        formatter: function (item, index) {
                            var e = '<a class="btn btn-primary btn-sm '
                                + s_edit_h
                                + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + item.id
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var p = '<a class="btn btn-primary btn-sm '
                                + s_add_h
                                + '" href="#" mce_href="#" title="添加下级" onclick="add(\''
                                + item.id
                                + '\')"><i class="fa fa-plus"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '
                                + s_remove_h
                                + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + item.id
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            return e + d + p;
                        }
                    } ]
            });
}
function reLoad() {
    load();
}
function add(pId) {
    // iframe层
    layer.open({
        type : 2,
        title : '添加菜单',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '420px' ],
        content : prefix + '/add/' + pId// iframe的url
    });
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix + "/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code === 0) {
                    layer.msg("删除成功");
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })

}
function edit(id) {
    layer.open({
        type : 2,
        title : '菜单修改',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '420px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function batchRemove() {

    /*var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
    }, function() {
        var ids = new Array();
        $.each(rows, function(i, row) {
            ids[i] = row['id'];
        });
        console.log(ids);
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {});*/
}