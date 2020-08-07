<template>
  <div>
      
      <p>Upload Expiration File:</p>
      <input type = "file" v-on:change="readExpirationFile"/>
  </div>

</template>

<script>
import ExpirationService from '@/services/ExpirationService'

export default {
    name: "expiration-file",
    data() {
        return {
            expiration: []
        }
    },
    methods: {
        readExpirationFile() {
            var file = event.target.files[0];
            this.$papa.parse(file, {
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
        }
    }

}
</script>

<style>

</style>