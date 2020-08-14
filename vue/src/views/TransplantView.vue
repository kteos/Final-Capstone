<template>
    <div class="plant">
      <div class="title">
         <h1 class="transplanttitle">Transplant Information</h1>
      </div>
   
        <side-bar-nav />
    
      <div class ="upload">
        <p>Enter Transplant Information</p> 
        <p class="use">Choose a .csv file to upload by clicking "Choose a File". The file should contain each Crop Name, the corresponding Direct Seed to Transplant Time in days, and Transplant to Harvest Time in days.</p>
        <transplant-file />
      </div>
      <div class="display">
          <transplants />
      </div>
  </div>
</template>

<script>
import Transplants from '@/components/Transplants'
import TransplantFile from '@/components/TransplantFile'
import SideBarNav from '@/components/SideBarNav'


export default {
    name: "transplantview",
    components: {
        Transplants,
        TransplantFile,
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

.plant {
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-areas: 
    "menu title title"
    ". upload ."
    ". display ."
    ;
}

.title {
    grid-area: title;
    font-family: 'Bungee';
}

.transplanttitle {
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

</style>