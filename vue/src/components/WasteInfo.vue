<template>
<div>
    <form v-on:submit.prevent="addInfo">
        <label for="crop">Crop: </label>
        <input type="text" name="crop" v-model="newWaste.crop" required>
        <label for="reason">Waste Reason: </label>
        <input type="text" name="reason" v-model="newWaste.reason" required>
        <input type="submit" />
    </form>

</div>
</template>

<script>
import InfoService from '@/services/InfoService';
export default {
    data(){
        return{
            newWaste: {}
        }
    },
    methods:{
        addInfo(){
            this.$store.commit("ADD_WASTE_INFO", this.newWaste);
            this.newWaste = {};
            InfoService.addWasteInfo(this.$store.state.newWasteInfo).then((response) => {
                if(response.status == 201){
                    console.log('yay');
                }
            })
        }
    }
    
}

</script>