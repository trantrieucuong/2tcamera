package org.example.ttcameratest.entity.sell;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.entity.product.ProductDetailed;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_detailed_product")
    private ProductDetailed productDetailed;
    private String status;
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private Bill bill;
    private Date date;
    private Date editDate;
    private String number;
    private Double priceVND;
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        editDate = new Date();
    }

}
