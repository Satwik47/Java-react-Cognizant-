import java.util.HashMap;

public class InventoryManagement {
    private HashMap<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }


    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully.");
    }

    public void updateProduct(int productId,
                              String newName,
                              int newQuantity,
                              double newPrice) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.setProductName(newName);
            p.setQuantity(newQuantity);
            p.setPrice(newPrice);
            System.out.println("Product Updated Successfully.");
        }
        else {
            System.out.println("Product Not Found.");
        }
    }

   
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product Deleted Successfully.");
        }
        else {
            System.out.println("Product Not Found.");
        }
    }

 
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }
        System.out.println("\nCurrent Inventory:");
        for(Product p : inventory.values()) {
            System.out.println(p);
        }
    }

        public static void main(String[] args) {
        InventoryManagement ims =
                new InventoryManagement();
        Product p1 =
                new Product(101,
                            "Laptop",
                            20,
                            55000);
        Product p2 =
                new Product(102,
                            "Mouse",
                            100,
                            500);
        Product p3 =
                new Product(103,
                            "Keyboard",
                            50,
                            1200);

        
        System.out.println("ADDING PRODUCTS");
        ims.addProduct(p1);
        ims.addProduct(p2);
        ims.addProduct(p3);
        ims.displayInventory();

        System.out.println("\nUPDATING PRODUCT");
        ims.updateProduct(
                102,
                "Wireless Mouse",
                80,
                750);
        ims.displayInventory();

      
        System.out.println("\nDELETING PRODUCT");
        ims.deleteProduct(103);
        ims.displayInventory();
    }
}
