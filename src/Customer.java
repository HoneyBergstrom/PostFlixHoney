


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Rental> activeRentals;
    private List<Content> rentHistory;
    private Address address;
    
    //Ändra namn och göra till singleton?
    

    public Customer(String name, String password, Address address) {
        super(name, password);
        this.activeRentals = new ArrayList<>();
        this.rentHistory = new ArrayList<>();
        this.address = address;
    }
    
    //TODO test constructor


    public Customer(String name, String password) {
        super(name, password);
    }

    public void rentContent(String title) {
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

    public void addRental(Rental rental) {
        this.activeRentals.add(rental);
    }

    public void addToHistory(Content contentToReturn) {
        rentHistory.add(contentToReturn);
    }
}
