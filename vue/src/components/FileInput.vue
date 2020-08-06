<template>

  <div><form v-on:submit.prevent="readFile(file)">
      <label for="csv"></label>
      <input type="file" name="csv" id="csv"/>
      <input type="submit" />
      </form>
  </div>
</template>

<script>
export default {
    data: function () {
        return {
            file: "",
            availability: {}
        }
    },
    methods: {
        readFile() {
            /* return first object in FileList */
            var file = event.target.files[0];
            this.$papa.parse(file, {
                header: true,
                complete: function (results) {
                    this.availability = results.data;
                    console.log(this.availability);
                }
            });
        }
        // ,
        // getFile(){
        //     return this.file = csv;
        // }
    }
}
</script>

<style>

</style>