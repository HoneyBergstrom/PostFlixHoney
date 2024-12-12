import java.util.Scanner;

public class PostFlix {
    private ContentManager contentManager;
    private LoginManager loginManager;

    public static void main(String[] args) {
        new PostFlix();
    }

    public PostFlix() {
        contentManager = ContentManager.getInstance();
        loginManager = LoginManager.getInstance();
        run();
    }


    private void run() {

        for (Content content : contentManager.getInventory()) {
            System.out.println(content.getContentID());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   WELCOME TO POSTFLIX! ");
        System.out.println("========================================\n");

        System.out.print("Do you want to (1) Register or (2) Login? Enter 1 or 2: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String username = "";
        String password = "";

        if (choice == 1) {
            boolean registrationSuccess = false;
            while (!registrationSuccess) {
                System.out.println("\n--- Registration ---");
                System.out.print("Enter a username: ");
                username = scanner.nextLine();
                System.out.print("Enter a password: ");
                password = scanner.nextLine();
                if (loginManager.checkUsernameAvailability(username)) {
                    String street, postalCode, city, doorCode, phoneNumber;

                    //TODO Validate inputs
                    System.out.print("Enter your street address: ");
                    street = scanner.nextLine();

                    System.out.print("Enter your postal code: ");
                    postalCode = scanner.nextLine();

                    System.out.print("Enter your city: ");
                    city = scanner.nextLine();

                    System.out.print("Enter your door code: ");
                    doorCode = scanner.nextLine();

                    System.out.print("Enter your phone number: ");
                    phoneNumber = scanner.nextLine();

                    Address address = new Address(street, Integer.parseInt(postalCode), city, Integer.parseInt(doorCode), phoneNumber);

                    if (loginManager.registerUser(username, password, address)) {
                        System.out.println("Registration successful! Please login now.");
                        registrationSuccess = true;
                    }
                } else {
                    System.out.println("Registration failed! Username may already exist.");
                }
            }
        }

        if (choice == 2 || choice == 1) {
            if (username.isEmpty()) {
                System.out.print("Please enter your username: ");
                username = scanner.nextLine();
            }
            System.out.print("Please enter your password: ");
            password = scanner.nextLine();

        }

        User user = loginManager.authenticated(username, password);

        if (user != null) {
            System.out.println("\n========================================");
            System.out.println("  LOGIN SUCCESSFUL! WELCOME, " + username.toUpperCase() + "!");
            System.out.println("========================================\n");
        } else {
            System.out.println("\n========================================");
            System.out.println("      LOGIN FAILED! INVALID CREDENTIALS.");
            System.out.println("========================================\n");
        }


        //Test user
        

        String userCommand = "";
        System.out.println(userCommand);
        while (true) {
            displayCommands(user);
            userCommand = scanner.nextLine();
            System.out.println(userCommand);
            switch (userCommand.toLowerCase()) {
                case "borrow":
                    System.out.println("You chose to borrow content. Input Content ID  to borrow");
                    int contentIDToBorrow = scanner.nextInt();
                    scanner.nextLine();
                    contentManager.borrowContent(contentIDToBorrow, (Customer) user);

                    System.out.println("Borrwing book");

                    break;
                case "return":
                    System.out.println("You chose to return content. Input Content ID  to return");
                    int contentIDToReturn = scanner.nextInt();
                    scanner.nextLine();
                    
                    contentManager.processReturn(contentIDToReturn, (Customer) user);
    
                    break;
                case "list":
                    System.out.println("Displaying all available content...");
                    for (Content content : contentManager.getInventory()) {
                        System.out.println(content.toString());
                    }
                    break;

                case "searchbyfilm":
                    System.out.println("Enter the film title to search: ");

                    String filmTitle = scanner.nextLine();
                    System.out.println("Searching for film: " + filmTitle);

                    searchByTitle(filmTitle);
                    break;

                case "searchbygenre":
                    System.out.println("Enter the genre to search: ");

                    String genre = scanner.nextLine();
                    System.out.println("Listing all content in the genre: " + genre);

                    searchByGenre(genre);
                    break;

                case "manageuser":
                    System.out.println("Managing users...");
// Add user management logic here
                    break;

                case "trackorder":
                    System.out.println("Tracking orders...");
// Add order tracking logic here
                    break;

                case "updatecontent":
                    if (user instanceof Admin) {
                        ((Admin) user).updateContent(scanner);
                    } else {
                        System.out.println("Not admin");
                    }

                    break;
                case "commands":

                    displayCommands(user);

                default:
                    System.out.println("Invalid command! Please try again.");
                    break;
            }
        }
    }

    private void displayCommands(User user) {
        if (user == null) {
            System.out.println("Error: No user logged in");
            return;
        }
        if (user instanceof Customer) {
            System.out.println("========================================");
            System.out.println("           COMMAND LISTING");
            System.out.println("========================================");
            System.out.println("Borrow          - To borrow content.");
            System.out.println("Return          - To return borrowed content.");
            System.out.println("TrackOrder      - To track orders by ID.");
            System.out.println("List            - See all available content.");
            System.out.println("SearchByFilm  - Search for a specific film by its title.");
            System.out.println("SearchByGenre - List all content within a specific genre.");
            System.out.println("Commands       - List all commands");
            System.out.println("========================================");
        } else {
            System.out.println("========================================");
            System.out.println("          ADMIN COMMAND LISTING");
            System.out.println("========================================");
            System.out.println("ManageUser      - To manage users.");
            System.out.println("TrackOrder      - To track orders by ID.");
            System.out.println("UpdateContent   - To update content.");
            System.out.println("Commands       - List all commands");
            System.out.println("========================================");
        }
    }

    private void searchByGenre(String genre) {
        boolean found = false;
        for (Content content : contentManager.getInventory()) {
            if (content.getGenres().contains(genre)) {
                System.out.println("- " + content.getTitle());
                found = true;
            }

            if (!found) {
                System.out.println("No movies found in the genre " + genre);
            }
        }

    }

    private void searchByTitle(String filmTitle) {
        for (Content content : contentManager.getInventory()) {
            if (content.getTitle().equalsIgnoreCase(filmTitle)) {
                System.out.println(content);
                return;
            }
        }
        System.out.println("No movie with the title '" + filmTitle + "' was found.");
    }
}
