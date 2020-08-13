<template>
<div>
    <form v-on:submit.prevent="addInfo">
        <label for="area">Area Identifier: </label>
        <input type="number" name="area" v-model="newHarvestInfo.areaIdentifier" required><br>
        <label for="crop">Crop: </label>
        <input type="text" name="crop" v-model="newHarvestInfo.crop" required>
        <label for="count">Count: </label>
        <input type="number" name="count" v-model="newHarvestInfo.count" required><br>
        <label for="weight">Weight: </label>
        <input type="number" name="weight" v-model="newHarvestInfo.weight" required>
        <input type="submit" />
    </form>

</div>
</template>

<script>
import InfoService from '@/services/InfoService';
export default {
    data(){
        return{
            newHarvestInfo: {}
        }
    },
    methods:{
        addInfo(){
            this.$store.commit("ADD_HARVEST_INFO", this.newHarvestInfo);
            this.newHarvestInfo = {};
            InfoService.addHarvestInfo(this.$store.state.newHarvestInfo).then((response) => {
                if(response.status == 201){
                    console.log('yay');
                }
            })
        }
    }
    
}

</script>

<style>

label {
    margin-bottom: 20px;    
}

input {
    margin-bottom: 20px;
}

</style>