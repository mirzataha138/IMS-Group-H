import java.io.*;

class SearchProduct {
    private static final String FILE_NAME = "products.txt";

    public void searchProduct(String name) {
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                if (productDetails[0].equalsIgnoreCase(name)) {
                    System.out.println("\nProduct Found:");
                    System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2] + " Rupees");
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }

        if (!found) {
            System.out.println("Error: Product not found!");
        }
    }
}
