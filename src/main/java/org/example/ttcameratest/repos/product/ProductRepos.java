package org.example.ttcameratest.repos.product;

import org.example.ttcameratest.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepos extends JpaRepository<Product, Integer> {
}
