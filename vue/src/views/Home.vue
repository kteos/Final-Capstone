<template>
  <div class="home">
    <div class="header">
    <h1>Farm Assistant</h1>
    <span>making your day to day easier</span>
    </div>
    <div  class="harvest">
    <harvest-file />
    <harvests />
    </div>
    <div class = "expiration">
    <expiration-file />
    <expirations />
    </div>
    <div class="transplants">
      <transplant-file/>
      <transplants />
    </div>
  </div>
</template>

<script>
import HarvestFile from '@/components/HarvestFile'
import Harvests from '@/components/Harvests'
import ExpirationFile from '@/components/ExpirationFile'
import Expirations from '@/components/Expirations'
import TransplantFile from '@/components/TransplantFile'
import Transplants from '@/components/Transplants'

export default {
  name: "home",
  components: {
    HarvestFile,
    Harvests,
    ExpirationFile,
    Expirations,
    TransplantFile,
    Transplants
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
}

.header{
  background-color: #43bfe56d;
  grid-area: header;
  display: flex;
  justify-content: space-evenly;
  align-items: center;
}

.expiration{
  grid-area: expiration;
  background-color: #efa500;
}

.transplants{
  grid-area: transplants;
  background-color: red;
}
</style>