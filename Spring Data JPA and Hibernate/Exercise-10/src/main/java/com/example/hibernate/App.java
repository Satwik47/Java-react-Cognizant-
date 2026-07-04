package com.example.hibernate;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileWriter("output.txt", false))) {
            out.println("Starting Employee Management System - Hibernate Specific Features");
            System.out.println("Starting Employee Management System - Hibernate Specific Features");

            int total = 25;
            int batchSize = 10;

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            out.println("Inserting " + total + " employees in batches of " + batchSize + "...");
            System.out.println("Inserting " + total + " employees in batches of " + batchSize + "...");

            for (int i = 1; i <= total; i++) {
                Employee e = new Employee("Emp " + i, "Dept " + ((i % 5) + 1), 50000 + i * 1000);
                session.save(e);
                if (i % batchSize == 0) {
                    session.flush();
                    session.clear();
                    out.println("Flushed and cleared after " + i + " inserts");
                    System.out.println("Flushed and cleared after " + i + " inserts");
                }
            }

            tx.commit();

            out.println("Inserted " + total + " employees.");
            System.out.println("Inserted " + total + " employees.");

            // Update one employee
            tx = session.beginTransaction();
            Employee first = session.get(Employee.class, 1L);
            if (first != null) {
                first.setSalary(75000.0);
                session.update(first);
                out.println("Updated salary for Employee id=1 to " + first.getSalary());
                System.out.println("Updated salary for Employee id=1 to " + first.getSalary());
            }
            tx.commit();

            // Query all
            out.println("All employees:");
            System.out.println("All employees:");
            List<Employee> list = session.createQuery("from Employee", Employee.class).list();
            for (Employee e : list) {
                out.println(e.toString());
                System.out.println(e.toString());
            }

            // Delete one
            tx = session.beginTransaction();
            Employee toDelete = session.get(Employee.class, 2L);
            if (toDelete != null) {
                session.delete(toDelete);
                out.println("Deleted employee id=2");
                System.out.println("Deleted employee id=2");
            }
            tx.commit();

            session.close();
            HibernateUtil.shutdown();

            out.println("Completed.");
            System.out.println("Completed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
