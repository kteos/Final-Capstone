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
        <td>{{transplant.diredtSeedToTransplantTime}}</td>
        <td>{{transplant.transplantToHarvestTime}}</td>
        <td>
            <a class ="editDelete">Edit</a> 
            <a class ="editDelete">Delete</a>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import TransplantService from "@/services/TransplantService";
export default {
      name: "transplants",
      methods: {
        retrieveAllTransplants() {
          TransplantService.getAllTransplants().then(response => {
            this.$store.commit("SET_TRANSPLANTS", response.data);
          });
        }
      },
    
  
  created(){
      this.retrieveAllTransplants();
  },
  computed: {
      transplantsCurrent(){
          return this.$store.state.transplants;
      }
  }
};
</script>