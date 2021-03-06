"use strict";
var useModel = ["form", "table", "laytpl", "laydate",
  "element", "jquery", "countUp", "echartsData","okUtils"];//需要引入的模块
layui.config({
  base: "../lib/okplugins/"
}).extend({//这里引入的的目录是根据base("/lib/okplugins/")这个目录来指向的
  "mapTest": "../../js/mapTest",
  "echartsData": "../../js/echartsData"
}).use(useModel, function () {
  var $form = layui.form,
    countUp = layui.countUp,
    laydate = layui.laydate,
    element = layui.element,
    table = layui.table,
    $ = layui.jquery,
    okUtils = layui.okUtils,
    laytpl = layui.laytpl;
  /**静态数据**/
  var echartsData = layui.echartsData;
  init();
  console.log('analysis.js')
  function init() {

    /**表格**/
    table.render({
      method: "GET",
      url: "../data/analysis.json",//
      elem: '#oneGroup', //指定原始表格元素选择器（推荐id选择器）

      page: false,
      limit: 10,
      parseData: function (res) {
        res.data.list = []
        for (var i = 0 ;i< 8;i++){
            var o = new Object()
            o.time = okUtils.dateFormat(new Date(),'yyyy-MM-dd hh:mm:ss')
            o.ip = '159.226.172.'+(Math.random() * 255).toFixed()
            o.requsetNum = (Math.random() * 1000).toFixed()+1000
            o.requsetIPNum =(Math.random() * 1000).toFixed()+1000
            o.domainNum =(Math.random() * 1000).toFixed()+1000
            res.data.list.push(o)
        }

        return {
          "code": res.code,
          "count": res.data.count,
          "data": res.data.list //解析数据列表
        }
      },
      cols: [[
        {field: "time", title: "时间"},
        {field: "ip", title: "服务器ip"},
        {field: "requsetNum", title: "请求次数"},
        {field: "requsetIPNum", title: "请求IP个数"},
        {field: "domainNum", title: "解析域名个数"}
      ]], //设置表头
    });
  }
  
});


