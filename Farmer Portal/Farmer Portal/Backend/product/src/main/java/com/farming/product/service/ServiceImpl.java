package com.farming.product.service;

import com.farming.product.dao.ProductRepo;
import com.farming.product.entity.Product;
import com.farming.product.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements IService {

    @Autowired
    private ProductRepo productRepo;


    @Override
    public Product createProduct(Product product) {
        productRepo.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not exist with id :" + id));
        return product;
    }



    @Override
    public Product updateProduct(long id , Product product) {
        Product productDetails = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found for id:" +id));
        productDetails.setProductName(product.getProductName());
        productDetails.setProductType(product.getProductType());
        productDetails.setPrice(product.getPrice());
        productDetails.setQuantity(product.getQuantity());
        productRepo.save(productDetails);
        return productDetails;
    }

    @Override
    public void deleteProduct(long id) {
            Product product = productRepo.findById(id)
                    .orElseThrow(() -> new ProductNotFoundException("Product not exist with id :" + id));

            productRepo.delete(product);

    }
}
