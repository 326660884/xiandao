<template>
	<ve-pie class="charts-container"
					:legend-visible="false"
					:data="chartData"
					:colors="colors"
					height="300px"
					:settings="chartSettings"></ve-pie>
</template>

<script>
export default {
	data() {
		this.colors = ['#FFFFFF', '#2f4554', '#61a0a8',
			'#d48265', '#91c7ae', '#749f83',
			'#ca8622', '#bda29a']
		this.chartSettings = {
			// roseType: 'radius',
			// itemStyle: {
			// 	color: ['#293B54', '#00081B']
			// }
		}
		return {
			chartData: {
				columns: ['日期', '访问用户'],
				rows: [
					{ '日期': '1/1', '访问用户': 1393 },
					{ '日期': '1/2', '访问用户': 3530 },
					{ '日期': '1/3', '访问用户': 2923 },
					{ '日期': '1/4', '访问用户': 1723 },
					{ '日期': '1/5', '访问用户': 3792 },
					{ '日期': '1/6', '访问用户': 4593 }
				]
			}
		}
	}
}
</script>

<style lang="stylus" scoped>
.charts-container {
	width: 300px;
	height: 200px;
	background: url('~@/assets/images/panel.png') center center no-repeat;
	background-size: 100% 100%;
	margin: 5px 2px;
	// background: coral;
}
</style>