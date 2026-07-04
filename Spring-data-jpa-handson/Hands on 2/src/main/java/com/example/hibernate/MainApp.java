package com.example.hibernate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure(); // looks for hibernate.cfg.xml in classpath

        try (SessionFactory factory = cfg.buildSessionFactory()) {
            StringBuilder out = new StringBuilder();

            // CREATE
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Employee e1 = new Employee("Paul", "Wall", 3000);
                Employee e2 = new Employee("Allen", "Wong", 3500);
                Integer id1 = (Integer) session.save(e1);
                Integer id2 = (Integer) session.save(e2);
                tx.commit();
                System.out.println("Saved Employee IDs: " + id1 + ", " + id2);
                out.append("Saved Employee IDs: ").append(id1).append(", ").append(id2).append("\n");
            }

            // READ
            try (Session session = factory.openSession()) {
                List<Employee> list = session.createQuery("from Employee", Employee.class).list();
                System.out.println("Employees (after insert):");
                out.append("Employees (after insert):\n");
                for (Employee e : list) {
                    System.out.println(e);
                    out.append(e.toString()).append("\n");
                }
            }

            // UPDATE
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Employee e = session.get(Employee.class, 1);
                if (e != null) {
                    e.setSalary(4000);
                    session.update(e);
                    System.out.println("Updated employee id=1 salary=4000");
                    out.append("Updated employee id=1 salary=4000\n");
                }
                tx.commit();
            }

            // DELETE
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Employee e = session.get(Employee.class, 2);
                if (e != null) {
                    session.delete(e);
                    System.out.println("Deleted employee id=2");
                    out.append("Deleted employee id=2\n");
                }
                tx.commit();
            }

            // FINAL READ
            try (Session session = factory.openSession()) {
                List<Employee> list = session.createQuery("from Employee", Employee.class).list();
                System.out.println("Employees (final):");
                out.append("Employees (final):\n");
                for (Employee e : list) {
                    System.out.println(e);
                    out.append(e.toString()).append("\n");
                }
            }

            // write output to file
            try (FileWriter fw = new FileWriter("output.txt")) {
                fw.write(out.toString());
            } catch (IOException ex) {
                System.err.println("Failed to write output.txt: " + ex.getMessage());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
