public class Address {
    private String street;
    private int postalCode;
    private String city;
    private int doorCode;
    private String phoneNumber;

    public Address(String street, int postalCode, String city, int doorCode, String phoneNumber) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.doorCode = doorCode;
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }
    

    public int getPostalCode() {
        return postalCode;
    }
    

    public String getCity() {
        return city;
    }
    

    public int getDoorCode() {
        return doorCode;
    }
    

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
