
layui.use(['element', 'table', 'form', 'jquery', 'laydate','util'], function () {
        var element = layui.element;
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;
        var laydate = layui.laydate;
        var util = layui.util

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
                {field: 'createtime', title: '事件时间',width: 185,templet: function(d){
                    return util.toDateString(d.createtime,'yyyy年MM月dd日 HH:mm')
                  }},
                {field: 'secuname', title: '事件名称',width: 320},
                {field: 'remark', title: '简述'},
                {field: 'frequency', title: '异常次数'},
                {field: 'level', title: '等级',templet: function(d){
                    var str ;
                    if(d.frequency > 5){
                        str = '<span style="color:#FF5722;">高风险</span>'
                    }else if( d.frequency > 1){
                        str = '<span style="color:#FFB800;">中风险</span>'
                    }else{
                         str = '<span style="color:#2F4056;">低风险</span>'
                    }
                    return str
                 }},
                {field: 'source', title: '来源'},
                {field: 'ip', title: '  IP地址'},
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
                //保存对象，弹出框传值
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
                                    table.reload('earlyWarningTab',{})
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
                                            var msg ;
                                            if(data.code == 0){
                                                msg = '通知成功！';
                                                table.reload('earlyWarningTab',{})
                                            }else{
                                                msg = '通知失败！';
                                            }
                                            layer.msg(msg, {icon: 6, time: 1000, anim: 4}, function () {
                                                        parent.layer.close(parent.layer.getFrameIndex(window.name));
                                                      });

                                        }
                                        });

                            });
            }else if (layEvent === 'selectOne') {

                    layer.open({
                                title: '在线查看报告',
                                type: 2,
                                shade: false,
                                maxmin: true,
                                shade: 0.5,
                                area: ['45%', '60%'],
                                content: '../loophole/report/'+data.secuid,
                                zIndex: layer.zIndex,
                                end: function () {

                                }
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