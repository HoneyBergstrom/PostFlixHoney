import java.util.List;
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

                    while (true) {
                        System.out.print("Enter your street address: ");
                        street = scanner.nextLine();
                        if (!street.isEmpty()) break;
                        System.out.println("Street address cannot be empty.");
                    }

                    while (true) {
                        System.out.print("Enter your postal code (5 digits): ");
                        postalCode = scanner.nextLine();
                        if (postalCode.matches("\\d{5}")) break;
                        System.out.println("Postal code must be exactly 5 digits.");
                    }

                    while (true) {
                        System.out.print("Enter your city: ");
                        city = scanner.nextLine();
                        if (!city.isEmpty()) break;
                        System.out.println("City cannot be empty.");
                    }

                    while (true) {
                        System.out.print("Enter your door code (numeric): ");
                        doorCode = scanner.nextLine();
                        if (doorCode.matches("\\d+")) break;
                        System.out.println("Door code must be numeric.");
                    }

                    while (true) {
                        System.out.print("Enter your phone number (10 digits): ");
                        phoneNumber = scanner.nextLine();
                        if (phoneNumber.matches("\\d{10}")) break;
                        System.out.println("Phone number must be exactly 10 digits.");
                    }

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

                    for (String category : contentManager.getCategories()) {
                        System.out.println(category);
                    }

                    System.out.println("Enter the genre to search: ");

                    String genre = scanner.nextLine();
                    System.out.println("Listing all content in the genre: " + genre);

                    searchByGenre(genre);
                    break;

                case "trackorder":
                    System.out.println("Tracking orders...");
                    Customer loggedInUser = (Customer) user;
                    List<Rental> activeRentals = loggedInUser.getActiveRentals();
                    if (activeRentals.size() == 0) {
                        System.out.println("No active rentals found.");
                        break;
                    }
                    System.out.println("List of active rentals:");
                    for (int i = 0; i < activeRentals.size(); i++) {
                        System.out.println((i + 1) + ". " + activeRentals.get(i).getContent().getTitle());
                    }
                    System.out.println("Enter the name of the content to track your order:");
                    String userInput = scanner.nextLine();
                    Rental rental = user.trackOrder(userInput);
                    if (rental != null) {
                        System.out.println("Your content " + rental.getContent().getTitle() + " was shipped " + rental.getDateShipped());
                    }
                    break;

                case "updatecontent":
                    if (user instanceof Admin) {
                        ((Admin) user).updateContent(scanner);
                    } else {
                        System.out.println("Not admin");
                    }

                    break;
                case "contact":
                    System.out.println("\n========================================");
                    System.out.println("           CONTACT INFORMATION");
                    System.out.println("========================================");
                    System.out.println("Email: contact@postflix.com");
                    System.out.println("Address: Tomtebodavägen 3A, 171 65 Solna");
                    System.out.println("Phone: +46 123 123 22 33");
                    System.out.println("========================================");
                    break;

                case "leavefeedback":
                    System.out.println("Enter the Content ID to leave feedback for:");
                    int contentIDToFeedback = scanner.nextInt();
                    scanner.nextLine();

                    Content contentToFeedback = contentManager.getContentById(contentIDToFeedback); 
                    if (contentToFeedback == null) {
                        System.out.println("Content not found!");
                        break;
                    }

                    System.out.println("Enter a feedback score (1-5):");
                    int feedbackScore = scanner.nextInt();
                    scanner.nextLine();

                    contentToFeedback.leaveFeedback(feedbackScore);
                    System.out.println("Thank you for your feedback!");
                    
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
            System.out.println("SearchByFilm    - Search for a specific film by its title.");
            System.out.println("SearchByGenre   - List all content within a specific genre.");
            System.out.println("LeaveFeedback   - Submit a feedback score for content.");
            System.out.println("Contact         - Show PostFlix's contact information");
            System.out.println("Commands        - List all commands");
            System.out.println("========================================");
        } else {
            System.out.println("========================================");
            System.out.println("          ADMIN COMMAND LISTING");
            System.out.println("========================================");
            System.out.println("ManageUser      - To manage users.");
            System.out.println("TrackOrder      - To track orders by ID.");
            System.out.println("UpdateContent   - To update content.");
            System.out.println("Commands        - List all commands");
            System.out.println("========================================");
        }
    }

    private void searchByGenre(String genre) {
        boolean found = false;
        for (Content content : contentManager.getInventory()) {
            if (content.getGenres().stream().anyMatch(g -> g.equalsIgnoreCase(genre))) {
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
                content.printFullDetails();
                return;
            }
        }
        System.out.println("No movie with the title '" + filmTitle + "' was found.");
    }
}
