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

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDoorCode() {
        return doorCode;
    }

    public void setDoorCode(int doorCode) {
        this.doorCode = doorCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
