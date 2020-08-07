<template>
  <div>
    <table class="container">
      <tr>
        <th>Crop</th>
        <th>Days to Expire</th>
        <th></th>
      </tr>
      <tr v-for="expiration in expirationsCurrent" :key="expiration.id">
        <td>{{expiration.crop}}</td>
        <td>{{expiration.daysToExpire}}</td>
        <td>
            <a class ="editDelete">Edit</a> 
            <a class ="editDelete">Delete</a>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import ExpirationService from "@/services/ExpirationService";
export default {
      name: "expirations",
      methods: {
        retrieveAllExpirations() {
          ExpirationService.getAllExpirations().then(response => {
            this.$store.commit("SET_EXPIRATIONS", response.data);
          });
        }
      },
    
  
  created(){
      this.retrieveAllExpirations();
  },
  computed: {
      expirationsCurrent(){
          return this.$store.state.expirations;
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