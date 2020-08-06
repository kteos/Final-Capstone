<template>
  <div class="div.container">
    <table>
      <tr>
        <th>Id</th>
        <th>Crop</th>
        <th>Seed to Harvest Time</th>
      </tr>
      <tr v-for="harvest in this.$store.state.harvests" :key="harvest.id">
        <td>{{harvest.id}}</td>
        <td>{{harvest.crop}}</td>
        <td>{{harvest.directSeedToHarvestTime}}</td>
      </tr>
    </table>
  </div>
</template>

<script>
import HarvestInfo from "@/services/HarvestInfo";
export default {
      name: "harvests",
      methods: {
        retrieveAllHarvests() {
          HarvestInfo.getAllHarvests().then(response => {
            this.$store.commit("SET_HARVESTS", response.data);
          });
        }
      },
    
  
  created(){
      this.retrieveAllHarvests();
  }
};
</script>

<style>
table > tr:nth-child(even){
    color: #F40058;
}

#div.container{
    background-color: aliceblue;
}
</style>