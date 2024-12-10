import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    private List<User> managedUsers;
    //Ändra namn och göra till singleton?
    private ContentManager contentManager;
    
    public Admin(String name, String password, ContentManager contentManager) {
        super(name, password);
        managedUsers = new ArrayList<>();
        this.contentManager = contentManager;
    }
    
    public void updateContent(int contentId) {
        Content content = contentManager.getContentById(contentId);
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
