package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        int employeeId;

        // Create operation
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = new Employee("John", "Doe", "john.doe@example.com");
            session.persist(employee);
            transaction.commit();
            employeeId = employee.getId();
            System.out.println("Saved employee: " + employee);
        }

        // Read operation
        try (Session session = sessionFactory.openSession()) {
            Employee employee = session.get(Employee.class, employeeId);
            System.out.println("Read employee: " + employee);
        }

        // Update operation
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                employee.setLastName("Smith");
                session.update(employee);
                transaction.commit();
                System.out.println("Updated employee: " + employee);
            }
        }

        // Delete operation
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                System.out.println("Deleted employee with id: " + employeeId);
            }
        }

        HibernateUtil.shutdown();
    }
}
