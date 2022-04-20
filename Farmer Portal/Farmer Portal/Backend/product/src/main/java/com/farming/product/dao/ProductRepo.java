package com.farming.product.dao;

import com.farming.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
  //  Optional<Product> findProductById(long id);
}
