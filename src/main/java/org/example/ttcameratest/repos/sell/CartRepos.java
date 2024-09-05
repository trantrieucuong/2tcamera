package org.example.ttcameratest.repos.sell;

import org.example.ttcameratest.entity.sell.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepos extends JpaRepository<Cart, Integer> {
}
