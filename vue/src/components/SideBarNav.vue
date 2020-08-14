<template>
<div>
      <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" v-on:click="closeNav()">&times;</a>
        <a href="/">Home</a>
        <a href="/harvest">Harvest</a>
        <a href="/cropplan">Crop Plans</a>
        <a href="/transplant">Transplant</a>
        <a href="/expiration">Expiration</a>
        <a href="/form">Add Sales Info</a>
        <a href="/logout">Logout</a>
      </div>
  <button class="menu" v-on:click="openNav()">Menu</button>
</div>
</template>

<script>
export default {
    name: "sideNav",
    methods: {
      openNav() {
          document.getElementById("mySidenav").style.width = "250px";
      },
      closeNav() {
          document.getElementById("mySidenav").style.width = "0";
      }
  }
}
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");

.sidenav {
  color: white;
  height: 100%; 
  width: 0;
  position: fixed;
  z-index: 1; 
  top: 0; 
  left: 0;
  background-color: rgb(37, 35, 35); 
  overflow-x: hidden; 
  padding-top: 60px; 
  transition: 0.5s;
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
  margin-left: -30px;

  margin-bottom: 50px;
  border-radius: 0px 25px 25px 0px;
  float: left;
}

.menu:hover {
  background-color:rgb(51, 49, 49);
  color: white;
}

</style>