// Module for User Registration/Login
import java.io.*;
class UserAuth {
    private static final String FILE_NAME = "users.txt";

    public void registerUser(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username or Password cannot be empty!");
            }
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("Error: Unable to save user data.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean loginUser(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials.length == 2 && credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
            throw new SecurityException("Invalid Username or Password!");
        } catch (IOException e) {
            System.out.println("Error: Unable to read user data.");
        } catch (SecurityException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
