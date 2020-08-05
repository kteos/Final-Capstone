<template>
  <div>
      <p>Upload Harvest File:</p>
      <input type = "file" v-on:change="readFile"/>
  </div>

</template>

<script>
import HarvestInfo from '@/services/HarvestInfo'

export default {
    name: "file-input",
    data() {
        return {
            harvest: []
        }
    },
    methods: {
        readFile() {
            var file = event.target.files[0];
            this.$papa.parse(file, {
                header: true,
                skipEmptyLines: true,
                complete: (results => {
                    this.harvest = results.data;
                    HarvestInfo.addSeedToHarvestTimes(this.harvest).then(response => {
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