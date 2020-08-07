<template>
  <div class="upload">
      
      <div>Upload Transplant File:</div>
      <input type = "file" v-on:change="setFile"/>
      <button v-on:click.prevent="readTransplantFile">Upload</button>
  </div>

</template>

<script>
import TransplantService from '@/services/TransplantService'

export default {
    name: "transplant-file",
    data() {
        return {
            transplant: [],
            files: []
        }
    },
    methods: {
        readTransplantFile() {
            this.$papa.parse(this.files, {
                header: true,
                skipEmptyLines: true,
                complete: (results => {
                    this.transplant = results.data;
                    TransplantService.uploadTransplants(this.transplant).then(response => {
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
    padding: 10px;
}
</style>
