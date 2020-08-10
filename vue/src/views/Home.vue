<template>
  <div class="home">
    <div class="header">
    <h1>Farm Assistant</h1>
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
<<<<<<< HEAD
    
=======
    <something-info />
>>>>>>> b8f37e69d63871708bf5bdf01f9ab710cfc552f4
  </div>
</template>

<script>
// import HarvestFile from '@/components/HarvestFile'
// import Harvests from '@/components/Harvests'
import ExpirationFile from '@/components/ExpirationFile'
import Expirations from '@/components/Expirations'
import TransplantFile from '@/components/TransplantFile'
import Transplants from '@/components/Transplants'
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
<<<<<<< HEAD
    Transplants
    
=======
    Transplants,
    AllHarvests,
    somethingInfo
>>>>>>> b8f37e69d63871708bf5bdf01f9ab710cfc552f4
  }
};
</script>

<style>
body{
  background-color: #161B40;
  color: white;
}

.home{
  display: grid;
  
  grid-template-columns: 1fr 3fr 3fr 1fr;
  grid-template-areas: 
    ". header header ."
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
  background-color: #43bfe56d;
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
</style>