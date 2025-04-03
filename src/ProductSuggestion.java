import java.io.*;


class ProductSuggestion {
    private static final String FILE_NAME = "products.txt";

    public void suggestProducts(String input) {
        if (input.isEmpty()) return;

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String productName = line.split(",")[0]; // Extract product name
                if (productName.toLowerCase().startsWith(input.toLowerCase())) {
                    System.out.println("Suggestion: " + productName);
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to read product data.");
        }

        if (!found) {
            System.out.println("No suggestions found.");
        }
    }
}
