package org.example.ttcameratest.repos.product;

import org.example.ttcameratest.entity.product.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepos extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.product.id=:id")
    public List<Image> findAllByProductId(@Param("id") int id);

}
