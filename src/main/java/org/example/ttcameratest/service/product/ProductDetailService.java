package org.example.ttcameratest.service.product;

import lombok.AllArgsConstructor;

import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.entity.product.ProductDetailed;
import org.example.ttcameratest.repos.product.ProductDetailRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class ProductDetailService {
    @Autowired
    private  ProductDetailRepos productDetailRepos;
    public List<ProductDetailed> getProductDetails() {
        return productDetailRepos.findAllProductDetails();
    }
    public List<ProductDetailed> findProductById(int id) {

         return productDetailRepos.findAllProductDetailsByProductId(id);
    }

}
