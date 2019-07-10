<template>
	<ve-liquidfill class="charts-container"
								 
								 :legend-visible="false"
								 :data="chartData"
								 height="250px"></ve-liquidfill>
</template>

<script>
export default {
	data() {

		return {
			chartData: {
				columns: ['city', 'percent'],
				rows: [{
					city: '上海',
					percent: 0.6
				}]
			}
		}
	}
}
</script>

<style lang="stylus" scoped>
.charts-container {
	width: 300px;
	height: 200px;
	// background: url('~@/assets/images/panel.png') center center no-repeat;
	background-size: 100% 100%;
	margin: 5px 2px;
	// background: coral;
}
</style>