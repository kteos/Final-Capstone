<template>
  <div>
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