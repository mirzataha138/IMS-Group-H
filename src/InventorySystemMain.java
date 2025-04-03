// Main Modlue for User Interactions

import java.util.*;
public class InventorySystemMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuth userAuth = new UserAuth();
        AddProduct addProduct = new AddProduct();
        SellProduct sellProduct = new SellProduct();
        ViewProducts viewProducts = new ViewProducts();
        SearchProduct searchProduct = new SearchProduct();
        LowStockProducts Lowcheck = new LowStockProducts();
        EditProduct editProduct = new EditProduct();
        ProductSuggestion productSuggestion = new ProductSuggestion();
        ReportGenerator reportGenerator = new ReportGenerator();

        boolean isAuthenticated = false;

        while (!isAuthenticated) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Enter choice: ");
            int authChoice;

            try {
                authChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
                continue;
            }

            switch (authChoice) {
                case 1:
                    System.out.print("Enter Username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String newPassword = scanner.nextLine();
                    userAuth.registerUser(newUsername, newPassword);
                    break;

                case 2:
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    isAuthenticated = userAuth.loginUser(username, password);
                    if (isAuthenticated) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed! Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Error: Invalid choice! Please select a valid option.");
            }
        }

        while (isAuthenticated) {
            System.out.println("\n1. Add Product\n2. Sell Product\n3. View Products\n4. Search Product\n5. List of Low Quantity Products  \n6. Edit Product Info\n7. Reports \n8. Logout");
            System.out.print("Enter choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    addProduct.addProduct(name, quantity, price);
                    break;

                case 2:
                System.out.print("Start typing product name: ");
                String input = scanner.nextLine();
                productSuggestion.suggestProducts(input);
                    System.out.print("Enter Product Name to Sell: ");
                    String sellName = scanner.nextLine();
                    System.out.print("Enter Quantity to Sell: ");
                    int sellQuantity = Integer.parseInt(scanner.nextLine());
                    sellProduct.sellProduct(sellName, sellQuantity);
                    break;

                case 3:
                    viewProducts.viewProducts();
                    break;

                case 4:
                System.out.print("Start typing product name: ");
                String input1 = scanner.nextLine();
                productSuggestion.suggestProducts(input1);
                    System.out.print("Enter Product Name to Search: ");
                    String searchName = scanner.nextLine();
                    searchProduct.searchProduct(searchName);
                    break;
                    case 5:
                    Lowcheck.listLowStockProducts();
                    break;
                case 6:
                System.out.print("Start typing product name: ");
                String input2 = scanner.nextLine();
                productSuggestion.suggestProducts(input2);
                System.out.print("Enter Product Name to Edit: ");
                String editName = scanner.nextLine();
                System.out.print("Enter New Quantity: ");
                int newQuantity = scanner.nextInt();
                System.out.print("Enter New Price: ");
                double newPrice = scanner.nextDouble();
                editProduct.editProduct(editName, newQuantity, newPrice);
                break;     
                case 7:
                reportGenerator.generateStockReport();
                reportGenerator.generateLowStockReport();
                reportGenerator.generateSalesReport();
                   
                break; 
                case 8:
                    System.out.println("Logging out...");
                    isAuthenticated = false;
                    break;

                default:
                    System.out.println("Error: Invalid choice! Please select a valid option.");
            }

          
        }
    }
}