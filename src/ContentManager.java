

import java.util.ArrayList;
import java.util.List;

public class ContentManager {
    private static ContentManager instance;
    private List<Content> inventory;
    private List<User> users;


    private ContentManager() {
        this.inventory = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public static ContentManager getInstance() {
        if (instance == null) {
            instance = new ContentManager();
        }
        return instance;
    }

    public List<Content> getInventory() {
        return inventory;
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
