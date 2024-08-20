package org.example.ttcameratest.service.product;

import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.repos.product.ProductRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepos productRepos;
    public List<Product> findAll() {
        return productRepos.findAll();
    }
    public Product findById(int id) {
        return productRepos.findById(id).orElse(null);
    }
    public Product save(Product product) {
        return productRepos.save(product);
    }
    public void deleteById(int id) {
        productRepos.deleteById(id);
    }
    public List<Product> findByName(String nameProduct) {
        return productRepos.findByProductName(nameProduct);
    }
    public Page<Product> findByPage(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return productRepos.findAll(pageable);
    }
}
