<template>
  <div>
      
      <p>Upload Transplant File:</p>
      <input type = "file" v-on:change="readTransplantFile"/>
  </div>

</template>

<script>
import TransplantService from '@/services/TransplantService'

export default {
    name: "transplant-file",
    data() {
        return {
            transplant: []
        }
    },
    methods: {
        readTransplantFile() {
            var file = event.target.files[0];
            this.$papa.parse(file, {
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
        }
    }

}
</script>

<style>
