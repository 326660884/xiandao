<template>
	<div class="home">
		<div>
			<el-row>
				<div class="header">
					<h1 class="title">先导态势分析系统</h1>
					<div class="user-info">
						<a class="login-out"
							 href="">
							<i></i>退出
						</a>
					</div>
					<ul>
						<li class="header-title"
								:class="activeClass == index ? 'active':''"
								v-for="(item,index) in routeList"
								:key="index"
								@click="routeJump(index,item.path)">
							<span type="text">{{item.name}}</span>
						</li>
						<!-- <li class="header-title"
							@click="routeJump">
						<span type="text">昨日运行态势分析</span>
					</li>
					<li class="header-title"
							@click="routeJump">
						<span type="text">安全指数</span>
					</li>
					<li class="header-title"
							@click="routeJump">
						<span type="text">态势感知</span>
					</li> -->
					</ul>
				</div>
			</el-row>

			<div class="warp">
				<div class="left-container">
					<h2 class="title">安全指数</h2>
					<div class="safety-index">
						<span>{{safetyIndex}} </span>
					</div>
					<!-- <ve-ring :colors="colors"
									 :legend-visible="false"
									 height="300px"
									 :data="yesterday"></ve-ring> -->
					<!-- <ve-liquidfill :settings="chartSettings"
												 height="350px"
												 :data="chartData"></ve-liquidfill> -->
					<h2 class="title">昨日服务器被攻击统计</h2>
					<ve-pie :colors="colors"
									:legend-visible="false"
									:data="attacked"></ve-pie>

				</div>
				<div class="middle-container">
					<Map class="mapbox"
							 :mapInfoJson="mapInfoJson"
							 @openDialog="openDialog"></Map>
				</div>
				<div class="right-container">
					<h2 class="title">攻击类型分析</h2>
					<ve-radar :legend-visible="false"
										height="300px"
										style="top:70px"
										:colors="colors"
										:data="a_type"></ve-radar>
					<h2 class="title">安全事件</h2>
					<ve-bar :legend-visible="false"
									:colors="colors"
									style="top:100px"
									height="300px"
									:grid="grid"
									:data="fourthChartData"></ve-bar>
				</div>
			</div>
		</div>
		<el-dialog :visible.sync="centerDialogVisible"
							 class="dialog"
							 width="50%"
							 center>
			<layerMode></layerMode>
		</el-dialog>
	</div>
</template>

<script>
import { getList } from '@/api/map'
import theme from '@/assets/json/halloween.project.json'
import chalktheme from '@/assets/json/chalk.project.json'
import waldenTheme from '@/assets/json/walden.project.json'
import Map from '@/components/map'
import layerMode from '@/components/layerMode'

export default {
	name: 'home',
	components: {
		Map,
		layerMode
	},

	data() {
		this.colors = ['#2f4554', '#325299',
			'#1A93F8', '#3E95CB']
		this.xAxis = {
			axisLine: {
				show: false
			}
		}
		this.theme = chalktheme.theme
		this.chartSettings = {
			seriesMap: {
				'安全指数': {
					label: {
						formatter(options) {
							const {
								seriesName,
								value
							} = options
							return `${value * 100}`
						},
					}
				}
			}
			// stack: { '用户': ['访问用户', '下单用户'] },
			// area: true,
		}
		this.grid = {
			show: true,
			top: 10,
			bottom: 10,
			borderWidth: 0,
			// backgroundColor: '#ccc',
			borderColor: 'rgba(0, 0, 0, 0.1)'
		}
		return {
			activeClass: 0,
			routeList: [{
				name: '监控系统',
				path: ''
			}, {
				name: '昨日运行态势分析',
				path: ''
			}, {
				name: '安全指数',
				path: ''
			}, {
				name: '态势感知',
				path: ''
			},
			],
			safetyIndex: 60,
			mapInfoJson: {},
			centerDialogVisible: false,
			chartData: {
				columns: ['city', 'percent'],
				rows: [{
					city: '安全指数',
					percent: .6
				}]
			},
			//昨天情况
			yesterday: {
				columns: ['解析状态', '次数', '比例'],
				rows: [
					{ '解析状态': '成功', '次数': '85460', '比例': '85.85%' },
					{ '解析状态': '失败', '次数': '171', '比例': '0.17%' },
					{ '解析状态': '拒接', '次数': '14560', '比例': '14.33%' }
				]
			},
			//被攻击
			attacked: {
				columns: ['被攻击目标', '次数'],
				rows: [
					{ '被攻击目标': '天枢服务器群', '次数': '85460' },
					{ '被攻击目标': '天璇服务器群', '次数': '171' },
					{ '被攻击目标': '天玑服务器群', '次数': '4560' },
					{ '被攻击目标': '天权服务器群', '次数': '25460' },
					{ '被攻击目标': '玉衡服务器群', '次数': '3171' },
					{ '被攻击目标': '开阳服务器群', '次数': '60' },
					{ '被攻击目标': '摇光服务器群', '次数': '50' }
				]
			},
			//攻击type
			a_type: {
				columns: ['ip', 'web协议', 'DDOS攻击', 'ARP攻击', '洪水攻击', '其他'],
				rows: [
					{ 'ip': '天枢服务器群', 'web协议': '25750', 'DDOS攻击': '2550', 'ARP攻击': '2550', '洪水攻击': '15750', '其他': '100' },
					{ 'ip': '天璇服务器群', 'web协议': '45030', 'DDOS攻击': '0', 'ARP攻击': '0', '洪水攻击': '0', '其他': '121' },
					{ 'ip': '天权服务器群', 'web协议': '2102', 'DDOS攻击': '30054', 'ARP攻击': '4025', '洪水攻击': '29510', '其他': '150' },
					{ 'ip': '摇光服务器群', 'web协议': '120', 'DDOS攻击': '18044', 'ARP攻击': '501', '洪水攻击': '24750', '其他': '66' }
				]
			},
			// 第四个图表数据，没想好名字
			fourthChartData: {
				columns: ['name', '已防护', '已屏蔽', '已忽略'],
				rows: [
					{ 'name': '天枢服务器群', '已防护': '20100', '已屏蔽': '2750', '已忽略': '2550' },
					{ 'name': '天璇服务器群', '已防护': '20100', '已屏蔽': '2750', '已忽略': '2550' },
					{ 'name': '天权服务器群', '已防护': '1905', '已屏蔽': '7121', '已忽略': '8135' },
					{ 'name': '摇光服务器群', '已防护': '13156', '已屏蔽': '2102', '已忽略': '5468' },
					{ 'name': '开阳服务器群', '已防护': '15671', '已屏蔽': '9501', '已忽略': '18800' },
				]
			}
		}
	},
	methods: {
		openDialog(marker) {
			console.log(marker)
			this.centerDialogVisible = true
		},
		routeJump(index, path) {
			// this.$router.push({
			// 	path: '/about',
			// })
			this.activeClass = index
			let href = window.location.href
			window.open(href.replace('#/', '') + 'xd/')
		},
		requastTestList() {
			getList().then(res => {
				this.mapInfoJson = res
			})
		}
	},
	created() {
		this.requastTestList()
	},
	mounted() {

	}
}
</script>

<style lang="stylus" scoped>
.home {
	// min-width :1500px;
	width: 100vw;
	height: 100vh;
	background: url('~@/assets/images/background2.png') center center no-repeat;
	background-size: 100% 100%;

	.header {
		.user-info {
			display: inline-block;
			float: right;
			// margin-right: 40px;
			height: 60px;
			text-align: center;
			line-height: 60px;

			.login-out {
				display: block;
				width: 60px;
				height: 30px;
				float: left;
				color: #fff;
				font-size: 14px;
				line-height: 30px;
				margin-top: 15px;

				i {
					display: inline-block;
					width: 24px;
					height: 24px;
					background: url('~@/assets/images/out.png') no-repeat center center;
					background-size: 100% 100%;
					vertical-align: top;
					margin: 3px 6px 0 0;
				}
			}
		}

		.title {
			display: inline-block;
			float: right;
			width: 300px;
			position: relative;
			// margin-right: 40px;
			height: 60px;
			text-align: center;
			line-height: 60px;
			font-size: 20px;
			color: rgb(6, 200, 249);
		}

		ul {
			.active {
				/* background: #eee; */
				background: url('~@/assets/images/button.png') center center no-repeat;
			}

			li {
				background-size: 100% 100%;
				float: left;
				position: relative;
				display: inline-block;
				width: 200px;
				height: 50px;
				font-size: 18px;
				line-height: 50px;
				text-align: center;
				left: 0px;
				top: 0px;
				color: white;
				cursor: pointer;
				z-index: 1000;

				&:hover {
					background: url('~@/assets/images/button.png') center center no-repeat;
				}
			}
		}
	}

	.warp {
		min-width: 1500px;
		overflow-x: auto;
		height: 90vh;

		.left-container {
			float: left;
			height: 80vh;
			width: 300px;
			display: flex;
			flex-direction: column;
			margin-left: 50px;

			.title {
				position: relative;
				color: white;
				font-size: 23px;
				text-align: center;
				top: 70px;
			}

			.safety-index {
				width: 300px;
				height: 300px;
				position: relative;
				text-align: center;
				line-height: 300px;
				background: url('~@/assets/images/msg-bg-no2.png') no-repeat center center;

				span {
					display: block;
					color: white;
					background: url('~@/assets/images/yibiaopan.png') no-repeat center center;
				}

				&:hover {
					transform: scale(1.1);
				}
			}
		}

		.middle-container {
			float: left;
			overflow: hidden;
			margin-left: 50px;
			margin-top: 8px;
			// background: url('~@/assets/images/panel.png') center center no-repeat;
			background-size: 100% 100%;
			position: relative;
			width: 1000px;
			height: 800px;
		}

		.right-container {
			float: left;
			margin-left: 120px;
			width: 300px;
			display: flex;
			flex-direction: column;
			height: 85vh;

			.title {
				position: relative;
				color: white;
				font-size: 23px;
				text-align: center;
				top: 70px;
			}

			// margin-left: 1800px;
			.pie {
				top: -50px;
			}
		}
	}

	.dialog {
		.dialog-container {
			color: white;
		}
	}
}
</style>
