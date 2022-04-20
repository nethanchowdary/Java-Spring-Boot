package com.adminms.farmer.controller;

import com.adminms.farmer.entity.Farmer;
import com.adminms.farmer.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/admin")
@RestController
public class FarmerRestController {

    @Autowired
    private Iservice service;


    // get all farmers
    @GetMapping("/farmers")
    public List<Farmer> getAllFarmers() {
        return service.getAllFarmers();
    }

    // create farmer rest api
    @PostMapping("/farmers")
    public Farmer createFarmer(@RequestBody Farmer farmer) {
        return service.createFarmer(farmer);
    }

    // get farmer by id rest api
    @GetMapping("/farmers/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long id) {
        Farmer farmer= service.getFarmerById(id);
        return ResponseEntity.ok(farmer);
    }

    // update farmer rest api

    @PutMapping("/farmers/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Long id, @RequestBody Farmer farmerDetails) {
        Farmer updatedFarmer= service.updateFarmer(id, farmerDetails);
        return ResponseEntity.ok(updatedFarmer);
    }

    // delete farmer rest api
    @DeleteMapping("/farmers/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFarmer(@PathVariable Long id) {
        service.deleteFarmer(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
