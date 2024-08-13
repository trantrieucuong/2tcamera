package org.example.ttcameratest.service.product;

import org.example.ttcameratest.entity.product.Category;
import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.entity.product.ProductType;
import org.example.ttcameratest.repos.product.CategoryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepos categoryRepos;
    public List<Category> findAll() {
        return categoryRepos.findAll();
    }
}
