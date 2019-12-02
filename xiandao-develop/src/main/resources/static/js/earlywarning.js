layui.use(['element', 'table', 'form', 'jquery', 'laydate'], function () {
        var element = layui.element;
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;
        var laydate = layui.laydate;

        laydate.render({
            elem: '#startTime',
            type: "datetime"
        });

        laydate.render({
            elem: '#endTime',
            type: "datetime"
        });

        table.render({
            elem: '#tableId',
            url: '../data/securityincidents.json',
            limit: 10,
            page: true,
            cols: [[
                {type: 'checkbox'},
                {field: 'createTime', title: '事件时间'},
                {field: 'bugname', title: '事件名称'},
                {field: 'bugtext', title: '漏洞简述',width: 200},
                {field: 'num', title: '异常次数'},
                {field: 'level', title: '严重等级'},
                {field: 'from', title: '来源'},
                {field: 'status', title: '状态', templet: '#statusTpl', align: 'center'},
                {title: '操作', width: 200, templet: '#operationTpl', align: 'center'}
            ]],
            done: function (res, curr, count) {
                $("#countNum").text(count);
            }
        });

        form.on('submit(search)', function () {
            layer.msg('正在查询，请稍后...');
            return false;
        });

        table.on('tool(tableFilter)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'edit') {
                layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: false,
                    maxmin: true,
                    shade: 0.5,
                    area: ['90%', '90%'],
                    content: 'user-edit.html',
                    zIndex: layer.zIndex,
                    end: function () {
                        $(".layui-laypage-btn")[0].click();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm("确定要删除吗？", {skin: 'layui-layer-lan', icon: 2, title: '提示', anim: 6}, function () {
                    layer.msg("操作成功！", {icon: 1, time: 1000});
                });
            }
        });

        $("#batchEnabled").click(function () {
            layer.confirm("确定要批量启用吗？", {skin: 'layui-layer-lan', icon: 3, title: '提示', anim: 1}, function () {
                var checkStatus = table.checkStatus('tableId');
                var rows = checkStatus.data.length;
                if (rows > 0) {
                    var idsStr = "";
                    for (var i = 0; i < checkStatus.data.length; i++) {
                        idsStr += checkStatus.data[i].id + ',';
                    }
                    console.log("选择的id-->" + idsStr);
                    layer.msg("操作成功！", {icon: 1, time: 1000}, function () {
                        $(".layui-laypage-btn")[0].click();
                    });
                } else {
                    layer.msg('未选择有效数据', {
                        offset: 't',
                        anim: 6
                    });
                }
            });
        })
    })