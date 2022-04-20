package com.adminms.farmer.service;

import com.adminms.farmer.entity.Farmer;

import java.util.List;

public interface Iservice {

    List<Farmer> getAllFarmers();
    Farmer createFarmer(Farmer farmer);
    Farmer getFarmerById(long id);
    Farmer updateFarmer(long id, Farmer farmer);
    void deleteFarmer(long id);

}
