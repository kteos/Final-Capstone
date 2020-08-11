<template>
  <div>
    <table class="container">
      <tr>
        <th>Area</th>
        <th>Crop</th>
        <th>Planting Date</th>
      </tr>
      <tr v-for="crop in crops" :key="crop.id">
        <td>{{crop.area}}</td>
        <td>{{crop.crop}}</td>
        <td>{{crop.plantingDate}}</td>
        <td>
            <a class ="editDelete" v-on:click="handleSelectedItem(crop)">Edit</a> 
            <!-- <a class ="editDelete">Delete</a> -->
        </td>
      </tr>
    </table>
    <form v-on:submit.prevent="updateCrops" v-if="isHidden">
    <label for="area">Area: </label>
    <input type="text" v-model="computedArea" /><br>
    <label for="crop">Crop: </label>
    <input type="text" v-model="computedCrop">
    <label for="plantingDate">Planting Date: </label>
    <input type="date" v-model="computedDate" />
    <input type="submit">
    </form>
  </div>
</template>

<script>
import CropsService from "@/services/CropsService";
export default {
    data(){
        return {
            selectedCrop: [],
            computedArea: null,
            computedCrop: null,
            computedDate: null,
            id: null,
            isHidden: false,
            crops: []
        }
    },
      name: "crops",
      methods: {
        retrieveAllCrops() {
          CropsService.getAllCrops().then(response => {
            this.$store.commit("SET_CROPS", response.data);
          });
        },
        handleSelectedItem(crop){
            this.isHidden = true;
            this.selectedCrop = [
                {
                    id:crop.id
                },
                {
                    area:crop.area
                },
                {
                    crop: crop.crop
                },
                {
                    plantingDate: crop.plantingDate
                }
            ]
            this.id = crop.id;
            this.computedArea = crop.area;
            this.computedCrop = crop.crop;
            this.computedDate = crop.plantingDate;
        },
        updateCrops(){
            this.isHidden = false;
            const newCropData = {
                id: this.id,
                area: this.computedArea,
                crop: this.computedCrop,
                plantingDate: this.computedDate
            }
            CropsService.updateCrop(newCropData).then(response => {
            this.$store.commit("SET_CROPS", response.data)
          });
        },
        updateSelectedItem(){
            this.selectedCrop.area = this.computedArea;
            this.selectedCrop.crop = this.computedCrop;
            this.selectedCrop.plantingDate = this.computedDate;
        },
        getAllCurrentCrops(){
            CropsService.getAllCrops().then((response)=>{
                this.crops = response.data;
            })
        }
      },
    
  
  created(){
      this.retrieveAllCrops();
      this.getAllCurrentCrops();
  },
  computed: {
      cropsCurrent(){
          return this.$store.state.crops;
      },
      computeSelectedItem(){
          return this.selectedCrop;
      },
      computeCrop(){
          return this.computedCrop;
      },
      computedId(){
          return this.id;
      }
  },
  watch:{
      crops: function(){
          this.getAllCurrentCrops();
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