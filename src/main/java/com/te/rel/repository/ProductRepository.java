package com.te.rel.repository;

import com.te.rel.entities.Customer;
import com.te.rel.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("Select p.customer from Product p where p.productName=?1")
    Customer getCustomerByProd(String pName);

}
