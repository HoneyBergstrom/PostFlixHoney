

import java.time.LocalDate;

public class Rental {
    private Content content;
    private Customer customer;
    private LocalDate dateOrdered;
    private LocalDate dateShipped;
    private LocalDate dateReturned;
    private boolean isReturned;

    public Rental(Content content, Customer customer, LocalDate dateOrdered,
                  LocalDate dateShipped, LocalDate dateReturned, boolean isReturned) {
        this.content = content;
        this.customer = customer;
        this.dateOrdered = dateOrdered;
        this.dateShipped = dateShipped;
        this.dateReturned = dateReturned;
        this.isReturned = isReturned;
    }



    public int getRentalID() {
        return rentalID;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public LocalDate getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(LocalDate dateShipped) {
        this.dateShipped = dateShipped;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
