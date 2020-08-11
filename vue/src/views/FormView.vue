<template>
    <div class="form">
      <div class="title">
         <h1 class="formttitle">Sales Information</h1>
      </div>
      <div class ="menu2">
        <side-bar-nav />
      </div>
    <div class="secondarytitle">
        <h2>Use the forms below to add relevant information about your harvest including Sales, Loss, and Waste.</h2>
    </div>
      <div class ="uploadSales">
        <p>Sales Information</p>
        <p class="description">Click "Add Sales Info" to add amount and type of sale to your sales log.</p>
        <button class="design" v-on:click.prevent="showSales = !showSales">Add Sales Info</button>
            <sale-info  v-if="showSales"/>
      </div>
      <div class="uploadLoss">
        <p>Loss Information</p>
        <p class="description">Click "Add Loss Info" to record the reason for lost crops.</p>
        <button class="design" v-on:click.prevent="showLoss = !showLoss">Add Loss Info</button>
          <loss-info v-if="showLoss"/>
      </div>
      <div class="uploadWaste">
          <p>Waste Information</p>
          <p class="description">Click "Add Waste Info" to record the reason for wasted crops.</p>
          <button class="design" v-on:click.prevent="showWaste = !showWaste">Add Waste Info</button>
          <waste-info v-if="showWaste"/>
      </div>
    </div>
</template>

<script>
import SaleInfo from '@/components/SaleInfo'
import LossInfo from '@/components/LossInfo'
import WasteInfo from '@/components/WasteInfo'
import SideBarNav from '@/components/SideBarNav'

export default {
    name: "formview",
    components: {
        SaleInfo,
        LossInfo,
        WasteInfo,
        SideBarNav
    },
    data() {
        return {
            showSales: false,
            showLoss: false,
            showWaste: false
        }
    }
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");

h1 {
    font-family: 'Bungee';
    font-size: 60px;
}

.form {
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-areas: 
    "menu title ."
    ". secondarytitle ."
    ". sale ."
    ". loss ."
    ". waste ."
    ;
}
.secondarytitle{
    grid-area: secondarytitle;
    color: rgb(66, 65, 65);
    text-align: center;
}

.title {
    grid-area: title;
    font-family: 'Bungee';
}

.formtitle {
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

.uploadSales {
    grid-area: sale;
    background-color: white;
    opacity: 0.85;
    padding-left: 20px;
}

.uploadLoss {
    grid-area: loss;
    background-color: white;
    opacity: 0.85; 
    padding-left: 20px;
}

.uploadWaste {
    grid-area: waste;
    background-color: white;
    opacity: 0.85; 
    padding-left: 20px;
    padding-bottom: 20px;
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

.description{
    font-size: 15px;
}

.forms {
    background-color: white;
}

.design {
    width: 200px;
    border-radius: 5px;
}

</style>