<template>
  <div>
    <table class="container">
      <tr>
        <th>Crop</th>
        <th>Days to Expire</th>
        <th></th>
      </tr>
      <tr v-for="expiration in expirations" :key="expiration.id">
        <td>{{expiration.crop}}</td>
        <td>{{expiration.daysToExpire}}</td>
        <td>
            <a class ="editDelete" v-on:click="handleSelectedItem(expiration)">Edit</a> 
            <!-- <a class ="editDelete">Delete</a> -->
        </td>
      </tr>
    </table>
    <form v-on:submit.prevent="updateExpirations" v-if="isHidden">
    <label for="crop">Crop: </label>
    <input type="text" v-model="computedCrop" /><br>
    <label for="seedToHarvestTime">Days to Expire: </label>
    <input type="number" v-model="computedDays" style="width:40px;">
    <input type="submit">
    </form>
  </div>
</template>

<script>
import ExpirationService from "@/services/ExpirationService";
export default {
    data(){
        return {
            selectedExpiraton: [
                {
                    id:null
                },
                {
                    crop:null
                },
                {
                    daysToExpire: null
                }
            ],
            computedCrop: null,
            computedDays: null,
            id: null,
            isHidden: false,
            expirations: []
        }
    },
      name: "expirations",
      methods: {
        retrieveAllExpirations() {
          ExpirationService.getAllExpirations().then(response => {
            this.$store.commit("SET_EXPIRATIONS", response.data);
          });
        },
        handleSelectedItem(expiration){
            this.isHidden = true;
            this.selectedExpiration = [
                {
                    id:expiration.id
                },
                {
                    crop:expiration.crop
                },
                {
                    daysToExpire: expiration.daysToExpire
                }
            ]
            this.id = expiration.id;
            this.computedCrop = expiration.crop;
            this.computedDays = expiration.daysToExpire
            
        },
        updateExpirations(){
            this.isHidden = false;
            const newExpirationData = {
                id: this.id,
                crop: this.computedCrop,
                daysToExpire: this.computedDays
            }
            ExpirationService.updateExpiration(newExpirationData).then(response => {
            this.$store.commit("SET_EXPIRATIONS", response.data)
          });
        },
        updateSelectedItem(){
            this.selectedExpiration.crop = this.computedCrop;
            this.selectedExpiration.daysToExpire = this.computedDays;
        },
        getAllCurrentExpirations(){
            ExpirationService.getAllExpirations().then((response)=>{
                this.expirations = response.data;
            })
        }
      },
    
  
  created(){
      this.retrieveAllExpirations();
      this.getAllCurrentExpirations();
  },
  computed: {
      expirationsCurrent(){
          return this.$store.state.expirations;
      },
      computeSelectedItem(){
          return this.selectedExpiration;
      },
      computeCrop(){
          return this.computedCrop;
      },
      computedId(){
          return this.id;
      }
  },
  watch:{
      expirations: function(){
          this.getAllCurrentExpirations();
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