<template>
  <div class="all">
      <div class="title">
         <h1>Harvest Information</h1>
      </div>
      <div class ="menu">
        <side-bar-nav />
      </div>
      <div class ="upload">
        <harvest-file />
      </div>
      <div class="display">
          <harvests />
      </div>
  </div>
</template>

<script>
import Harvests from '../components/Harvests'
import HarvestFile from '../components/HarvestFile'
import AllHarvests from '../components/AllHarvests.vue'
import SideBarNav from '../components/SideBarNav'

export default {
    name: "harvestview",
    components: {
        Harvests,
        AllHarvests,
        SideBarNav,
        HarvestFile
    }
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");

h1 {
    font-family: 'Bungee';
    font-size: 60px;
}

.all {
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-areas: 
    "menu title ."
    ". upload ."
    ". display ."
    ;
}

.title {
    grid-area: title;
    font-family: 'Bungee';
    font-size: 100px;
    align-content: center;
}

.menu {
    grid-area: menu;
}

.upload {
    grid-area: upload;
}

.display {
    grid-area: display;
}
</style>