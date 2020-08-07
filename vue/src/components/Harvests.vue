<template>
  <div>
    <table class="container">
      <tr>
        <th>Id</th>
        <th>Crop</th>
        <th>Seed to Harvest Time</th>
        <th></th>
      </tr>
      <tr v-for="harvest in harvestsCurrent" :key="harvest.id">
        <td>{{harvest.id}}</td>
        <td>{{harvest.crop}}</td>
        <td>{{harvest.directSeedToHarvestTime}}</td>
        <td>
            <a class ="editDelete" v-on:click="handleSelectedItem(harvest)">Edit</a> 
            <a class ="editDelete">Delete</a>
        </td>
      </tr>
    </table>
    <form>
    <label for="crop">Crop: </label>
    <input type="text" name="crop" id="crop" :value="computedCrop"/><br>
    <label for="seedToHarvestTime">Seed to Harvest: </label>
    <input type="number" name="seedToHarvestTime" id="seedToHarvestTime" :value="computedSeedHarvest" style="width:40px;">
    <input type="submit">
    </form>
  </div>
</template>

<script>
import HarvestInfo from "@/services/HarvestInfo";
export default {
    data(){
        return {
            selectedHarvest: [
                {
                    id:null
                },
                {
                    crop:null
                },
                {
                    directSeedToHarvestTime: null
                }
            ],
            computedCrop: null,
            computedSeedHarvest: null
        }
    },
      name: "harvests",
      methods: {
        retrieveAllHarvests() {
          HarvestInfo.getAllHarvests().then(response => {
            this.$store.commit("SET_HARVESTS", response.data);
          });
        },
        handleSelectedItem(harvest){
            this.selectedHarvest = [
                {
                    id:harvest.id
                },
                {
                    crop:harvest.crop
                },
                {
                    directSeedToHarvestTime: harvest.directSeedToHarvestTime
                }
            ]
            this.computedCrop = harvest.crop;
            this.computedSeedHarvest = harvest.directSeedToHarvestTime;
        }
      },
    
  
  created(){
      this.retrieveAllHarvests();
  },
  computed: {
      harvestsCurrent(){
          return this.$store.state.harvests;
      },
      computeSelectedItem(){
          return this.selectedHarvest;
      },
      computeCrop(){
          return this.computedCrop;
      }
      
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

.editDelete{
    cursor: pointer;
        padding-left: 20px;
}

.editDelete:hover{
    text-decoration: underline;

}

</style>