<template>
  <div class="upload">
      
      <div>Upload Expiration File:</div>
      <input type = "file" v-on:change="setFile"/>
      <button v-on:click.prevent="readExpirationFile">Upload</button>
  </div>

</template>

<script>
import ExpirationService from '@/services/ExpirationService'

export default {
    name: "expiration-file",
    data() {
        return {
            expiration: [],
            files: []
        }
    },
    methods: {
        readExpirationFile() {
            this.$papa.parse(this.files, {
                header: true,
                skipEmptyLines: true,
                complete: (results => {
                    this.expiration = results.data;
                    console.log(this.expiration)
                    ExpirationService.uploadExpirations(this.expiration).then(response => {
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