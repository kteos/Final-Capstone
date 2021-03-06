import axios from 'axios';

export default {
    uploadExpirations(expiration) {
    return axios.post("/expiration/upload", expiration)
    },
    getAllExpirations(){
        return axios.get("/expiration");
    },
    updateExpiration(expiration){
        return axios.post("/expiration/update", expiration)
    }

}


