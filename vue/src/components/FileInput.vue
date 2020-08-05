<template>
  <div>
      <p>Upload Harvest File:</p>
      <input type = "file" v-on:change="readFile"/>
  </div>

</template>

<script>
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
                complete: function (results) {
                    console.log(results);
                    results.data.forEach(h => {
                        this.harvest = h;
                    });
                }
            });
        }
    }

}
</script>

<style>

</style>