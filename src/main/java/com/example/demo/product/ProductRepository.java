package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findAllByDeleteAtIsNull();

    @Query("select s from ProductEntity s where s.shop.id = :shopIds")
    List<ProductEntity> findAllByShopIdIn(Long shopIds);
}
