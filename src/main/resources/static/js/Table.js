/**
* @timer 定时器 在 100 请求完
* @page {number} 页数
* @Items {array} 请求数据的参数组合.
* @MarAjax() 请求接口
* @roll() 拼接数据
*/

let page = 0
let Items = []
let timer= null

$(function(){
	timer = setInterval(function(){
		page = page + 1
		new Promise(function(resolve, reject) {	
			userecordserver().then((data)=>{ console.log(data) }).catch((error)=>{ clearInterval(timer) });
		});
	},100)
});

function userecordserver(){
	return new Promise(function(resolve, reject) {
		MarAjax(`/userecordserver/list?page=${page}&limit=5&warn=1`).then((data)=>{
			if(data.page.list.length ===  0){
				clearInterval(timer)
				roll(Items)
			}
			if(data.page.list.length !=  0){
				data.page.list.forEach((i)=>{
					if(i.topic == undefined){ i.topic = '' }
					let obj = {
						time:i.createTime,
						server:i.serverName,
						warning:i.warnType,
						system:i.topic
					}
					Items.push(obj)
				})
			}
		}).catch((error)=>{ reject(timer) });
	});
}

function MarAjax(BaseUrl){
	return new Promise(function(resolve, reject) {
		$.ajax({
		  url: `${PathUrl}${BaseUrl}`,
			type: 'get',
		  success:(res)=>resolve(res),
			error:(error) => reject(error)
		})
	});
}

function roll(data){
	let Items = data
	let MyMarhq = '';
	clearInterval(MyMarhq);
	$('.tbl-body tbody').empty();
	$('.tbl-header tbody').empty();
	let str = '';
	$.each(Items,function (i, item) {
		str = `<tr><td>${item.time}</td><td>${item.server}</td><td>${item.system}</td><td>${item.warning}</td></tr>`
		$('.tbl-body tbody').html()
		$('.tbl-header tbody').html()
		$('.tbl-body tbody').append(str);
		$('.tbl-header tbody').append(str);
	});
	if(Items.length > 5){
		$('.tbl-body tbody').html($('.tbl-body tbody').html()+$('.tbl-body tbody').html());
		$('.tbl-body').css('top', '0');
		var tblTop = 0;
		var speedhq = 20; // 数值越大越慢
		var outerHeight = $('.tbl-body tbody').find("tr").outerHeight();
		function Marqueehq(){
			if(tblTop <= -outerHeight*Items.length){
				tblTop = 0;
			} else {
				tblTop -= 1;
			}
			$('.tbl-body').css('top', tblTop+'px');
		}
		MyMarhq = setInterval(Marqueehq,speedhq);
		// 鼠标移上去取消事件
		$(".tbl-header tbody").hover(function (){ clearInterval(MyMarhq) },function (){ clearInterval(MyMarhq);MyMarhq = setInterval(Marqueehq,speedhq) })
	}
}
