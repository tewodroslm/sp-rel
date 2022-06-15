package com.te.rel.repository;

import com.te.rel.dto.CustomerProductResponse;
import com.te.rel.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.te.rel.dto.CustomerProductResponse(c.name, c.email, c.gender) FROM Customer c")
    List<CustomerProductResponse> findAllModified();

    List<Customer> findByGender(String gen);

    List<Customer> findByEmailContaining(String email);

    @Query("SELECT c.name from Customer c where c.email=?1")
    String getFirstNameByEmail(String email);

    @Query("Select c.name, c.gender from Customer c where c.email=?1")
    String fetchNameAndGenderByEmail(String email);

    @Query(
            value="Select * from Customer c where c.name=?1 and c.gender=?2",
            nativeQuery = true
          )
    List<Customer> fetchName(String name, String gen);

    @Query(
            value="Select * from Customer c where c.name=:name and c.gender=:gen",
            nativeQuery = true
    )
    List<Customer> fetchNameNamedParam(@Param("name") String name, @Param("gen") String gen);

    @Modifying
    @Transactional
    @Query(value = "update Customer set name = ?1 where email = ?2")
    void updateUserNameByEmailAddress(String firstName, String email);

    @Query("SELECT c.name, p.productName FROM Customer c JOIN c.productList p")
    List<String> getInformation();

}





