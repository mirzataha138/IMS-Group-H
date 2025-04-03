import java.io.*;

class AddProduct {
    private static final String FILE_NAME = "products.txt";

    public void addProduct(String name, int quantity, double price) {
        if (name.isEmpty() || quantity <= 0 || price <= 0) {
            System.out.println("Error: Invalid product details!");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(name + "," + quantity + "," + price);
            writer.newLine();
            System.out.println("Product added successfully!");
        } catch (IOException e) {
            System.out.println("Error: Unable to save product data.");
        }
    }
}
