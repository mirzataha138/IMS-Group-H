import java.io.*;

class SellProduct {
    private static final String FILE_NAME = "products.txt";

    public void sellProduct(String name, int sellQuantity) {
        boolean productFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] productDetails = line.split(",");
                if (productDetails.length == 3 && productDetails[0].equalsIgnoreCase(name)) {
                    int currentQuantity = Integer.parseInt(productDetails[1]);
                    double price = Double.parseDouble(productDetails[2]);

                    if (currentQuantity >= sellQuantity) {
                        currentQuantity -= sellQuantity;
                        System.out.println(sellQuantity + " " + name + "(s) sold! Remaining: " + currentQuantity);
                        line = name + "," + currentQuantity + "," + price;
                    } else {
                        System.out.println("Error: Not enough stock available!");
                        writer.write(line);
                        writer.newLine();
                        continue;
                    }
                    productFound = true;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to process product data.");
            return;
        }

        if (!productFound) {
            System.out.println("Error: Product not found!");
        } else {
            new File(FILE_NAME).delete();
            new File("temp.txt").renameTo(new File(FILE_NAME));
        }
    }
}
