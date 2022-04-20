package com.adminms.farmer.service;

import com.adminms.farmer.dao.FarmerRepo;
import com.adminms.farmer.entity.Farmer;
import com.adminms.farmer.exceptions.FarmerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements Iservice{

    @Autowired
    private FarmerRepo farmerRepo;


    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepo.findAll();
    }

    @Override
    public Farmer createFarmer(Farmer farmer) {
        farmerRepo.save(farmer);
        return farmer;
    }

    @Override
    public Farmer getFarmerById(long id) {
        Farmer farmer= farmerRepo.findById(id).orElseThrow(()-> new FarmerNotFoundException("Farmer not found for id:" +id));

        return farmer;
    }

    @Override
    public Farmer updateFarmer(long id, Farmer farmer) {
        Farmer farmerDeatails = farmerRepo.findById(id).orElseThrow(()-> new FarmerNotFoundException("Farmer not found for id:" +id));
        farmerDeatails.setFarmerName(farmer.getFarmerName());
        farmerDeatails.setAddress(farmer.getAddress());
        farmerDeatails.setEmail(farmer.getEmail());
        farmerDeatails.setPhone(farmer.getPhone());
        farmerRepo.save(farmerDeatails);
        return farmerDeatails;
    }

    @Override
    public void deleteFarmer(long id) {
        Farmer farmer= farmerRepo.findById(id).orElseThrow(()-> new FarmerNotFoundException("Farmer not found for id:" +id));
        farmerRepo.delete(farmer);

    }


}
