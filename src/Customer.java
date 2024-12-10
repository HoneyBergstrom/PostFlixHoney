


import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Rental> activeRentals;
    private List<Content> rentHistory;
    private Address address;
    
    //Ändra namn och göra till singleton?
    private ContentManager contentManager;

    public Customer(String name, String password, Address address, ContentManager contentManager) {
        super(name, password);
        this.activeRentals = new ArrayList<>();
        this.rentHistory = new ArrayList<>();
        this.address = address;
        this.contentManager = contentManager;
    }
    
    //TODO test constructor


    public Customer(String name, String password) {
        super(name, password);
    }

    public void rentContent(Content content) {
//        if (content.isAvailable()) {
//            Rental rental = new Rental(content, this);
//            activeRentals.add(rental);
//            content.setAvailable(false);
//            rentHistory.add(content);
//            System.out.println("Content rented successfully: " + content.getTitle());
//        } else {
//            System.out.println("Content is currently unavailable");
//        }
    }
    
    public void returnContent(Content content) {
        Rental rentalToRemove = activeRentals.stream().filter(rental -> rental.getContent().equals(content)).findFirst()
                .orElseThrow();

        if (rentalToRemove != null) {
            activeRentals.remove(rentalToRemove);
            content.setAvailable(true);
            System.out.println("Content returned successfully: " + content.getTitle());
        } else {
            System.out.println("No active rental found for this content");
        }
    }
    
    public void leaveFeedback(Content content, int score) {
//        if (rentHistory.contains(content)) {
//            content.addRating(score);
//            System.out.println("Feedback recorded for: " + content.getTitle());
//        } else {
//            System.out.println("You can only leave feedback for content you have rented");
//        }
    }

    public List<Rental> getActiveRentals() {
        return activeRentals;
    }

    public void setActiveRentals(List<Rental> activeRentals) {
        this.activeRentals = activeRentals;
    }

    public List<Content> getRentHistory() {
        return rentHistory;
    }

    public void setRentHistory(List<Content> rentHistory) {
        this.rentHistory = rentHistory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
