package com.example.di;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("---- Dependency Injection Demo ----");

        // Manual constructor injection
        CustomerRepository repo = new InMemoryCustomerRepository();
        CustomerService service = new CustomerService(repo);

        // Use service
        service.registerCustomer(new Customer(1, "Alice"));
        service.registerCustomer(new Customer(2, "Bob"));

        Customer c = service.getCustomer(1);
        System.out.println("Main: Retrieved " + c);

        List<Customer> all = service.listCustomers();
        System.out.println("Main: All customers: " + all);
    }
}
