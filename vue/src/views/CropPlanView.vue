<template>
  <div class="all">
      <div class="title">
         <h1 class="croptitle">Crop Plans</h1>
      </div>

        <side-bar-nav />

      <div class ="upload">
        <p>Enter Crop Plans</p> 
        <p class="use">Choose a .csv file to upload by clicking "Choose a File". The file should contain each Crop Name and the corresponding plant date.</p>
        <all-crops />
      </div>
  </div>
</template>

<script>
import AllCrops from '@/components/AllCrops'
import SideBarNav from '@/components/SideBarNav'

export default {
    name: "cropplanview",
    components: {
        AllCrops,
        SideBarNav
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
    ". title ."
    ". upload ."
    ". display ."
    ;
}

.title {
    grid-area: title;
    font-family: 'Bungee';
}

.croptitle {
    font-size: 60px;
    color: rgb(85, 82, 82);
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