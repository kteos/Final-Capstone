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
   
   grid-template-columns: 1fr 3fr 1fr;
   grid-template-areas: 
     ". header ."
     ". mission ."
     ". chart ."
     ". email-button ."
   ;
   grid-gap: 10px;
 }
 
 .chart {
   grid-area: chart;
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
 
 .mission {
   grid-area: mission;
   display: flex;
   justify-content: space-evenly;
   align-items: top;
   border-radius: 3px;
   font-family: 'Bungee';
 }

</style>