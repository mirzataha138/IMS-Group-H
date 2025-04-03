import java.io.*;

class ViewProducts {
    private static final String FILE_NAME = "products.txt";

    public void viewProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- Product List ---");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2] + " Rupees");
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }
    }
}
