<template>
	<div class="home">
		<div>
			<div class="header">
				<h1 class="title">先导监测</h1>
				<div class="header-title"
						 @click="routeJump">
					<el-button type="text">跳转连接</el-button>
				</div>
			</div>
			<div class="warp">
				<div class="left-container">
					<!-- <span class="title">指数</span> -->
					<chart-liquidfill></chart-liquidfill>
					<ve-pie :colors="colors"
									style="top:-100px"
									:legend-visible="false"
									:data="chartData"></ve-pie>
					<chart-histogram style="top:-200px"></chart-histogram>
					<ve-ring :colors="colors"
									 :legend-visible="false"
									 height="300px"
									 style="top:-350px"
									 :data="chartData"></ve-ring>
					<!--  -->
				</div>
				<div class="middle-container">
					<Map class="mapbox"
							 @openDialog="openDialog"></Map>
				</div>
				<div class="right-container">
					<!-- <span class="title">指数</span> -->
					<!-- <chart-liquidfill></chart-liquidfill> -->
					<ve-radar :legend-visible="false"
										:data="chartData"
										height="250px"
										:colors="colors"></ve-radar>
					<ve-pie :colors="colors"
									class="pie"
									height="300px"
									style="top:-120px"
									:legend-visible="false"
									:data="chartData"></ve-pie>
					<ve-bar :legend-visible="false"
									:colors="colors"
									height="300px"
									style="top:-150px"
									:data="chartData"></ve-bar>
					<ve-bar :legend-visible="false"
									:colors="colors"
									height="300px"
									style="top:-240px"
									:data="chartData"></ve-bar>
				</div>
			</div>

		</div>
		<el-dialog :visible.sync="centerDialogVisible"
							 class="dialog"
							 width="30%"
							 center>
			<div class="dialog-container">
				<ve-line class="charts-container"
								 :colors="colors"
								 :legend-visible="false"
								 :data="chartData"
								 :grid="grid"
								 height="300px"
								 :settings="chartSettings"></ve-line>
			</div>
			<span slot="footer"
						class="dialog-footer">
			</span>
		</el-dialog>
	</div>
</template>

<script>
import theme from '@/assets/json/halloween.project.json'
import chalktheme from '@/assets/json/chalk.project.json'
import waldenTheme from '@/assets/json/walden.project.json'
// @ is an alias to /src
import chartRing from '@/components/charts/ring'
import chartPie from '@/components/charts/pie'
import chartHistogram from '@/components/charts/histogram'
import chartLiquidfill from '@/components/charts/liquidfill'
import chartLine from '@/components/charts/line'
import Map from '@/components/map'

export default {
	name: 'home',
	components: {
		Map,
		chartRing,
		chartPie,
		chartHistogram,
		chartLiquidfill,
		chartLine
	},
	data() {
		this.colors = ['#2f4554', '#325299',
			'#1A93F8', '#3E95CB']
		this.xAxis = {
			axisLine: {
				show: false
			}
		}
		return {
			centerDialogVisible: false,
			chartData: {
				columns: ['日期', '访问用户', '下单用户', '下单率'],
				rows: [
					{ '日期': '1/1', '访问用户': 1393, '下单用户': 1093, '下单率': 0.32 },
					{ '日期': '1/2', '访问用户': 3530, '下单用户': 3230, '下单率': 0.26 },
					{ '日期': '1/3', '访问用户': 2923, '下单用户': 2623, '下单率': 0.76 },
					{ '日期': '1/4', '访问用户': 1723, '下单用户': 1423, '下单率': 0.49 },
					{ '日期': '1/5', '访问用户': 3792, '下单用户': 3492, '下单率': 0.323 },
					{ '日期': '1/6', '访问用户': 4593, '下单用户': 4293, '下单率': 0.78 }
				]
			}
		}
	},
	methods: {
		openDialog() {
			this.centerDialogVisible = true
		},
		routeJump() {
			this.$router.push({
				path: '/about',
			})
		}
	},
	created() {
		this.xAxis = {
			axisLine: {
				show: false
			}
		}
		this.theme = chalktheme.theme
		this.chartSettings = {
			stack: { '用户': ['访问用户', '下单用户'] },
			area: true,
		}
		this.grid = {
			show: true,
			// top: 50,
			// left: 10,
			borderWidth: 0,
			// backgroundColor: '#ccc',
			borderColor: 'rgba(0, 0, 0, 0.1)'
		}
	},
	mounted() {

	}
}
</script>

<style lang="stylus" scoped>
.home {
	.title {
		color: white;
		font-size: 28px;
		text-align: center;
	}

	// min-width :1500px;
	width: 100vw;
	height: 100vh;
	background: url('~@/assets/images/background2.png') center center no-repeat;
	background-size: 100% 100%;

	.header {
		background: url('~@/assets/images/header.png') center center no-repeat;
		color: white;
		text-align: center;
		line-height: 30px;
		font-size: 30px;

		// .title {
		// font-size: 38px;
		// }
		.header-title {
			height: 58px;
			width: 300px;
			background: url('~@/assets/images/button.png') center center no-repeat;
			background-size: 100% 100%;
			position: relative;
			left: 50px;
			top: 50px;
			color: white;
			cursor: pointer;
			z-index: 1000;
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

			// margin-left: 1800px;
			.pie {
				top: -50px;
			}
		}
	}

	.dialog {
		.dialog-container {
			height: 600px;
			color: white;
		}
	}
}
</style>
