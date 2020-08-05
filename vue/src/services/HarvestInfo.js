import axios from 'axios';

export default {
    addSeedToHarvestTimes(harvest) {
    return axios.post("/harvest/upload", harvest)
    }   
}



