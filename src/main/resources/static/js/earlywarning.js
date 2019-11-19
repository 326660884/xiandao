
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
            elem: '#earlyWarningTab',
            url: '../loophole/list',
            limit: 10,
            page: true,
            cols: [[
                {type: 'checkbox'},
                {field: 'createtime', title: '事件时间'},
                {field: 'secuname', title: '事件名称',width: 320},
                {field: 'bugtext', title: '漏洞简述',width: 200},
                {field: 'frequency', title: '异常次数'},
                {field: 'level', title: '严重等级'},
                {field: 'from', title: '来源'},
                {field: 'statusCode', title: '状态', templet: '#statusTpl', align: 'center'},
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
                layui.sessionData('loophole',{key:'edit' ,value:obj.data});
                layer.open({
                    title: '通知',
                    type: 2,
                    shade: false,
                    maxmin: true,
                    shade: 0.5,
                    area: ['50%', '90%'],
                    content: 'earlywarning-edit.html',
                    zIndex: layer.zIndex,
                    end: function () {
                        $(".layui-laypage-btn")[0].click();
                    }
                });
            } else if (layEvent === 'del') {
                layer.confirm("您确定移除这条漏洞信息吗？", {skin: 'layui-layer-lan', icon: 2, title: '提示', anim: 6}, function () {
                    var param = {_method:"delete"}
                    $.ajax({
                            url:'../loophole/'+data.secuid,
                            type:"delete",
                            timeout:2000,
                            data:param,
                            success:function(data){
                                var msg ;
                                if(data.code == 0){
                                    msg = '通知成功！';
                                }else{
                                    msg = '通知失败！';
                                }
                                layer.msg(msg, {icon: 6, time: 1000, anim: 4}, function () {
                                            parent.layer.close(parent.layer.getFrameIndex(window.name));
                                          });
                            }
                            });

                });
            } else if (layEvent === 'test') {
                            layer.confirm("这条漏洞信息已被解决？", {skin: 'layui-layer-lan', icon: 2, title: '提示', anim: 6}, function () {
                                data.updatetime = new Date();
                                var params = JSON.stringify(data);
                                $.ajax({
                                        url:'../loophole',
                                        type:"PUT",
                                        timeout:2000,
                                        contentType: 'application/json; charset=UTF-8',
                                        data:params,
                                        success:function(data){
                                            console.log('test ',data)
                                            var msg ;
                                            if(data.code == 0){
                                                msg = '通知成功！';
                                            }else{
                                                msg = '通知失败！';
                                            }
                                            layer.msg(msg, {icon: 6, time: 1000, anim: 4}, function () {
                                                        parent.layer.close(parent.layer.getFrameIndex(window.name));
                                                      });
                                        }
                                        });

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