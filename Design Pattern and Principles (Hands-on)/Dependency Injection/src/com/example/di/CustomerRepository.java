package com.example.di;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
}
