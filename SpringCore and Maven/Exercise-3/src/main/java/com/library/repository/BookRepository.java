package com.library.repository;

public class BookRepository {
    public void saveBook() {
        System.out.println("Saving Book into Database...");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println("Book Saved Successfully");
    }
}
