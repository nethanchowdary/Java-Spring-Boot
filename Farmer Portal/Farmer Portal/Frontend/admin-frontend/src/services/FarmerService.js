import axios from 'axios';

const Farmer_API_BASE_URL = "http://localhost:8585/admin/farmers";

class FarmerService {

    getFarmers(){
        return axios.get(Farmer_API_BASE_URL);
    }

    createFarmer(farmer){
        return axios.post(Farmer_API_BASE_URL, farmer);
    }

    getFarmerById(farmerId){
        return axios.get(Farmer_API_BASE_URL + '/' + farmerId);
    }

    updateFarmer(farmer, farmerId){
        return axios.put(Farmer_API_BASE_URL + '/' + farmerId, farmer);
    }

    deleteFarmer(farmerId){
        return axios.delete(Farmer_API_BASE_URL + '/' + farmerId);
    }
}

export default new FarmerService()