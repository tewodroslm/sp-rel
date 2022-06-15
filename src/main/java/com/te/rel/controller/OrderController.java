package com.te.rel.controller;

import com.te.rel.dto.OrderRequest;
import com.te.rel.entities.Customer;
import com.te.rel.repository.CustomerRepository;
import com.te.rel.repository.ProductRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class OrderController {

    private final Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest){
        logger.info("request is ");
        logger.info(orderRequest.getCustomer().toString());
        return customerRepository.save(orderRequest.getCustomer());
    }

    @GetMapping("/findAllOrder")
    public List<Customer> findOrders() {
        return customerRepository.findAll();
    }

    @GetMapping("/getByGen/{gen}")
    public List<Customer> findByGender(@PathVariable String gen) {
        return customerRepository.findByGender(gen);
    }

    @GetMapping("/getByemail/{email}")
    public String getName(@PathVariable String email){
        return customerRepository.getFirstNameByEmail(email);
    }

    @GetMapping("/getByEmailContaining/{email}")
    public List<Customer> getByEm(@PathVariable String email){
        return customerRepository.findByEmailContaining(email);
    }

    @GetMapping("/getNameGen/{email}")
    public String getNameAndGender(@PathVariable String email){
        return customerRepository.fetchNameAndGenderByEmail(email);
    }

    @GetMapping("/getCus/{name}/{gen}")
    public List<Customer> getCustomer(@PathVariable String name, @PathVariable String gen){
        logger.info("Name: " + name);
        logger.info("Gender: " + gen);
        return customerRepository.fetchName(name, gen);
    }

    @GetMapping("/getCusNamedParam/{name}/{gen}")
    public List<Customer> getCustomerNamedParam(@PathVariable String name, @PathVariable String gen){
        return customerRepository.fetchNameNamedParam(name, gen);
    }

    @GetMapping("/updateName/{name}/{email}")
    public void updateName(@PathVariable String name, @PathVariable String email){
        customerRepository.updateUserNameByEmailAddress(name, email);
    }

    @GetMapping("/getCnameProductName")
    public List<String> getCnamePname(){
        return customerRepository.getInformation();
    }

    @GetMapping("/getCustomerByPname/{pName}")
    public Customer getCustomer(@PathVariable String pName){
        logger.info(pName);
        Customer x = productRepository.getCustomerByProd(pName);
        logger.info(x.toString());
        return x;
    }


}


/**
 * Test data when post new customer with product
 * {
 *     "customer": {
 *         "name": "cus-two",
 *         "email": "two@gmail.com",
 *         "gender": "female",
 *         "productList": [
 *             {
 *                 "productId": 14,
 *                 "productName": "house",
 *                 "qty": 1,
 *                 "price": 1000000
 *             },
 *             {
 *                 "productId": 15,
 *                 "productName": "plane",
 *                 "qty": 1,
 *                 "price": 400000
 *             }
 *         ]
 *     }
 * }
 */