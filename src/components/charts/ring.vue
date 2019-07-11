<template>
	<ve-ring class="charts-container"
					 :legend-visible="false"
					 :data="chartData"
					 :colors="colors"
					 height="300px"
					 :settings="chartSettings"></ve-ring>
</template>

<script>
export default {
	data() {
		this.colors = ['#FFFFFF', '#2f4554', '#61a0a8',
			'#d48265', '#91c7ae', '#749f83',
			'#ca8622', '#bda29a']

		this.chartSettings = {

			roseType: 'radius',
			// itemStyle: {
			// 	color: ['#293B54', '#00081B']
			// }
		}
		return {
			chartData: {
				columns: ['百分比', '解析次数'],
				rows: [
					{ '百分比': '1/1', '解析成功': 1393 },
					{ '日期': '1/2', '访问用户': 3530 },
					{ '日期': '1/3', '访问用户': 2923 }
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