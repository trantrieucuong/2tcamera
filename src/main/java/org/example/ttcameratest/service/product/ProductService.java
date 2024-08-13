package org.example.ttcameratest.service.product;

import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.repos.product.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepos productRepos;
    public List<Product> findAll() {
        return productRepos.findAll();
    }
}
