package org.example.ttcameratest.entity.sell;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ttcameratest.entity.user.Customer;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    private Date date;
    private Date editDate;
    private String address;
    private String status;
    private String number;
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        editDate = new Date();
    }


}
