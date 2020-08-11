<template>
<div>{{var1}} {{var2}}
    <form>
        <label for="var1"></label>
        <input type="text" name="var1" v-model="newInfo.id" required>
        <label for="var2"></label>
        <input type="number" name="var2" v-model="newInfo.data" required>
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
            compVar: null,
            newInfo: {}
        }
    },
    methods:{
        // jsonify(){
        //     this.obj = [
        //         {
        //             id : this.var1
        //         },
        //         {
        //             asdf: this.var2
        //         }
        //     ].JSON.stringify();
        //     console.log(this.obj);
        // },
        // updateVars(){
        //     this.var1 = this.compVar;
        // }
        addInfo(){
            this.$store.commit("ADD_INFO", this.newInfo);
            this.newInfo = {};
        }
    }
    
}

</script>

<style>

</style>