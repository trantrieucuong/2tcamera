package org.example.ttcameratest.repos.product;

import org.example.ttcameratest.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepos extends JpaRepository<ProductType, Integer> {
}
