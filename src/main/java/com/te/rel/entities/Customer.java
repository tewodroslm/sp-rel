package com.te.rel.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int customerId;
    private String name;
    private String email;
    private String gender;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    private List<Product> productList;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}