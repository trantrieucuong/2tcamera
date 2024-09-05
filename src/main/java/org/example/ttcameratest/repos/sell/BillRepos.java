package org.example.ttcameratest.repos.sell;

import org.example.ttcameratest.entity.sell.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepos extends JpaRepository<Bill, Integer> {
}
