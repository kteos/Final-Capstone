import axios from 'axios';

export default {
    addSaleInfo(saleForm){
        return axios.post("/sale/input", saleForm);
    },
    addHarvestInfo(harvestForm){
        return axios.post("/harvestinfo/input", harvestForm)
    },
    addWasteInfo(wasteForm){
        return axios.post("/waste/input", wasteForm)
    },
    addLossInfo(lossForm){
        return axios.post("/loss/input", lossForm)
    }
}