package com.autobots.aws.springcloud.repository;

import com.autobots.aws.springcloud.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
}
