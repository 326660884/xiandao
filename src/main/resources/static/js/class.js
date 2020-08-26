/**
* 实例化的 eacharts 各种图
*/
class monitor{
	constructor(v,color,text,titlesize) { this.v = v,this.color = color,this.text = text,this.titlesize = titlesize}
	textStyle(v,s,w) { let textStyle = { color: v,fontSize: s,fontFamily:'Lato',foontWeight:w };return textStyle }
	itemStyle(color = 'rgba(251, 200, 79, .2)') { let itemStyle = { color: color }; return itemStyle }
	first(top = '55%',radius = ['80%', '90%'],size= 22,color= '#FFF') {
		let x = 'center'
		if(!this.titlesize){
			this.titlesize = 12
		}
		let title = [
			{ x: x,textStyle:this.textStyle(this.color,this.titlesize,'100'), text: this.text,top:top }, 
			{ x: x,textStyle:this.textStyle(color,size,'600'), text: `${this.v}`,top: 'center' }
		]
		let labelLine =  { normal: { lineStyle: { width: 0 } } }
		let data = [
			{ value: this.v,itemStyle:this.itemStyle(this.color),labelLine:labelLine },
			{ value:100 - this.v,itemStyle:this.itemStyle(),labelLine:labelLine, }
		]
		let series = { type: 'pie', radius:radius, center: ['50%', '50%'],data:data }
		let option = { title: title,series:series };
		return option
	}
	
}

class alarm{
	constructor(text,data) { this.text = text,this.data = data }
	first(){
		let subtextStyle = { fontSize: 12,fontWeight: 'normal',align:"center",color:'#CCCCCC' }
		let textStyle ={ fontSize: 18,fontWeight: 'normal',color: '#00FFFF'}
		let color = ['#80C269', '#00FFFF', '#0090F1', '#FFA800','#4658F6']
		let itemStyle = { normal: { borderWidth: 5, borderColor: '#000' } }
		let title = { text:this.text,x: 'center',y: 'center',textStyle: textStyle,subtextStyle:subtextStyle }
		let labelLine = { normal: {show: true,length: 20,length2: 20,lineStyle: { width: 2 } } }
		let label = { normal: { formatter: '{b}:{c}' } }
		let center = ['50%', '50%']
		let radius = ['50%', '60%']
		let series = { type: 'pie',radius:radius,center:center,color:color,itemStyle:itemStyle,data:this.data,labelLine:labelLine,label:label }
		let option = { title:title,series:series }
		return option
	}
}

class query{
	constructor(category,lineData,barData) { this.category = category,this.lineData = lineData,this.barData = barData }
	first(){
		let axisPointer = { type: 'none',label: { show: true,backgroundColor: '#7B7DDC' } }
		// let tooltip  = { trigger:'axis',backgroundColor:'rgba(255,255,255,0.1)',axisPointer: axisPointer }
		let grid = { left: '5%',right: '5%',top: '10%',bottom: '5%',width:'90%',containLabel: true }
		let xAxis = { data: this.category,axisLine: { lineStyle: { color: '#B4B4B4' } },axisTick: { show:false } }
		let splitLine = { show: false }
		let yAxis =	[ { splitLine: splitLine,axisLine: { lineStyle:{color: '#B4B4B4'} },axisLabel: { formatter:'{value} '}},{ show:false } ]
		let itemStyle = { color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[ {offset: 0, color: '#00FFFF'},{offset: 1, color: '#3EACE5'} ] ) }
		let itemcolor = new echarts.graphic.LinearGradient(0, 0, 0, 1,[ {offset: 0, color: '#4169E1'},{offset: 1, color: '#3EACE5'} ] )
		let itemS = { normal:{ barBorderRadius:5,color: itemcolor } }
		let series = [
			{ type: 'line',smooth: true,showAllSymbol: true,symbol: 'emptyCircle',symbolSize: 8,yAxisIndex: 1,itemStyle:itemStyle,data:this.lineData },
			{ type: 'bar',barWidth: 10,itemStyle: itemS,data: this.barData},
		]
		let tooltip = {
			show: true,
			trigger: 'item',
			axisPointer:{
				type:'none',
				label: { show: true,backgroundColor: '#7B7DDC' }
			},
			formatter:  (params) =>'请求时间：' + params.name + '<br/>' + '  请求次数：' +  params.value
		}
		let option = { tooltip: tooltip,grid: grid,xAxis: xAxis,yAxis: yAxis,series:series };
		return option
	}
}

class equipment{
	constructor(data) { this.data = data }
	first(){
		let color = ['#00FFFF', '#7FFFAA', '#FFFF00', '#FB8989', '#CA89FB']
		let emphasis = { itemStyle: { shadowBlur: 10,shadowOffsetX: 0,shadowColor: 'rgba(0, 0, 0, 0.5)' } }
		let legend = { orient:'vertical',left:'2%',top:'middle',textStyle: { color:color } }
		let series =  { type: 'pie',center: ['50%', '50%'],radius: ['50%', '60%'],data:this.data,emphasis:emphasis,label: { formatter: '{d}%' } }
		let option = { color:color, series:series,legend:legend }
		return option
	}
}

class Line{
	constructor(xAxisName,seriesData = []) { this.xAxisName = xAxisName;this.seriesData = seriesData }
	first(){
		let color = ['#458FE3', '#48C964', '#FFAE37', '#FB8989', '#CA89FB']
		let seriesData = this.seriesData
		let series = seriesData.map((v) => { return { name: v.name,type: 'line',symbolSize: 12,data: v.data } });
		let legend = { bottom: 5,textStyle:{ color:'#00BFFF' } }
		let grid = { left: '5%',right: '5%',top: '10%',bottom: '15%',containLabel: true }
		let xAxis = { axisLine: { onZero: false,lineStyle: { color: '#707070' } },data: this.xAxisName }
		let yAxis = { axisLabel: { textStyle: { color: '#707070', fontSize: 14 } },splitLine: { show: false },boundaryGap: [0, 0.1] }
		let tooltip = { trigger: 'axis' }
		let option = { color:color,legend:legend,grid:grid,xAxis:xAxis,yAxis:yAxis,series:series,tooltip:tooltip };
		return option
	}
}

class field{
	constructor(data,data1,name,name1) { this.data=data;this.data1=data1;this.name=name;this.name1=name1 }
	first(){
		let title = {
			text:this.name,
			subtext:this.name1,
			left:'center',
			top:'5%',
			textStyle:{
				color: '#29EEF3',
				fontSize: 20,
				fontWeight: '100',
			},
			subtextStyle: {
				color:"#FFF",
				lineHeight: 30,
				fontSize: 15
			}
		}
		let tooltip = { trigger: 'item',formatter: '{b} : {c})' }
		let legend = {
			orient:'vertical',
			left:'left',
			data:this.data,
			top:'middle',
			textStyle: {
				color:['#00FFFF', '#7FFFAA', '#FFFF00', '#FB8989', '#CA89FB']
			},
		}
		let emphasis = {itemStyle: { shadowBlur: 10,shadowOffsetX: 0,shadowColor: 'rgba(0, 0, 0, 0.5)' } }
		let series = {
			type:'pie',
			radius:'50%',
			center: ['50%', '50%'],
			data:this.data1,
			emphasis:emphasis,
		}
		let color = ['#37a2da','#9fe6b8','#e7bcf3','#ff9f7f','#32c5e9','#fb7293','#8378ea']
		let option = { color:color,title:title,tooltip:tooltip,legend:legend,series:series }
		return option
	}
}

class anal{
	constructor(data,seriesdata,styleNE) { this.data = data;this.seriesdata = seriesdata;this.styleNE = styleNE }
	first(colorLin = 'rgba(0,77,167,1)'){
		let grid = { top: '20%',right: '5%',left: '5%',bottom: '20%' }
		let axisLine = { lineStyle: { color: 'rgba(255,255,255,0.1)' } }
		let axisLabel= { margin:20,interval:0,rotate:-20,color:'#e2e9ff',align:'center',textStyle:{fontSize:14} }
		let yAxisaxis = { formatter: '{value}',color: '#e2e9ff' }
		let xAxis = {
			type: 'category',
			data:this.data,
			nameLocation:'end',
			axisLine: axisLine,
			axisLabel: axisLabel,
		}
		let yAxis = { axisLabel: yAxisaxis,axisLine: { show: false },splitLine: axisLine }
		
		let color = new echarts.graphic.LinearGradient(0, 0, 0, 1, [{ offset: 0,color: 'rgba(0,244,255,1)' },{ offset: 1,color:colorLin } ], false)
		let normal = { color: color,barBorderRadius: [30, 30, 30, 30],shadowColor: 'rgba(0,160,221,1)',shadowBlur: 4 }
		let series = {
			type: 'bar',
			data: this.seriesdata,
			barWidth: '20px',
			itemStyle: { normal:normal },
			label: {
				normal:{
					show: true,
					lineHeight: 30,
					width: 80,
					height: 30,
					backgroundColor: 'rgba(0,160,221,0.1)',
					borderRadius: 200,
					position: ['-8', '-60'],
					distance: 1,
					formatter: ['    {d|●}',' {a|{c}}     \n','    {b|}'].join(','),
					rich: {
						d: { color: '#3CDDCF' },
						a: { color: '#fff',align: 'center' },
						b: { width: 1,height: 30,borderWidth: 1,borderColor: '#234e6c',align: 'left' },
					}
				}
			}
		}
		let tooltip = {
			show: true,
			trigger: 'item',
			axisPointer:{
				type:'shadow'
			},
			itemWidth:100,
			formatter:  (params) => '请求IP:' + params.name + '<br/>' + '  请求次数: ' +  params.value
		}
		if (this.styleNE){ tooltip = { formatter:  (params) => '请求域名:' + params.name + '<br/>' + '  请求次数: ' +  params.value } }
		let option = { grid:grid,xAxis:xAxis,yAxis:yAxis,series:series,tooltip:tooltip }
		return option
	}
}

class scale{
	constructor(value,title) { this.value = value;this.title = title }
	NameData(color){
		let data = [{ value: 100,itemStyle: { normal: { color:color },emphasis: { color:color } } }]
		return data
	}
	axisLine(width){
		let axisLine = { show: true,lineStyle: { width:width,color: [ [0.12, '#E71A6D'],[0.35, '#F88168'],[0.63, '#FBF76B'],[0.8, '#7AD4DF'],[1, '#70C27E'] ] } }
		return axisLine
	}
	axisTick(style,width,leg){
		let axisTick = { show: true,lineStyle: { color: 'auto',width: width },length:leg }
		if(style){
			axisTick.splitNumber = 10
		}
		return axisTick
	}
	first(){
		let show = { show: false }
		let label = { normal: { show: false,position: 'center' },emphasis:show }
		let labelLine = { normal:{ show:false } }
		let center = ['50%','60%']
		let series = [
			{ tooltip:show,radius:['0%', '7%'],label:label,labelLine:labelLine,data:this.NameData('#072B79') },
			{ tooltip:show,radius:['6%', '8%'],label:label,labelLine:labelLine,data:this.NameData('#24D8E7') }, 
			{
				tooltip:show,
				name: '刻度',
				type: 'gauge',
				radius: '83%',
				z: 1,
				min: 0,
				max: 1,
				splitNumber: 5, //刻度数量
				startAngle: 180,
				endAngle: 0,
				axisLine:this.axisLine(5), //仪表盘轴线
				axisLabel:show, //刻度标签。
				axisTick:this.axisTick(false,2,-15), //刻度样式
				splitLine: { show: true,length: 0,lineStyle: { color: 'auto',width: 2 } }, //分隔线样式
				detail:show,
				pointer:show
			}, 
			{
				name: '本期',
				type: 'gauge',
				radius: '80%',
				min: 0,
				max: 1,
				data: [{ value: this.value }],
				splitNumber: 12, //刻度数量
				startAngle: 180,
				endAngle: 0,
				z: 5,
				axisLine:this.axisLine(0), //仪表盘轴线
				axisLabel: { show: true,color: '#fff',fontSize:20,distance: -70,formatter:(params)=>{ } }, //刻度标签。
				axisTick:this.axisTick(true,2,20), //刻度样式
				splitLine: { show: true,length: 25,lineStyle: { color: 'auto',width: 5 } }, //分隔线样式
				itemStyle:{ normal:{ "color": "#24D8E7" } },
				pointer: { width: 10,length: '80%' },
				detail: { formatter:(params)=> (params*100).toFixed(0) + '%',fontSize: 30,color: "#fff",offsetCenter: ['0%', '-35%'] },
			
		}]
		series.forEach(function(v,i){
			if(i<2) {
				v.type = 'pie';
				v.name = 'wrap';
				v.hoverAnimation = false;
				v.legendHoverLink = false;
				v.z = 5;
			}
			v.center = ['50%','60%']
		})
		let title = { text:this.title,show:true,textStyle:{ color:'#fff'},top:'70%',left:'center' }
		let option = { title:title, series:series }
		return option
	}
}
