<template>
  <div>
    <table class="container">
      <tr>
        <th>Crop</th>
        <th>Seed to Harvest Time</th>
        <th></th>
      </tr>
      <tr v-for="harvest in harvests" :key="harvest.id">
        <td>{{harvest.crop}}</td>
        <td>{{harvest.directSeedToHarvestTime}}</td>
        <td>
            <a class ="editDelete" v-on:click="handleSelectedItem(harvest)" >Edit</a> 
            <!-- <a class ="editDelete">Delete</a> -->
        </td>
      </tr>
    </table>
    <form v-on:submit.prevent="updateHarvest(selectedHarvest)" v-if="isHidden">
    <label for="crop">Crop: </label>
    <input type="text" v-model="computedCrop" /><br>
    <label for="seedToHarvestTime">Seed to Harvest: </label>
    <input type="number" v-model="computedSeedHarvest" style="width:40px;">
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
            computedSeedHarvest: null,
            id: null,
            isHidden: false,
            harvests: []
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
            this.isHidden = true;
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
            this.id = harvest.id;
            this.computedCrop = harvest.crop;
            this.computedSeedHarvest = harvest.directSeedToHarvestTime;
            
        },
        updateHarvest(){
            this.isHidden = false;
            const newHarvestData = {
                id: this.id,
                crop: this.computedCrop,
                directSeedToHarvestTime: this.computedSeedHarvest
            }
            console.log(newHarvestData);
            HarvestInfo.updateHarvest(newHarvestData).then(response => {
                console.log(response.status);
            this.$store.commit("SET_HARVESTS", response.data)
          });
        },
        updateSelectedItem(){
            this.selectedHarvest.crop = this.computedCrop;
            this.selectedHarvest.directSeedToHarvestTime = this.computedSeedHarvest;
        },
        getAllHarvests(){
            HarvestInfo.getAllHarvests().then((response) => {
                this.harvests = response.data;
            })
        }
      },
    
  
  created(){
      this.retrieveAllHarvests();
      this.getAllHarvests();
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
      },
      computedId(){
          return this.id;
      }
      
  },
  watch:{ 
      harvests: function(){
      this.getAllHarvests();
  }
  }
};
</script>

<style>

.editDelete{
    cursor: pointer;
        padding-left: 20px;
}

.editDelete:hover{
    text-decoration: underline;

}

</style>