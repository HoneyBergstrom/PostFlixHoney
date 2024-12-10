package user;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<User> managedUsers;
    //Ändra namn och göra till singleton?
    private Netflix netflix;
    
    public Admin(String name, String password, Netflix netflix) {
        super(name, password);
        managedUsers = new ArrayList<>();
        this.netflix = netflix;
    }
    
    public void updateContent(int contentId) {
        Content content = netflix.getContentById(contentId);
        if (content != null) {
            //Lägg till vad som ska uppdateras
            content.updateMetadata();
            contentManager.updateContent(contentId, content);
            System.out.println("Content updated successfully: " + content.getTitle());
        } else {
            System.out.println("Content not found with ID: " + contentId);
        }
    }
}
