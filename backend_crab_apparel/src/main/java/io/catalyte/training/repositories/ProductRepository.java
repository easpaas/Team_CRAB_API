package io.catalyte.training.repositories;

import io.catalyte.training.domains.products.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPromotionFlagTrue();

    List<Product> findTop2ByCreateDateNotNullOrderByCreateDateDesc();

    List<Product> findTop4ByViewCountNotNullOrderByViewCountDesc();



}