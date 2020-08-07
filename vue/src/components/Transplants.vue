<template>
  <div>
    <table class="container">
      <tr>
        <th>Crop</th>
        <th>Direct Seed To Transplant Time</th>
        <th>Transplant To Harvest Time</th>
        <th></th>
      </tr>
      <tr v-for="transplant in transplantsCurrent" :key="transplant.id">
        <td>{{transplant.crop}}</td>
        <td>{{transplant.directSeedToTransplantTime}}</td>
        <td>{{transplant.transplantToHarvestTime}}</td>
        <td>
            <a class ="editDelete" v-on:click="handleSelectedItem(transplant)">Edit</a> 
            <!-- <a class ="editDelete">Delete</a> -->
        </td>
      </tr>
    </table>
    <form v-on:submit.prevent="updateTransplants" v-if="isHidden">
    <label for="crop">Crop: </label>
    <input type="text" v-model="computedCrop" /><br>
    <label for="directSeedToTransplantTime">Direct Seed To Transplant Time: </label>
    <input type="number" v-model="computedDirectSeedToTransplant" style="width:40px;">
    <label for="transplantToHarvestTime">Transplant To Harvest Time: </label>
    <input type="number" v-model="computedTransplantToHarvestTime" style="width:40px;">
    <input type="submit">
    </form>
  </div>
</template>

<script>
import TransplantService from "@/services/TransplantService";
export default {
      name: "transplants",
      data() {
        return {
              selectedTransplant: [
                {
                    id:null
                },
                {
                    crop:null
                },
                {
                    directSeedToTransplantTime: null
                },
                {
                    transplantToHarvestTime: null
                }
            ],
            computedCrop: null,
            computedDirectSeedToTransplant: null,
            computedTransplantToHarvestTime: null,
            id: null,
            isHidden: false
        }
      },
      methods: {
        retrieveAllTransplants() {
          TransplantService.getAllTransplants().then(response => {
            this.$store.commit("SET_TRANSPLANTS", response.data);
          });
        },
        handleSelectedItem(transplant){
            this.isHidden = true;
            this.selectedTransplant = [
                {
                    id:transplant.id
                },
                {
                    crop:transplant.crop
                },
                {
                    directSeedToTransplantTime: transplant.directSeedToTransplantTime
                },
                {
                  transplantToHarvestTime: transplant.transplantToHarvestTime
                }
            ]
            this.id = transplant.id;
            this.computedCrop = transplant.crop;
            this.computedDirectSeedToTransplant = transplant.directSeedToTransplantTime;
            this.transplantToHarvestTime = transplant.transplantToHarvestTime;
            
        },
        updateTransplants(){
            this.isHidden = false;
            const newTransplantData = {
                id: this.id,
                crop: this.computedCrop,
                directSeedToTransplantTime: this.directSeedToTransplantTime,
                transplantToHarvestTime: this.transplantToHarvestTime
            }
            TransplantService.updateTransplant(newTransplantData).then(response => {
            this.$store.commit("SET_TRANSPLANTS", response.data)
          });
        },
        updateSelectedItem(){
            this.selectedTransplant.crop = this.computedCrop;
            this.selectedTransplant.directSeedToTransplantTime = this.directSeedToTransplantTime;
            this.selectedTransplant.transplantToHarvestTime = this.transplantToHarvestTime;
        }
      },


  created(){
      this.retrieveAllTransplants();
  },
  computed: {
      transplantsCurrent(){
          return this.$store.state.transplants;
      },
      computeSelectedItem(){
          return this.selectedTransplant;
      },
      computeCrop(){
          return this.computedCrop;
      },
      computedId(){
          return this.id;
      }
  }
};
</script>