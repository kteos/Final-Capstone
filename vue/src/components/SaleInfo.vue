<template>
<div>
    <form v-on:submit.prevent="addInfo">
        <div class="product">
        <label for="productName">Product: </label>
        <input type="text" name="productName" v-model="newInfo.product" required>
        </div>
        <div class="amount">
        <label for="amount">Amount: <br></label>
        <input class="amountfield" type="number" name="amount" v-model="newInfo.amount" required>
        </div>
        <div class="howSold">
        <label for="howSold">How Sold: </label>
        <input type="text" name="howSold" v-model="newInfo.howSold" required>
        </div>
        <div class="submit">
        <input type="submit" />
        </div>
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

form {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas: 
    "product amount howSold submit";
    grid-gap: 10px;
}

form div {
    align-items: center;
}

.product {
    grid-area: product;
}

.amount {
    grid-area: amount;
}

.howSold {
    grid-area: howSold;
}

.submit {
    grid-area: submit;
}
</style>