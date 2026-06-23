public class LibrarySearch {
    // Linear Search
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(targetTitle);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Sorted Array by Title
        Book[] books = {
            new Book(101, "C++", "Bjarne Stroustrup"),
            new Book(102, "Data Structures", "Seymour Lipschutz"),
            new Book(103, "Java", "Herbert Schildt"),
            new Book(104, "Python", "Mark Lutz"),
            new Book(105, "Web Technology", "Deitel")
        };
        String searchTitle = "Java";

        // Linear Search
        System.out.println("LINEAR SEARCH");
        Book result1 = linearSearch(books, searchTitle);
        if (result1 != null) {
            System.out.println("Book Found:");
            System.out.println(result1);
        } else {
            System.out.println("Book Not Found.");
        }

        // Binary Search
        System.out.println("\nBINARY SEARCH");
        Book result2 = binarySearch(books, searchTitle);
        if (result2 != null) {
            System.out.println("Book Found:");
            System.out.println(result2);
        } else {
            System.out.println("Book Not Found.");
        }

        // Recommendation
        System.out.println("\nRECOMMENDATION");
        if (isSorted(books)) {
            System.out.println("Recommended Search: Binary Search - faster for sorted data (O(log n)).");
        } else {
            System.out.println("Recommended Search: Linear Search - works on unsorted data (O(n)).");
        }
    }

    // Check if the array is sorted by title (case-insensitive)
    public static boolean isSorted(Book[] books) {
        for (int i = 1; i < books.length; i++) {
            if (books[i - 1].title.compareToIgnoreCase(books[i].title) > 0) {
                return false;
            }
        }
        return true;
    }
}
