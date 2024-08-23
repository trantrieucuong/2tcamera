package org.example.ttcameratest.repos.user;

import org.example.ttcameratest.entity.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepos extends JpaRepository<Customer, Integer> {
}
