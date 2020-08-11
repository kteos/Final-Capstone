<template>
  <div class="home">
      <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" v-on:click="closeNav()">&times;</a>
        <a href="/login">Login</a>
        <a href="/logout">Logout</a>
        <a href="/">Home</a>
        <a href="#">Harvest Info</a>
        <a href="#">Crop Plans</a>
        <a href="#">Crop Expiration Info</a>

      </div>
  <button class="menu" v-on:click="openNav()">Menu</button>
  <div class="header">
    <h1 class="title">Farm Assist</h1>
    <span>making your day to day easier</span>
    </div>
    <div  class="harvest">
    <!-- <harvest-file />
    <harvests /> -->
    <all-harvests />
    </div>
    <div class = "expiration">
    <expiration-file />
    <expirations />
    </div>
    <div class="transplants">
      <transplant-file/>
      <transplants />
    </div>
    <something-info />
  </div>
</template>

<script>
// import HarvestFile from '@/components/HarvestFile'
// import Harvests from '@/components/Harvests'
import ExpirationFile from '@/components/ExpirationFile'
import Expirations from '@/components/Expirations'
import TransplantFile from '@/components/TransplantFile'
import Transplants from '@/components/Transplants'
// import HarvestView from '@/views/HarvestView'
import AllHarvests from '@/components/AllHarvests'
import somethingInfo from '@/components/somethingInfo'


export default {
  name: "home",
  components: {
    // HarvestFile,
    // Harvests,
    ExpirationFile,
    Expirations,
    TransplantFile,
    Transplants,
    // HarvestView,
    AllHarvests,
    somethingInfo
  },
  methods: {
    openNav() {
      document.getElementById("mySidenav").style.width = "250px";
    },
    closeNav() {
      document.getElementById("mySidenav").style.width = "0";
    },
  }
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");

body{
  color: white;
}

.home{
  display: grid;
  
  grid-template-columns: 1fr 3fr 3fr 1fr;
  grid-template-areas: 
    "menu header header ."
    ". harvest expiration ."
    ". transplants . ."
  ;
  grid-gap: 10px;
}

.harvest{
  grid-area: harvest;
  background-color: #41b85395;
  border-radius: 3px;
}

.header{
  color: rgb(51, 49, 49);
  grid-area: header;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
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
    background-color: #43bfe56d;
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

.sidenav {
  color: white;
  height: 100%; 
  width: 0;
  position: fixed;
  z-index: 1; 
  top: 0; 
  left: 0;
  background-color: rgb(37, 35, 35); 
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 60px; /* Place content 60px from the top */
  transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
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

.menu {
  font-size: 20px;
  grid-area: menu;
  background-color: gray;
  margin-top: 50px;
  margin-bottom: 50px;
  border-radius: 25px;
}

.menu:hover {
  background-color:rgb(51, 49, 49);
  color: white;
}

.title {
  font-family: 'Bungee';
  font-size: 60px;
  color: rgb(85, 82, 82);
}

</style>