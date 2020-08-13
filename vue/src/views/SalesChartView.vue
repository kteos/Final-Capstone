<template>
  <div class="all">
      <h1>Crop Sales</h1>
      <side-bar-nav />
      <random-chart />
  </div>
</template>

<script>
import RandomChart from '@/components/RandomChart'
import SideBarNav from '@/components/SideBarNav'

export default {
    name: "saleschart",
    components: {
        RandomChart,
        SideBarNav
    }

}
</script>

<style>

</style>