<template>
    <div class="all">
      <div class="title">
         <h1 class="expirtitle">Expiration Information</h1>
      </div>
      <div class ="menu2">
        <side-bar-nav />
      </div>
      <div class ="upload">
        <p>Enter Crop Expiration Information</p> 
        <p class="use">Choose a .csv file to upload by clicking "Choose a File". The file should contain each Crop Name and the corresponding Expiration Time in days.</p>
        <expiration-file />
      </div>
      <div class="display">
          <expirations />
      </div>
  </div>
</template>

<script>
import Expirations from '@/components/Expirations'
import ExpirationFile from '@/components/ExpirationFile'
import SideBarNav from '../components/SideBarNav'

export default {
    name: "expirationview",
    components: {
        Expirations,
        ExpirationFile,
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
    "menu title title"
    ". upload ."
    ". display ."
    ;
}

.title {
    grid-area: title;
    font-family: 'Bungee';
}

.expirtitle {
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