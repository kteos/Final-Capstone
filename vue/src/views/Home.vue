<template>
  <div class="home">
  <div class="header">
    <h1 class="title">Farm Assist</h1>
    </div>
    
      <side-bar-nav />
    <button v-on:click="testEmail">TEST EMAIL HERE</button>
  </div>
</template>

<script>
// import HarvestFile from '@/components/HarvestFile'
// import Harvests from '@/components/Harvests'
// import ExpirationFile from '@/components/ExpirationFile'
// import Expirations from '@/components/Expirations'
// import TransplantFile from '@/components/TransplantFile'
// import Transplants from '@/components/Transplants'
// import HarvestView from '@/views/HarvestView'
// import AllHarvests from '@/components/AllHarvests'
import SideBarNav from '@/components/SideBarNav'
// import SaleInfo from '@/components/SaleInfo'
// import WasteInfo from '@/components/WasteInfo'
// import CropsUpload from '@/components/CropsUpload'
// import AllCrops from '@/components/AllCrops'

import mailchimp from "@mailchimp/mailchimp_marketing";

export default {
  
  name: "home",
  components: {
    // HarvestFile,
    // Harvests,
    // ExpirationFile,
    // Expirations,
    // TransplantFile,
    // Transplants,
    // HarvestView,
    // AllHarvests,
    SideBarNav,
    // WasteInfo,
    // AllCrops
  },
  methods: {
  //   testEmail(){
  //       const response = mailchimp.ping.get().then((response) => {
  //         console.log(response);
  //       });
  // console.log(response);
  //   },
//     testEmail(){
//       var request = require('request');

// var options = {
//     url: 'apikey=3e182a575cd7a44aaf159cca78572ae6-us17',
//     auth: {
//         'user': '`test`',
//         'pass': '${3e182a575cd7a44aaf159cca78572ae6-us17}'
//     },
//     callback(error, response, body) {
//     if (!error && response.statusCode == 200) {
//         console.log(body);
//     }
// }

testEmail(){
  mailchimp.setConfig({
  apiKey: '3e182a575cd7a44aaf159cca78572ae6-us17',
  server: 'us17',
  })
  mailchimp.ping.get().then((response) => {
    console.log(response);
  })
}


  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");

body{
  color: black;
}

.home{
  display: grid;
  
  grid-template-columns: 1fr 3fr 1fr;
  grid-template-areas: 
    ". header ."
  ;
  grid-gap: 10px;
}

.header{
  color: rgb(51, 49, 49);
  grid-area: header;
  display: flex;
  justify-content: space-evenly;
  align-items: top;
  border-radius: 3px;
}

.expiration{
  grid-area: expiration;
  background-color: #efa500;
  border-radius: 3px;
}

.transplants{
  grid-area: transplants;
  background-color: #f40058;
  border-radius: 3px;
}

table > tr:nth-child(even){
    background-color: #7f887f6d;
}

table{
    width: 100%;
    padding: 10px;
    text-align: left;
}

.container th :last-child{
  width: 0%;
}

table tr,
table td,
table th{
    display: flex;
    justify-content: space-between;
    text-align: right;
}

/* .sidenav {
  color: white;
  height: 100%; 
  width: 0;
  position: fixed;
  z-index: 1; 
  top: 0; 
  left: 0;
  background-color: rgb(37, 35, 35); 
  overflow-x: hidden; /* Disable horizontal scroll  
  padding-top: 60px; /* Place content 60px from the top 
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav 
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.menu1 {

    padding-bottom: 120px;
    padding-left: 50px;
    padding-right: 90px;
    align-content: top;
} */

.title {
  font-family: 'Bungee';
  font-size: 60px;
  color: rgb(85, 82, 82);
}

</style>