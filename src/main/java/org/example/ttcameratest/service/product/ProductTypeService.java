package org.example.ttcameratest.service.product;

import org.example.ttcameratest.entity.product.ProductType;
import org.example.ttcameratest.repos.product.ProductTypeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepos productTypeRepos;
    public List<ProductType> getAllProductTypes() {
        return productTypeRepos.findAll();
    }
}
