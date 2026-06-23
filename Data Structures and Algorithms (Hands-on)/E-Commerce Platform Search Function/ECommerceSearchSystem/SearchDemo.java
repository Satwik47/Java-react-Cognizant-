public class SearchDemo {
    static class SearchResult {
        Product product;
        int comparisons;
        SearchResult(Product product, int comparisons) {
            this.product = product;
            this.comparisons = comparisons;
        }
    }

    // Linear Search (returns product and comparison count)
    public static SearchResult linearSearch(Product[] products,
                                           int targetId) {
        int comps = 0;
        for (Product p : products) {
            comps++;
            if (p.productId == targetId) {
                return new SearchResult(p, comps);
            }
        }
        return new SearchResult(null, comps);
    }

    // Binary Search (returns product and comparison count)
    public static SearchResult binarySearch(Product[] products,
                                           int targetId) {
        int low = 0;
        int high = products.length - 1;
        int comps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            comps++;
            if (products[mid].productId == targetId) {
                return new SearchResult(products[mid], comps);
            }
            else if (products[mid].productId < targetId) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return new SearchResult(null, comps);
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(103, "Keyboard", "Electronics"),
            new Product(104, "Monitor", "Electronics"),
            new Product(105, "Printer", "Electronics")
        };
        int searchId = 104;
        System.out.println("LINEAR SEARCH");
        SearchResult sr1 = linearSearch(products, searchId);
        if (sr1.product != null) {
            System.out.println("Product Found:");
            System.out.println(sr1.product);
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println("Comparisons (Linear): " + sr1.comparisons);

        System.out.println("\nBINARY SEARCH");
        SearchResult sr2 = binarySearch(products, searchId);
        if (sr2.product != null) {
            System.out.println("Product Found:");
            System.out.println(sr2.product);
        } else {
            System.out.println("Product Not Found");
        }
        System.out.println("Comparisons (Binary): " + sr2.comparisons);

        System.out.println("\nBEST ALGORITHM:");
        if (sr1.product == null && sr2.product == null) {
            System.out.println("Neither algorithm found the product.");
        } else if (sr1.comparisons < sr2.comparisons) {
            System.out.println("Linear Search (fewer comparisons)");
        } else if (sr2.comparisons < sr1.comparisons) {
            System.out.println("Binary Search (fewer comparisons)");
        } else {
            System.out.println("Both algorithms performed equally (same comparisons)");
        }
    }
}
