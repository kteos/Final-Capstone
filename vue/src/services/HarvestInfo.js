import axios from 'axios';

export default {
    addSeedToHarvestTimes(harvest) {
    return axios.post("/harvest/upload", harvest)
    },
    getAllHarvests(){
        return axios.get("/harvest");
    },
    updateHarvest(harvest){
        return axios.post("/harvest/update", harvest)
    }
}



