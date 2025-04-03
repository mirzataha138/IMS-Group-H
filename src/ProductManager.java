// // // Module for Product Managenment
// //  import java.io.*;
// //  import java.util.*;



// // class ProductManager {
// //     private static final String FILE_NAME = "products.txt";

// //     public void addProduct(String name, int quantity, double price) {
// //         try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
// //             if (name.isEmpty() || quantity <= 0 || price <= 0) {
// //                 throw new IllegalArgumentException("Invalid product details!");
// //             }
// //             writer.write(name + "," + quantity + "," + price);
// //             writer.newLine();
// //             System.out.println("Product added successfully!");
// //         } catch (IOException e) {
// //             System.out.println("Error: Unable to save product data.");
// //         } catch (IllegalArgumentException e) {
// //             System.out.println("Error: " + e.getMessage());
// //         }
// //     }

// //     public void sellProduct(String name, int sellQuantity) {
// //         List<String> updatedProducts = new ArrayList<>();
// //         boolean productFound = false;

// //         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
// //             String line;
// //             while ((line = reader.readLine()) != null) {
// //                 String[] productDetails = line.split(",");
// //                 if (productDetails.length == 3 && productDetails[0].equalsIgnoreCase(name)) {
// //                     int currentQuantity = Integer.parseInt(productDetails[1]);
// //                     double price = Double.parseDouble(productDetails[2]);

// //                     if (currentQuantity >= sellQuantity) {
// //                         currentQuantity -= sellQuantity;
// //                         System.out.println(sellQuantity + " " + name + "(s) sold! Remaining: " + currentQuantity);
// //                     } else {
// //                         throw new IllegalArgumentException("Not enough stock available!");
// //                     }

// //                     updatedProducts.add(name + "," + currentQuantity + "," + price);
// //                     productFound = true;
// //                 } else {
// //                     updatedProducts.add(line);
// //                 }
// //             }
// //         } catch (IOException e) {
// //             System.out.println("Error: Unable to read product data.");
// //             return;
// //         } catch (NumberFormatException e) {
// //             System.out.println("Error: Invalid data format in file.");
// //             return;
// //         } catch (IllegalArgumentException e) {
// //             System.out.println("Error: " + e.getMessage());
// //             return;
// //         }

// //         if (!productFound) {
// //             System.out.println("Error: Product not found!");
// //             return;
// //         }

// //         try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
// //             for (String product : updatedProducts) {
// //                 writer.write(product);
// //                 writer.newLine();
// //             }
// //         } catch (IOException e) {
// //             System.out.println("Error: Unable to update product data.");
// //         }
// //     }

// //     public void viewProducts() {
// //         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
// //             String line;
// //             System.out.println("\n--- Product List ---");
// //             while ((line = reader.readLine()) != null) {
// //                 String[] productDetails = line.split(",");
// //                 System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2]+" Rupees");
// //             }
// //         } catch (IOException e) {
// //             System.out.println("Error: Unable to read product data.");
// //         }
// //     }

// //     public void searchProduct(String name) {
// //         boolean found = false;
// //         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
// //             String line;
// //             while ((line = reader.readLine()) != null) {
// //                 String[] productDetails = line.split(",");
// //                 if (productDetails.length == 3 && productDetails[0].equalsIgnoreCase(name)) {
// //                     System.out.println("\nProduct Found:");
// //                     System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2]+" Rupees");
// //                     found = true;
// //                     break;
// //                 }
// //             }
// //         } catch (IOException e) {
// //             System.out.println("Error: Unable to read product data.");
// //         }

// //         if (!found) {
// //             System.out.println("Error: Product not found!");
// //         }
// //     }
// // }

// import java.io.*;

// class ProductManager {
//     private static final String FILE_NAME = "products.txt";

//     public void addProduct(String name, int quantity, double price) {
//         if (name.isEmpty() || quantity <= 0 || price <= 0) {
//             System.out.println("Error: Invalid product details!");
//             return;
//         }
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
//             writer.write(name + "," + quantity + "," + price);
//             writer.newLine();
//             System.out.println("Product added successfully!");
//         } catch (IOException e) {
//             System.out.println("Error: Unable to save product data.");
//         }
//     }

//     public void sellProduct(String name, int sellQuantity) {
//         boolean productFound = false;
//         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
//              BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {

//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] productDetails = line.split(",");
//                 if (productDetails.length == 3 && productDetails[0].equalsIgnoreCase(name)) {
//                     int currentQuantity = Integer.parseInt(productDetails[1]);
//                     double price = Double.parseDouble(productDetails[2]);

//                     if (currentQuantity >= sellQuantity) {
//                         currentQuantity -= sellQuantity;
//                         System.out.println(sellQuantity + " " + name + "(s) sold! Remaining: " + currentQuantity);
//                         line = name + "," + currentQuantity + "," + price;
//                     } else {
//                         System.out.println("Error: Not enough stock available!");
//                         writer.write(line);
//                         writer.newLine();
//                         continue;
//                     }
//                     productFound = true;
//                 }
//                 writer.write(line);
//                 writer.newLine();
//             }
//         } catch (IOException e) {
//             System.out.println("Error: Unable to process product data.");
//             return;
//         }

//         if (!productFound) {
//             System.out.println("Error: Product not found!");
//         } else {
//             new File(FILE_NAME).delete();
//             new File("temp.txt").renameTo(new File(FILE_NAME));
//         }
//     }

//     public void viewProducts() {
//         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//             System.out.println("\n--- Product List ---");
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] productDetails = line.split(",");
//                 System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2] + " Rupees");
//             }
//         } catch (IOException e) {
//             System.out.println("Error: Unable to read product data.");
//         }
//     }

//     public void searchProduct(String name) {
//         boolean found = false;
//         try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] productDetails = line.split(",");
//                 if (productDetails[0].equalsIgnoreCase(name)) {
//                     System.out.println("\nProduct Found:");
//                     System.out.println("Name: " + productDetails[0] + ", Quantity: " + productDetails[1] + ", Price: " + productDetails[2] + " Rupees");
//                     found = true;
//                     break;
//                 }
//             }
//         } catch (IOException e) {
//             System.out.println("Error: Unable to read product data.");
//         }

//         if (!found) {
//             System.out.println("Error: Product not found!");
//         }
//     }
// }
