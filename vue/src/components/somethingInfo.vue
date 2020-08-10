<template>
<div>{{var1}} {{var2}}
    <form>
        <label for="var1"></label>
        <input type="text" name="var1" v-model="compVar" required>
        <label for="var2"></label>
        <input type="number" name="var2" v-model="var2" required>
        <button v-on:click.prevent="jsonify()">jsonify</button>
        <input type="submit" />
    </form>
</div>
</template>

<script>
export default {
    data(){
        return{
            var1: null,
            var2: null,
            obj: [],
            compVar: null
        }
    },
    methods:{
        jsonify(){
            this.obj = [
                {
                    id : this.var1
                },
                {
                    asdf: this.var2
                }
            ].JSON.stringify();
            console.log(this.obj);
        },
        updateVars(){
            this.var1 = this.compVar;
        }
    },
    watch: {
        compVar: function(){
            this.updateVars();
        }
    }
}

</script>

<style>

</style>