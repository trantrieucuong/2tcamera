package org.example.ttcameratest.repos.product;

import org.example.ttcameratest.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepos extends JpaRepository<Category, Integer> {
}
