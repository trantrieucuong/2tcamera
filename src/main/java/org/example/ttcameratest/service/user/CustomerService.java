package org.example.ttcameratest.service.user;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.user.Customer;
import org.example.ttcameratest.repos.user.CustomerRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepos customerRepos;
    public List<Customer> findAll() {
        return customerRepos.findAll();
    }
    public Customer findById(int id) {
        return customerRepos.findById(id).orElse(null);
    }
    public Customer save(Customer customer) {
        return customerRepos.save(customer);
    }
    public void delete(Customer customer) {
        customerRepos.delete(customer);
    }
    public Customer update(Customer customers) {
        return customerRepos.save(customers);
    }
}
