<template>
<div>
	<h1>Sales Chart</h1>
  <div class="small">
    <line-chart v-if="loaded" :chart-data="datacollection" :options="options"></line-chart>
  </div>
</div>
</template>

<script>
  import LineChart from '@/components/LineChart.js'
  import SaleService from '@/services/SaleService'

  export default {
    components: {
      LineChart
    },
    data () {
      return {
		sales: [],
		products: [],
		amount: [],
		loaded: false,
        datacollection: {
				labels: [],
				datasets: [
					{
						label: 'Data One',
						backgroundColor: '#f87979',
						pointBackgroundColor: 'white',
						borderWidth: 1,
						pointBorderColor: '#249EBF',
						data: []
                    }
                ]
        },
        options: {
				scales: {
					yAxes: [{
						ticks: {
							beginAtZero: true
						},
						gridLines: {
							display: true
						}
					}],
					xAxes: [{
						ticks: {
							beginAtZero: true
						},
						gridLines: {
							display: false
						}
					}]
				},
				legend: {
					display: false
				},
				tooltips: {
					enabled: true,
					mode: 'single',
					callbacks: {
						label: function(tooltipItems, data) {
							return '$' + tooltipItems.yLabel;
						}
					}
				},
				responsive: true,
				maintainAspectRatio: false,
                height: 200
            }
    }
    },
        methods: {
            getAllSales() {
                SaleService.getAllSales().then(response => {
				this.sales = response.data;
			

				this.sales.forEach(sale => {
					this.products.push(sale.product);
					this.amount.push(sale.amount);
				});

				let data = {
				labels: this.products,
				datasets: [
					{
						label: 'Data One',
						backgroundColor: '#f87979',
						pointBackgroundColor: 'white',
						borderWidth: 1,
						pointBorderColor: '#249EBF',
						data: this.amount
                    }
                ]
        };
				this.datacollection = data;

				this.loaded = true;

				console.log(this.datacollection.datasets.data);

            });
        }
    },
    mounted() {
        this.getAllSales();
    }
  }
</script>

<style>
  .small {
	background-color: white;
	opacity: 0.85;
    max-width: 600px;
    margin:  150px auto;
	border-radius: 25px;
  }
</style>