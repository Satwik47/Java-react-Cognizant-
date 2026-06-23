package com.example.di;

import java.util.List;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
        System.out.println("Service: constructed with repository " + repository.getClass().getSimpleName());
    }

    public void registerCustomer(Customer c) {
        System.out.println("Service: registering customer " + c);
        repository.save(c);
    }

    public Customer getCustomer(int id) {
        System.out.println("Service: retrieving customer " + id);
        return repository.findById(id);
    }

    public List<Customer> listCustomers() {
        System.out.println("Service: listing customers");
        return repository.findAll();
    }
}
