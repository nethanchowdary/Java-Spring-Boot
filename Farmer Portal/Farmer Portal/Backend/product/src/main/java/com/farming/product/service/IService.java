package com.farming.product.service;

import com.farming.product.entity.Product;

import java.util.List;

public interface IService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(long id);
    Product updateProduct(long id, Product product);
    void deleteProduct( long id);
}
