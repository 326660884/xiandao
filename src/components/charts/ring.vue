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
			title:{
				text:'昨天解析比例',
				show:true
			},
			roseType: 'radius',
			// itemStyle: {
			// 	color: ['#293B54', '#00081B']
			// }
		}
		return {
			chartData: {
				columns: ['proportion', 'number'],
				rows: [
					{ 'proportion': '1/1', 'number': 1393 },
					{ 'proportion': '1/2', 'number': 3530 },
					{ 'proportion': '1/3', 'number': 2923 }
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