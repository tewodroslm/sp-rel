package com.te.rel.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.te.rel.entities.Product;

import javax.persistence.*;
import java.util.List;

public class CustomerProductResponse {

    private String name;
    private String email;
    private String gender;

    public CustomerProductResponse(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
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
}
