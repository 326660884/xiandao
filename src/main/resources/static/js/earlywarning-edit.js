layui.use(['element', 'form', 'jquery', 'laydate'], function () {
        var element = layui.element;
        var table = layui.table;
        var form = layui.form;
        var $ = layui.jquery;
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday',
            type: "datetime"
        });
        //验证规则
        form.verify({
            birthdayVerify: [/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))(\s(([01]\d{1})|(2[0123])):([0-5]\d):([0-5]\d))?$/, '日期格式不正确']
        });

        form.on('submit(edit)', function (data) {
            var tmp = layui.sessionData('loophole')

            data.field.createdate = new Date();
            data.field.sid = tmp['edit'].secuid
             console.log('编辑', data.field)
            $.ajax({
                    url:'../loophole',
                    type:"POST",
                    timeout:2000,
                    data:data.field,
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
            return false;
        });
    })