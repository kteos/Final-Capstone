<template>
  <div class="home">
  <div class="header">
    <h1 class="title">Farm Assist</h1>
  </div>
  <div class="mission">
    <p class="details">Designed to help make farmers day to day easier</p>
  </div>
    <div class="menu1">
      <side-bar-nav />
    </div>
  <div class="chart">
    <random-chart />
  </div>
  <div class ="harvestInfo">
    <router-link class="link" v-bind:to="{name: 'harvestview'}">Harvest Info</router-link>
  </div>
    <div class ="transplantInfo">
    <router-link class="link" v-bind:to="{name: 'transplantview'}">Transplant Info</router-link>
  </div>
  <div class ="expirationInfo">
    <router-link class="link" v-bind:to="{name: 'expirationview'}">Expiration Info</router-link>
  </div>
  <div class ="addInfo">
    <router-link class="link" v-bind:to="{name: 'formview'}">Add Info</router-link>
  </div>
  <div class="email-button">
    <email-test />
  </div>
  </div>
</template>

<script>
import SideBarNav from '@/components/SideBarNav'
import RandomChart from '@/components/RandomChart'
import EmailTest from '@/components/EmailTest'

export default {
  
  name: "home",
  components: {
    SideBarNav,
    RandomChart,
    EmailTest
  },
};
</script>

<style>
 @import url("https://fonts.googleapis.com/css2?family=Bungee");
 
 body{
   color: black;
 }
 
 .details {
   color: rgb(85, 82, 82);
   display: flex;
   align-content: bottom;
 }

 .email-button{
   grid-area: email-button;

 }

 .home{
   display: grid;
   
   grid-template-columns: 1fr 2fr 2fr 1fr;
   grid-template-areas: 
     ". header header ."
     ". mission mission ."
     ". chart chart ."
     ". harvestview transplantview ."
     ". expirationview addview ."
     ". . . email-button"
   ;
   grid-gap: 10px;
 }

 .addInfo {
   grid-area: addview;
   font-size: 40px;
   display: flex;
   justify-content: center;
   align-items: center;
   background-color: #ad8dbd;
   border-radius: 25px;
   height: 80px;
 }

 .expirationInfo {
   grid-area: expirationview;
   font-size: 40px;
   display: flex;
   justify-content: center;
   align-items: center;
   background-color: #fefae0;
   border-radius: 25px;
   height: 80px;
   position: relative;
 }

 .transplantInfo {
   grid-area: transplantview;
   font-size: 40px;
   display: flex;
   justify-content: center;
   align-items: center;
   background-color: #89975b;
   border-radius: 25px;
   height: 80px;
 }
 .harvestInfo {
   grid-area: harvestview;
   font-size: 40px;
   display: flex;
   justify-content: center;
   align-items: center;
   background-color: #dda15e;
   border-radius: 25px;
   height: 80px;
 }

 .chart {
   grid-area: chart;
   height: 100%;
   width: 100%;
 }

 .header{
   color: rgb(51, 49, 49);
   grid-area: header;
   display: flex;
   justify-content: space-evenly;
   align-items: top;
   border-radius: 3px;
   font-family: 'Bungee';
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
 
 .title {
   font-family: 'Bungee';
   font-size: 60px;
   color: rgb(85, 82, 82);
 }
 
 .mission {
   grid-area: mission;
   display: flex;
   justify-content: space-evenly;
   align-items: top;
   border-radius: 3px;
   font-family: 'Bungee';
 }

 .link {
   text-decoration: none;
   color: rgb(51, 49, 49);
 }

 .link:hover {
   text-decoration: underline;
 }


</style>