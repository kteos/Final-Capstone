<template>
  <div class="upload">
      
      <div>Upload Harvest File:</div>
      <input type = "file" v-on:change="setFile"/>
      <button v-on:click.prevent="readFile">Upload</button>
      
  </div>

</template>

<script>
import HarvestInfo from '@/services/HarvestInfo'

export default {
    name: "harvest-file",
    data() {
        return {
            harvest: [],
            files: []
        }
    },
    methods: {
        readFile() {
            this.$papa.parse(this.files, {
                header: true,
                skipEmptyLines: true,
                complete: (results => {
                    this.harvest = results.data;
                    console.log(this.harvest)
                    HarvestInfo.addSeedToHarvestTimes(this.harvest).then(response => {
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