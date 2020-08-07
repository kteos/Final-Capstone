import axios from 'axios';

export default {
    uploadTransplants(transplant) {
    return axios.post("/transplant/upload", transplant)
    },
    getAllTransplants(){
        return axios.get("/transplant");
    }
}
