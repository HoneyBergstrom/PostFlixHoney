import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private static LoginManager instance;
    private List<User> users;

    private LoginManager() {
        users = new ArrayList<>();
        readUsersFromFile();
    }

    private void readUsersFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/users"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals("user")) {
                    
                    String[] addressParts = parts[3].split(";");
                    Address address = new Address(addressParts[0],
                            Integer.parseInt(addressParts[1]), addressParts[2],
                            Integer.parseInt(addressParts[3]), addressParts[4]);
                    
                    this.users.add(new Customer(parts[1], parts[2], address));
                } else if (parts[0].equals("admin")) {
                    this.users.add(new Admin(parts[1], parts[2]));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static LoginManager getInstance() {
        if (instance == null) {
            instance = new LoginManager();
        }
        return instance;
    }

    public User authenticated(String username, String password) {
        System.out.println(users.size());
        for (User user : users) {
            System.out.println("Username: " + user.getName());
            System.out.println("Password: " + user.getPassword());
        }
        for (User user : users) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Returning user");
                return user;
            }
        }
        System.out.println("Returning null");
        return null;
    }

    public boolean registerUser(String username, String password, Address address) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/users", true))) {
            bufferedWriter.write("user," + username + "," + password + "," + address.getStreet()
                    + ";" + address.getPostalCode() + ";" + address.getCity() + ";" + address.getDoorCode() + ";" + address.getPhoneNumber()
                    + "\n");

            users.add(new Customer(username, password, address));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean checkUsernameAvailability(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
