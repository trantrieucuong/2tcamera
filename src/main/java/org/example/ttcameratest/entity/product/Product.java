package org.example.ttcameratest.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    private String nameProduct;
    private Date date;
    private Date editDate;
    private String status;
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_product_type")
    private ProductType productType;
    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        editDate = new Date();
    }
    private float rating;

}
