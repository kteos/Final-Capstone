import axios from 'axios';

export default{
    sendTestEmail(){
        return axios.post("/send");
    }
}