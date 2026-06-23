package com.example.di;

import java.util.*;

public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<Integer, Customer> store = new HashMap<>();

    @Override
    public void save(Customer customer) {
        store.put(customer.getId(), customer);
        System.out.println("Repository: saved " + customer);
    }

    @Override
    public Customer findById(int id) {
        System.out.println("Repository: findById " + id);
        return store.get(id);
    }

    @Override
    public List<Customer> findAll() {
        System.out.println("Repository: findAll");
        return new ArrayList<>(store.values());
    }
}
