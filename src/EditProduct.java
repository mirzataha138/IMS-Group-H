import java.io.*;

class EditProduct {
    private static final String FILE_NAME = "products.txt";

    public void editProduct(String name, int newQuantity, double newPrice) {
        boolean productFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                if (productDetails.length == 3 && productDetails[0].equalsIgnoreCase(name)) {
                    System.out.println("Updating product: " + name);
                    line = name + "," + newQuantity + "," + newPrice;
                    productFound = true;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
            return;
        }

        if (!productFound) {
            System.out.println("Error: Product not found!");
        } else {
            new File(FILE_NAME).delete();
            new File("temp.txt").renameTo(new File(FILE_NAME));
            System.out.println("Product details updated successfully!");
        }
    }
}
