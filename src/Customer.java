


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
