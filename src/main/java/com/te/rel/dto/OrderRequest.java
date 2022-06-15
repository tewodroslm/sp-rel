package com.te.rel.dto;

import com.te.rel.entities.Customer;

public class OrderRequest {
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
