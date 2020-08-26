// 切换的第一个页面eacharts 实例化
function domain(Status){
	// 正常
	let normal = echarts.init($('#normal').get(0));
	// 异常
	let abnormal = echarts.init($('#abnormal').get(0));
	// 故障
	let fault = echarts.init($('#fault').get(0));
	overall('/dkhome/overall').then((data)=>{
		let arr = null
		
		arr = (data.serverTotal - data.serverFaultNum) - data.serverWarnNum
		if (normal.id) { let v = new monitor(arr,'#0FF','正常',20);normal.setOption(v.first()) }
		if (abnormal.id) { let v = new monitor(data.serverWarnNum,'#FF0','异常',20);abnormal.setOption(v.first()) }
		if (fault.id) { let v = new monitor(data.serverFaultNum,'#F00','故障',20);fault.setOption(v.first()); }
	});
	// cpu
	let cpu = echarts.init($('#cpu').get(0));
	// 内存使用率
	let Memory = echarts.init($('#Memory').get(0));
	// 硬盘使用率
	let Hard = echarts.init($('#Hard').get(0));
	overall('/dkhome/average').then((data)=>{
		$('.situation_bottom .progress').eq(0).children('.progress_bar').children('span').css('width',data.cpuUse.toFixed(2))
		$('.situation_bottom .progress').eq(0).children('.progress_text').text(data.cpuUse.toFixed(2) + ' %')
		
		$('.situation_bottom .progress').eq(1).children('.progress_bar').children('span').css('width',data.memory.toFixed(2))
		$('.situation_bottom .progress').eq(1).children('.progress_text').text(data.memory.toFixed(2) + ' %')
		
		$('.situation_bottom .progress').eq(2).children('.progress_bar').children('span').css('width',data.diskUse.toFixed(2))
		$('.situation_bottom .progress').eq(2).children('.progress_text').text(data.diskUse.toFixed(2) + ' %')
		
		if (cpu.id) { let v = new monitor(data.cpuUse.toFixed(2),'#0FF','CPU使用率');cpu.setOption(v.first('82%',['50%', '60%'],14,'#0FF'));cpu.resize() }
		if (Memory.id) { let v = new monitor(data.memory.toFixed(2),'#FFA500','内存使用率');Memory.setOption(v.first('82%',['50%', '60%'],14,'#FFA500'));Memory.resize() }
		if (Hard.id) { let v = new monitor(data.diskUse.toFixed(2),'#FF0','硬盘使用率');Hard.setOption(v.first('82%',['50%', '60%'],14,'#FF0'));Hard.resize() }
	});
	// 核心系统告警总数
	let warning = echarts.init($('#warning').get(0));
	overall('/dkhome/wranTopicNum').then((data)=>{
		console.log(data)
		// console.log(data)
		let dataArr = [];
		let arr  = [];
		let sum = 0;
		for(let i in data.data){
			// console.log(data.data[i])
			if(data.data[i].count != 0){
				// console.log(i)
				let obj = {};
				obj.name = data.data[i].topic;
				obj.value = data.data[i].count;
				arr.push(data.data[i].count);
				dataArr.push(obj)
			}
		}
		// console.log(dataArr)
		// console.log(arr)
		arr.forEach(item =>{ sum = sum + item })
		
		// 测试
		// dataArr = [
		// 	{ name:'服务代理解析',value:'2' },
		// 	{ name:'数据被动获取',value:'3' },
		// 	{ name:'数据主动采集',value:'4' }
		// ]
		// dataArr.forEach(item =>{ 
		// 	sum = sum + Number(item.value)
		// })
		
		if (warning.id) { let v = new alarm(sum,dataArr);warning.setOption( v.first() );warning.resize() }
	});
	
	// 网络IO变化曲线图
	let network = echarts.init($('#work').get(0));
	// 磁盘IO变化曲线图
	let myChart = echarts.init($('#disk').get(0));
	overall('/userecordserver/list?page=2&limit=5').then((data)=>{
		let netName = [] 	// 时间
		let netData = each(data.page.list)
		let seriesData = series(data.page.list)
		data.page.list.forEach((i)=>{ netName.push(i.createTime) })
		if (network.id) { let v = new Line(netName,netData);network.setOption(v.first());network.resize() }
		if (myChart.id) { let v = new Line(netName,seriesData);myChart.setOption(v.first());myChart.resize() }
	});
	// 设备类型占比
	let eqment = echarts.init($('#eqment').get(0));
	let eqmentData = [
		{value: 6.8, name: '交换机'},
		{value: 40.82, name: '服务器'},
		{value: 2.72, name: '负载均衡'},
		{value: 6.7, name: '路由器'},
	]
	if (eqment.id) { let v = new equipment(eqmentData);eqment.setOption(v.first());eqment.resize() }
	if(Status){
		normal.resize();
		abnormal.resize();
		fault.resize()
		cpu.resize()
		Memory.resize()
		Hard.resize()
		warning.resize()
		network.resize()
		myChart.resize()
		eqment.resize()
	}
}
// 磁盘IO变化曲线图 拼接数据
function series(list){
	let band = [] 
	let serArr = []  // 磁盘
	let serobj = {} //
	list.forEach((i)=>{ serArr.push(i.diskSpeed) })
	serobj.data = serArr
	serobj.name = '上行'
	band.push(serobj)
	return band
}
// 网络IO变化曲线图 拼接数据
function each(list){
	let band = []   	// 零时存储 网络
	let bandArr = {} // 上行
	let Network = [] // 網絡
	let bandwintarr = [] // 下行
	let Networkdown = {}
	list.forEach((i)=>{ Network.push(i.bandwidth);bandwintarr.push(i.bandwinthDown) })
	bandArr.data = Network
	bandArr.name = '上行'
	Networkdown.data = bandwintarr
	Networkdown.name = '下行'
	band.push(bandArr)
	band.push(Networkdown)
	return band
}
// 切换的第二个页面eacharts 实例化
function system(Status){
	let andata1 = [
		{value: 50, name: '192.168.1.50'},
		{value: 30, name: '192.168.1.30'},
		{value: 35, name: '192.168.1.35'},
		{value: 40, name: '192.168.1.40'},
		{value: 60, name: '192.168.1.60'},
		
		{value: 99, name: '192.168.1.99'},
		{value: 90, name: '192.168.1.90'},
		{value: 80, name: '192.168.1.80'},
		{value: 70, name: '192.168.1.70'},
		{value: 55, name: '192.168.1.55'},
	]
	andata1.sort((a, b) => b.value - a.value);
	let andata = andata1.map((v,k) => v.name )
	// 用户解析请求TOP10
	let analysisMob = echarts.init($('#analysisMob').get(0));
	if (analysisMob.id) { let v = new anal(andata,andata1);analysisMob.setOption(v.first()) }
	
	let fieldDate2 = [
		{value: 50, name: 'www.50.com'},
		{value: 30, name: 'www.30.com'},
		{value: 85, name: 'www.85.com'},
		{value: 40, name: 'www.40.com'},
		{value: 20, name: 'www.20.com'},
		
		{value: 10, name: 'www.10.com'},
		{value: 25, name: 'www.25.com'},
		{value: 35, name: 'www.35.com'},
		{value: 45, name: 'www.45.com'},
		{value: 55, name: 'www.55.com'},
	]
	fieldDate2.sort((a, b) => b.value - a.value);
	let fieldDate1 = fieldDate2.map((v,k) => v.name )
	
	// 域名解析TOP10
	let fieldMob = echarts.init($('#fieldMob').get(0));
	if (fieldMob.id) { let v = new anal(fieldDate1,fieldDate2,true);fieldMob.setOption(v.first('#73DDFF')) }
	
	// 自主根解析查询数量变化曲线图
	let category = ['2019-09-13 15:16:08','2019-09-14 15:16:08','2019-09-15 15:16:08','2019-09-16 15:16:08','2019-09-17 15:16:08'];
	let lineData = [10000,20728,24045,28348,32808];
	let barData = [10000,20728,24045,28348,32808];
	let contentQuery = echarts.init($('#contentQuery').get(0));
	if (contentQuery.id) { let v = new query(category,lineData,barData);contentQuery.setOption(v.first()) }
	// 域名服务能力恢复程度
	let scaleDe = echarts.init($('#scaleDe').get(0));
	if (scaleDe.id) { let v = new scale('0.5','境外域名服务能力恢复程度');scaleDe.setOption(v.first()) }
	let scaleSe = echarts.init($('#scaleSe').get(0));
	if (scaleSe.id) { let v = new scale('0.2','境内域名服务能力恢复程度');scaleSe.setOption(v.first()) }
	
	if(Status){
		analysisMob.resize();
		fieldMob.resize()
		contentQuery.resize()
		scaleDe.resize()
		scaleSe.resize()
	}
}
// 测试
let PathUrl = '/xd'
// 生产
// let PathUrl = 'http://159.226.16.34:9009/xd/'
// 请求接口
function overall(BaseUrl){
	return new Promise(function(resolve, reject) {
		$.ajax({
		  url: `${PathUrl}${BaseUrl}`,
			type: 'get',
		  success:(res)=>resolve(res),
			error:(error) => reject(error)
		})
	});
}

$(function(){
	if($('.subnav .snav').index() == 0){ domain() }
	let systemStatus = false
	$('.subnav .subnav_Nav').each((i,v)=>{
		$(v).click(function(){
			$(this).addClass('snav').siblings().removeClass('snav');
			$('.wrapper .content').each(function(){ $(this).hide() })
			$('.wrapper .content').eq($('.subnav .snav').index()).show()
			if(!systemStatus){if($('.subnav .snav').index() == 1){ system() };  systemStatus = true;  }
		})
	})
	// 当窗口发送改变
	setTimeout(function (){
		window.onresize = function () {
			if($('.subnav .snav').index() == 0) { domain(true) } else { system(true) }
		}
	},200)
});