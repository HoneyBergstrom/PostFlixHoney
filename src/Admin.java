import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin extends User {
    private ContentManager contentManager;
    
    public Admin(String name, String password) {
        super(name, password);
        this.contentManager = ContentManager.getInstance();
    }
    
    public void updateContent(Scanner scanner) {
        
        System.out.println("\n--- Admin Content Update Menu ---");
        
        while (true) {
            System.out.println("Input content ID to update content");
            int id = scanner.nextInt();
            Content contentToUpdate = contentManager.getContent(id);
            if (contentToUpdate == null) {
                System.out.println("No content with that ID exists! ");
                continue;
            }
            System.out.println("You're editing: " + contentToUpdate.getTitle());
            System.out.println("1. View Current Content");
            System.out.println("2. Update Content Details");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    contentToUpdate.printFullContent();
                    break;

                case 2:
                    System.out.println("\n--- Update Content ---");
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    contentToUpdate.setTitle(newTitle);

                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    contentToUpdate.setDirector(director);

                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    contentToUpdate.setDescription(description);

                    System.out.print("Enter Release Year: ");
                    int releaseYear = scanner.nextInt();
                    contentToUpdate.setReleaseYears(releaseYear);

                    System.out.print("Is it Available? (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    scanner.nextLine(); 
                    contentToUpdate.setAvailable(isAvailable);

                    System.out.println("Enter Genres (comma-separated): ");
                    String genresInput = scanner.nextLine();
                    List<String> genres = List.of(genresInput.split("\\s*,\\s*"));
                    contentToUpdate.setGenres(genres);

                    System.out.println("Content updated successfully.");
                    break;

                case 3:
                    System.out.println("Exiting content update. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
        
    
}
