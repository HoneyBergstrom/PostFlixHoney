import java.util.ArrayList;
import java.util.List;

public abstract class CustomerDecorator extends Customer {
    protected Customer customer;

    public CustomerDecorator(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void rentContent(Content content) {
        customer.rentContent(content);
    }

    @Override
    public void returnContent(Content content) {
        customer.returnContent(content);
    }
}

// Concrete Decorator
public class WishContentDecorator extends CustomerDecorator {
    private List<String> wishList;

    public WishContentDecorator(Customer customer) {
        super(customer);
        this.wishList = new ArrayList<>();
    }

    // Add an item to the wish list
    public void addWishContent(String content) {
        wishList.add(content);
        System.out.println("Added to wish list: " + content);
    }

    // Retrieve the wish list
    public List<String> getWishList() {
        return new ArrayList<>(wishList); // Return a copy to avoid external modification
    }

    // Optionally, remove an item from the wish list
    public void removeWishContent(String content) {
        if (wishList.remove(content)) {
            System.out.println("Removed from wish list: " + content);
        } else {
            System.out.println("Content not found in wish list: " + content);
        }
    }
}
