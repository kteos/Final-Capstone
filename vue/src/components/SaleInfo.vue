<template>
<div>
    <form v-on:submit.prevent="addInfo">
        <label for="productName">Crop Sold: </label>
        <input type="text" name="productName" v-model="newInfo.product" required>
        <label for="amount">Amount Sold (lbs/count): </label>
        <input class="amountfield" type="number" name="amount" v-model="newInfo.amount" required><br>
        <label for="howSold">Sales Channel: </label>
        <input type="text" name="howSold" v-model="newInfo.howSold" required>
        <input type="submit" />
    </form>
</div>
</template>

<script>
import InfoService from '@/services/InfoService';
export default {
    // product *str amount *number howSold *str
    // /sale/input *post
    data(){
        return{
            newInfo: {}
        }
    },
    methods:{
        addInfo(){
            this.$store.commit("ADD_INFO", this.newInfo);
            this.newInfo = {};
            InfoService.addSaleInfo(this.$store.state.newInfo).then((response) => {
                if(response.status == 201){
                    console.log('yay');
                }
            })
        }
    }
    
}

</script>

<style>

</style>