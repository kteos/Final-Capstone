<template>
<div>
    <form v-on:submit.prevent="addInfo">
        <label for="crop">Crop: </label>
        <input type="text" name="crop" v-model="newLoss.crop" required>
        <label for="reason">Loss Reason: </label>
        <input type="text" name="reason" v-model="newLoss.lossReason" required>
        <input type="submit" />
    </form>

</div>
</template>

<script>
import InfoService from '@/services/InfoService';
export default {
    data(){
        return{
            newLoss: {}
        }
    },
    methods:{
        addInfo(){
            this.$store.commit("ADD_LOSS_INFO", this.newLoss);
            this.newLoss = {};
            InfoService.addLossInfo(this.$store.state.newLossInfo).then((response) => {
                if(response.status == 201){
                    console.log('yay');
                }
            })
        }
    }
    
}

</script>