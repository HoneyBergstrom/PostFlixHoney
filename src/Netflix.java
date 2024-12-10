import java.util.ArrayList;
import java.util.List;

public class Netflix {
    private List<Content> inventory;
    private List<User> users;


    public Netflix() {
        this.inventory = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    public void addContent(Content content) {
        inventory.add(content);
    }


    public void addUser(User user) {
        users.add(user);
    }


    public void processOrder(Content content) {
        if (inventory.contains(content) && content.isAvailable()) {
            content.setAvailable(false);
            System.out.println("Ordern har behandlats: " + content.getTitle());
        } else {
            System.out.println("Innehållet är inte tillgängligt.");
        }
    }


    public void processReturn(Content content) {
        if (inventory.contains(content) && !content.isAvailable()) {
            content.setAvailable(true);
            System.out.println("Returen har behandlats: " + content.getTitle());
        } else {
            System.out.println("Returen kunde inte behandlas.");
        }
    }


    public void showInventory() {
        System.out.println("Inventory:");
        for (Content content : inventory) {
            System.out.println("- " + content.getTitle() + " (Tillgänglig: " + content.isAvailable() + ")");
        }
    }
}
//test
