import java.io.*;

class LowStockProducts {
    private static final String FILE_NAME = "products.txt";

    public void listLowStockProducts() {
        boolean foundLowStock = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- Low Stock Products (Less than 10) ---");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                if (productDetails.length == 3) {
                    int quantity = Integer.parseInt(productDetails[1]);
                    if (quantity < 10) {
                        System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2] + " Rupees");
                        foundLowStock = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }

        if (!foundLowStock) {
            System.out.println("No products are low in stock.");
        }
    }
}
