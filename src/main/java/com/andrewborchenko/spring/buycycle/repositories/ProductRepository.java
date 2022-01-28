package com.andrewborchenko.spring.buycycle.repositories;

import com.andrewborchenko.spring.buycycle.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByTitle(String title);
}
