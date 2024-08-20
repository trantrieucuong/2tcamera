package org.example.ttcameratest.repos.product;

import org.example.ttcameratest.entity.product.ProductDetailed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepos extends JpaRepository<ProductDetailed, Integer> {
    @Query("select pd from ProductDetailed pd where pd.quantity>0")
    List<ProductDetailed> findAllProductDetails();
    @Query("select pd from ProductDetailed pd where pd.product.id = :id")
    List<ProductDetailed> findAllProductDetailsByProductId(@Param("id") Integer id);

}
