<template>
	<div class="map-container">
		<div class="map"
				 ref="basicMapbox"></div>
	</div>
</template>

<script>
import mapInfoJson from '@/assets/json/mapInfo'
import mapboxgl from 'mapbox-gl'
import json from '@/assets/json/bugStyle'
export default {
	data() {
		return {
			mapboxglToken: 'pk.eyJ1IjoiYW5kcmVhbiIsImEiOiJjaW5qenVpMXAweHJkdHRtM3FtaHl1enltIn0.nzAYEO-QbRgwKCrf6kOf2Q',
		}
	},
	computed: {
	},
	methods: {
		initMap() {
			mapboxgl.accessToken = this.mapboxglToken
			this.map = new mapboxgl.Map({
				container: this.$refs.basicMapbox, // container id
				style: json, //stylesheet location
				center: [104.6573, 36.752379], // starting position
				zoom: 3.7, // starting zoom0
				minZoom: 2.5,
				maxZoom: 18,
				attributionControl: false,
				trackResize: true
			})
		},
		getInfo() {
			let _this = this
			var points = mapInfoJson.data.mapSearchResult
			var features = []
			for (var i = 0; i < points.length; i++) {
				var feature = {
					type: 'Feature',
					geometry: {
						type: 'Point',
						coordinates: []
					},
					properties: {
						showFlag: 0
					}
				}
				feature.geometry.coordinates[0] = points[i].longitude
				feature.geometry.coordinates[1] = points[i].latitude
				feature.properties.name = points[i].orgName
				features[features.length] = feature
			}
			// var geoJson = {
			// 	type: 'FeatureCollection',
			// 	features: features
			// }
			features.forEach(function (marker) {
				// create a DOM element for the marker
				var el = document.createElement('div')
				el.className = 'marker'
				el.style.backgroundColor = 'red'
				el.style.color = 'red'
				el.style.width = 10 + 'px'
				el.style.height = 10 + 'px'

				el.addEventListener('mouseover', function () {
					// window.alert(marker.properties.showFlag)
					console.log('mouseover')
				})
				el.addEventListener('click', function () {
					// _this.centerDialogVisible = true
					_this.$emit('openDialog', marker)
				})
				el.addEventListener('mouseout', function () {
					// window.alert(marker.properties.showFlag)
					console.log('mouseout')
				})
				// add marker to map
				if (marker.geometry.coordinates[0]) {
					new mapboxgl.Marker(el)
						.setLngLat(marker.geometry.coordinates)
						.addTo(_this.map)
				}
			})
		}
	},

	mounted() {
		console.log(mapInfoJson)
		this.initMap()
		//双击放大
		// map.on('dblclick', function (e) {
		// 	var currentZoom = map.getZoom()
		// 	currentZoom = 10
		// 	map.setZoom(currentZoom)
		// 	map.setCenter([e.lngLat.lng, e.lngLat.lat])
		// })
		let _this = this
		this.map.on('load', function () {
			_this.getInfo()
			// var sw = new mapboxgl.LngLat(67.407299999999935, 4.481564231482352)
			// var ne = new mapboxgl.LngLat(149.50729999999996, 60.70630856733828)
			// var bounds = new mapboxgl.LngLatBounds(sw, ne)
			// $('article .loader').fadeOut(800, function () {
			// 	$(this).remove()
			// })
			// addPoint()
			// addPointRight()
		})
	}
}
</script>

<style lang="stylus" scoped>
.map-container {
	// top: 100px;
	// left: 400px;
	.map {
		// width: 1000px;
		height: 900px;
	}
}
</style>