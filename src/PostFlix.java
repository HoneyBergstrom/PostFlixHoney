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

        System.out.print("Please enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = scanner.nextLine();

        System.out.println(username + " " + password);
        //Test boolean - alltid true
        boolean alwaysTrue = true;

        //TODO get user from file
        if (alwaysTrue) {
            System.out.println("\n========================================");
            System.out.println("  LOGIN SUCCESSFUL! WELCOME, " + username.toUpperCase() + "!");
            System.out.println("========================================\n");
        } else {
            System.out.println("\n========================================");
            System.out.println("      LOGIN FAILED! INVALID CREDENTIALS.");
            System.out.println("========================================\n");
        }

        //TODO check if customer or admin

        //Test user
        User user = new Customer(username, password);
        displayCommands(user);


        String userCommand = scanner.nextLine();


        switch (userCommand.toLowerCase()) {
            case "borrow":
                System.out.println("You chose to borrow content.");
                // Add borrow logic here
                break;

            case "return":
                System.out.println("You chose to return borrowed content.");
                // Add return logic here
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
                System.out.println("Updating content...");
                // Add content update logic here
                break;
            case "commands":
                displayCommands(user);

            default:
                System.out.println("Invalid command! Please try again.");
                break;
        }
    }

    private void displayCommands(User user) {
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
            if (content.getGenre().contains(genre)) {
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
