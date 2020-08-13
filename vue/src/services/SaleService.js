import axios from 'axios';

export default {
    getAllSales(){
        return axios.get("/sale");
    }
}