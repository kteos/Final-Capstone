<template>
  <div>
    <table class="container">
      <tr>
        <th>Id</th>
        <th>Crop</th>
        <th>Seed to Harvest Time</th>
        <th></th>
      </tr>
      <tr v-for="harvest in this.$store.state.harvests" :key="harvest.id">
        <td>{{harvest.id}}</td>
        <td>{{harvest.crop}}</td>
        <td>{{harvest.directSeedToHarvestTime}}</td>
        <td><a>Edit</a><a>Delete</a></td>
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
    background-color: #F40058;
}

table{
    display: block;
    padding: 10px;
}

.container tr,
.container td{
    display: flex;
    justify-content: space-between;
}

</style>