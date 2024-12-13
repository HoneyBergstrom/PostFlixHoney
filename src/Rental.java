

import java.time.LocalDate;

public class Rental {
    private Content content;
    private Customer customer;
    private LocalDate dateShipped;
    private boolean isReturned;

    public Rental(Content content, Customer customer,
                  LocalDate dateShipped, boolean isReturned) {
        this.content = content;
        this.customer = customer;
        this.dateShipped = dateShipped;
        this.isReturned = isReturned;
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

    public LocalDate getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(LocalDate dateShipped) {
        this.dateShipped = dateShipped;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
}
