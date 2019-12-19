layui.use(['layer','element', 'table', 'form', 'jquery', 'laydate','util'], function () {
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    var util = layui.util;
    var layer= layui.layer;
    var arrayindex = 0;


    $.post('http://localhost:8080/xd/getbroadcast',
        {
            name: "wanglingyue@cnic.cn",
        },
        function(res){
            var that = this;
            layer.open({
                 type: 1
                ,title: "广播通知"
                ,closeBtn: false
                ,area: '300px;'
                ,shade: 0.8
                ,offset: [ //为了演示，随机坐标
                    Math.random()*($(window).height()-300)
                    ,Math.random()*($(window).width()-390)
                ]
                ,id: 'broadcastNotice'
                ,btnAlign: 'c'
                ,moveType: 1
                ,zIndex: layer.zIndex //重点1
                ,content:'<div class="bro" style="padding: 50px; line-height: 22px;'+
                    'background-color: #393D49;color: #fff;font-weight: 300";>' +
                    '通知人：<input type="text" id="noticePeople"   autocomplete="off" class="layui-input " style="background-color: transparent ;border: 0px;color: #e4e7ed" disabled><br/>'+
                    '通知内容：<input type="text" id="noticeConetent"   autocomplete="off" class="layui-input " style="background-color: transparent ;border: 0px;color: #e4e7ed" disabled><br/>'+
                    '</div>'
                ,btn: ['已读，下一个','全部关闭']
                ,yes: function(){
                     arrayindex++;
                     console.log(arrayindex)
                     $(that).click();
                }
                ,btn2: function(){
                     layer.closeAll();
                }
                ,success: function(layero){
                    var arrays=res.data;
                    console.log(arrayindex)
                    if(arrays.length != 0) {
                        console.log(res.data);
                        var newdiv= layero.find('.bro');

                        newdiv.find('#noticePeople').attr({
                            value: res.data[arrayindex].username,
                            title: res.data[arrayindex].username,
                            placeholder: res.data[arrayindex].username
                        });
                        newdiv.find('#noticeConetent').attr({
                            value: res.data[arrayindex].noticecontent,
                            title: res.data[arrayindex].noticecontent,
                            placeholder: res.data[arrayindex].username
                        });
                        layer.setTop(layero); //重点2
                    }else{
                          layer.closeAll();
                    }
                    }
                    ,error: function () {
                        alert("出现错误");
                        return false;
                    }
            });
        });



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
        url: 'http://localhost:8080/xd/getSecurityincidentsUsePage',
        limit: 10,
        page: true,
        cols: [[
            {type: 'checkbox'},
            {field: 'id' ,title: '事件编号',hide:true},
            {field: 'noticeunit' ,title: '通知单位',hide:true},
            {field: 'noticeemail' ,title: '通知邮件',hide:true},
            {field: 'noticetime',title: '通知时间',hide:true,templet: '#transNoticetime'},
            {field: 'resolvetime',title: '解决时间',hide:true,templet:'#transresolvetime'},
            {field: 'noticemethod' ,title: '通知方法',hide:true},
            {field: 'describeevent' ,title: '描述信息',hide:true},
            {field: 'datetime', title: '事件时间',width:180,templet: function(d){
                return util.toDateString(d.datetime,'yyyy-MM-dd HH:mm')
            }},
            {field: 'eventname', title: '事件名称',width:100},
            {field: 'eventtype', title: '漏洞简述',width: 100},
            {field: 'eventfqcy', title: '异常次数',width:100},
            {field: 'eventlevel', title: '严重等级',width:100},
            {field: 'sipname', title: '来源',width:200},
            {field: 'status', title: '状态', templet: '#statusTpl', align: 'center',width:100},
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
        var  notice_target =  data.noticeunit;
        console.log(notice_target);
        if (layEvent === 'edit') {
            layer.open({
                title: '编辑用户',
                type: 2,
                shade: false,
                maxmin: true,
                shade: 0.5,
                area: ['90%', '90%'],
                content: 'securityincidents-edit.html',
                zIndex: layer.zIndex,
                success: function(layero,index){
                    var myDate = new Date();
                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    if(notice_target == "undefined" || notice_target == null || notice_target == ""){
                        notice_target = "Anonymous"
                    }

                    body.find('#noticeUnit')[0].placeholder= notice_target ;
                    //body.find('#no    ticeUnit')[0].value= notice_target;
                    body.find(".eid")[0].value=data.id;
                    body.find(".eid")[0].title=data.id;
                    body.find(".noticeTime")[0].title = myDate ;
                    body.find(".noticeTime")[0].value=myDate ;
                    body.find(".noticeEmail")[0].value=data.noticeemail;

                    form.render();
                },
                end: function () {
                    $(".layui-laypage-btn")[0].click();
                }
            });
        } else if (layEvent === 'del') {
            layer.confirm("确定要删除吗？",
                {skin: 'layui-layer-lan',
                    icon: 2,
                    title: '提示',
                    anim: 6
                }, function (index) {
                    $.ajax({
                        type: "POST",
                        url: "http://localhost:8080/xd/remove",
                        dataType: "json",
                        data: {
                            id: data.id,
                        },
                        success: function (res) {
                            if (res.code === 1) {
                                layer.msg("操作成功！", {icon: 1, time: 1000}, function () {
                                    //location.reload;
                                    table.reload('tableId',{})
                                })
                            } else {
                                layer.msg("删除失败"  )
                            }
                        },
                        error: function () {
                            alert("出现错误");
                            return false;
                        }
                    });

                },
            );
        }else if(layEvent === 'toresolve'){
            layer.confirm("解决问题？",
                {
                    icon:3,title:'提示'
                },function (index) {
                    $.ajax({
                        type:"POST",
                        url:"http://localhost:8080/xd/toresolve",
                        dataType:"json",
                        data:{
                            id: data.id,
                        },
                        success: function (res) {
                            if (res.code === 1) {
                                layer.msg("操作成功！", {icon: 1, time: 1000}, function () {
                                    //location.reload;
                                    table.reload('tableId',{})
                                })
                            } else {
                                layer.msg("解决失败"  )
                            }
                        },
                        error: function () {
                            alert("出现错误");
                            return false;
                        }
                    });
                })
        }else {
            layer.open({
                title: "在线报告查看",
                type:2,
                shade: false,
                maxmin: true,
                shade: 0.5,
                area: ['90%', '90%'],
                content: 'generateReport.html',
                zIndex: layer.zIndex,

                success: function(layero,index){
                    $.ajax({
                        type:"POST",
                        url:"http://localhost:8080/xd/togenerator",
                        dataType:"json",
                        data:{
                            id: data.id,
                        },
                        success: function (res) {
                            if (res.code === 1) {
                                layer.msg("操作成功！", {icon: 1, time: 1000}, function () {
                                    location.reload;
                                })
                            } else {
                                layer.msg("解决失败"  )
                            }
                        },
                    });

                    var body = layer.getChildFrame('body', index);
                    var iframeWin = window[layero.find('iframe')[0]['name']];
                    if(notice_target == "undefined" || notice_target == null || notice_target == ""){
                        notice_target = "Anonymous";
                    }

                    body.find("#resolveTime")[0].value = data.resolvetime.substring(0,10);
                    body.find("#dealTime")[0].value = data.noticetime.substring(0,10);
                    body.find("#noticeunit")[0].value = notice_target;
                    body.find("#noticeemail")[0].value = data.noticeemail;
                    body.find("#desc")[0].value = data.describeevent;
                    body.find("#discoverTime")[0].value = data.datetime.substring(0,10);
                    body.find("#dispeople")[0].value = data.sipname;
                    body.find("#eventfqcy")[0].value = data.eventfqcy;
                    body.find("#eventtype")[0].value = data.eventtype;
                    form.render();

                },
                end: function () {
                    $(".layui-laypage-btn")[0].click();
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

    $("#batchDisabled").click(function () {
        layer.confirm("确定要批量停用吗？", {skin: 'layui-layer-lan', icon: 3, title: '提示', anim: 2}, function () {
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

    $("#batchDel").click(function () {
        layer.confirm("确定要批量删除吗？", {skin: 'layui-layer-lan', icon: 2, title: '提示', anim: 6}, function () {
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

    $("#addUser").click(function () {
        layer.open({
            title: '添加用户',
            type: 2,
            shade: false,
            maxmin: true,
            shade: 0.5,
            anim: 4,
            area: ['90%', '90%'],
            content: 'user-add.html',
            zIndex: layer.zIndex,
            // skin: 'layui-layer-molv',
            end: function () {
                $(".layui-laypage-btn")[0].click();
            }
        });
    })






})