<template>
  <div class="all">
      <div class="title">
         <h1 class="harvesttitle">Harvest Information</h1>
      </div>
      <div class ="menu2">
        <side-bar-nav />
      </div>
      <div class ="upload">
        <p>Enter Harvest Information</p> 
        <p class="use">Choose a .csv file to upload by clicking "Choose a File". The file should contain each Crop Name and the corresponding Direct Seed to Harvest Time in days.</p>
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
import SideBarNav from '../components/SideBarNav'

export default {
    name: "harvestview",
    components: {
        Harvests,
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
}

.harvesttitle {
    font-size: 60px;
    color: rgb(85, 82, 82);
}
.menu2 {
    grid-area: menu;
    padding-bottom: 120px;
    padding-left: 50px;
    padding-right: 90px;
    align-content: top;
}

.upload {
    grid-area: upload;
    background-color: white;
    opacity: 0.85;
    border: 1px solid #ccc;
}

.display {
    font-family: Arial, Helvetica, sans-serif;
    color: black;
    grid-area: display;
    background-color: white;   
    opacity: 0.85; 
}

p {
    color: black;
    font-size: 25px;
    font-weight: bold;
}

.use {
    font-size: 18px;
    font-weight: normal;
}

table.container {
    border: 1px solid #ccc;
    border-top-color: white;
}
</style>