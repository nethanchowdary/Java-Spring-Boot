package com.adminms.farmer.dao;

import com.adminms.farmer.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepo extends JpaRepository<Farmer, Long> {

}
