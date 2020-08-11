<template>
  <div class="upload">
      
      <div>Upload Crops File:</div>
      <input type = "file" v-on:change="setFile"/>
      <button v-on:click.prevent="readCropsFile">Upload</button>
  </div>

</template>

<script>
import CropsService from '@/services/CropsService'

export default {
    name: "crops-upload",
    data() {
        return {
            crops: [],
            files: []
        }
    },
    methods: {
        readCropsFile() {
            this.$papa.parse(this.files, {
                header: true,
                skipEmptyLines: true,
                complete: (results => {
                    this.crops = results.data;
                    console.log(this.expiration)
                    CropsService.uploadCrops(this.crops).then(response => {
                        if (response.status == 201) {
                            console.log('successful');
                        }

                    })
                })
            })
        },
        setFile(){
            this.files = event.target.files[0];
        }
    }

}
</script>

<style>
.upload{
    padding:10px;
}
</style>