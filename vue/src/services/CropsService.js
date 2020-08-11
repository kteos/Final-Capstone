import axios from 'axios';

export default {
    uploadCrops(crops) {
    return axios.post("/crops/upload", crops)
    },
    getAllCrops(){
        return axios.get("/crops");
    },
    updateCrop(crop){
        return axios.post("/crops/update", crop)
    }

}


