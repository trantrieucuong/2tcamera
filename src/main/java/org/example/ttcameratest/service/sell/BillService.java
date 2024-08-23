package org.example.ttcameratest.service.sell;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.sell.Bill;
import org.example.ttcameratest.repos.sell.BillRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillService {
    private final BillRepos billRepos;
    public List<Bill> getAllBills() {
        return billRepos.findAll();
    }
    public Bill getBillById(int id) {
        return billRepos.findById(id).orElse(null);
    }
    public Bill saveBill(Bill bill) {
        return billRepos.save(bill);
    }
    public void deleteBillById(int id) {
        billRepos.deleteById(id);
    }
    public Bill updateBill(Bill bill) {
        return billRepos.save(bill);
    }

}
