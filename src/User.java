

public abstract class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Rental trackOrder(String contentName) {
        Customer customer = (Customer) this;
        return customer.getActiveRentals()
                .stream()
                .filter(rental -> rental.getContent().getTitle().equalsIgnoreCase(contentName))
                .findFirst()
                .orElse(null);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
}
