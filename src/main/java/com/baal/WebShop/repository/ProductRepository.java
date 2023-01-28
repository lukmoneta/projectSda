package com.baal.WebShop.repository;

import com.baal.WebShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameIsIgnoreCase(String name);

}
