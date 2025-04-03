import java.io.*;


class ReportGenerator {
    private static final String FILE_NAME = "products.txt";

    // Generate a full stock report
    public void generateStockReport() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- Stock Report ---");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                System.out.println("Product: " + productDetails[0] + " | Quantity: " + productDetails[1] + " | Price: " + productDetails[2] + " Rupees");
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }
    }

    // Generate a report for low stock products
    public void generateLowStockReport() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            System.out.println("\n--- Low Stock Report (Less than 10) ---");
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                int quantity = Integer.parseInt(productDetails[1]);
                if (quantity < 10) {
                    System.out.println("Product: " + productDetails[0] + " | Quantity: " + quantity);
                    found = true;
                }
            }
            if (!found) System.out.println("All products have sufficient stock.");
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }
    }

    // Generate a sales report (Example: Reads from "sales.txt")
    public void generateSalesReport() {
        File salesFile = new File("sales.txt");
        if (!salesFile.exists()) {
            System.out.println("\nNo sales data found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("sales.txt"))) {
            System.out.println("\n--- Sales Report ---");
            String line;
            double totalRevenue = 0;
            while ((line = reader.readLine()) != null) {
                String[] salesDetails = line.split(",");
                String productName = salesDetails[0];
                int quantitySold = Integer.parseInt(salesDetails[1]);
                double totalPrice = Double.parseDouble(salesDetails[2]);
                System.out.println("Product: " + productName + " | Quantity Sold: " + quantitySold + " | Revenue: " + totalPrice + " Rupees");
                totalRevenue += totalPrice;
            }
            System.out.println("\nTotal Revenue: " + totalRevenue + " Rupees");
        } catch (IOException e) {
            System.out.println("Error: Unable to read sales data.");
        }
    }
}
