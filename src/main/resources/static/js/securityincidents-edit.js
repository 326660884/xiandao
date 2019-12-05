layui.use(['element', 'form', 'jquery', 'laydate','layer'], function () {
    var element = layui.element;
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var laydate = layui.laydate;
    var layer = layui.layer;

    form.verify({
        birthdayVerify: [/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))(\s(([01]\d{1})|(2[0123])):([0-5]\d):([0-5]\d))?$/, '日期格式不正确']
    });


    $("#noticeUnit").blur(function () {
        var value = $(this).val();
        $.ajax({
            url: "http://localhost:8080/xd/tovalidateUser",
            data: {notice : value},
            type:"post",
            dataType:"JSON",
            success: function (res) {
                if(res.msg === "nok"){
                    layer.alert("通知对象不存在");

                    $("#submitbutton").attr("class","layui-btn layui-btn-disabled");
                }else{
                    $("#submitbutton").attr("class","layui-btn");
                }
            }
        });
    });

    form.on('submit(modify)', function (data) {
        //console.log(data.field);
        $.ajax({
            url: "http://localhost:8080/xd/notice",
            data: data.field,
            success: function(data){
                layer.msg("编辑成功！", {icon: 6, time: 1000, anim: 4}, function () {
                    parent.layer.close(parent.layer.getFrameIndex(window.name));
                });
            }
        });
        return false;
    });
});