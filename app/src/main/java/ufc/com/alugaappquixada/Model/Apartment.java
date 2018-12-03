package ufc.com.alugaappquixada.Model;

public class Apartment {

    private double priceRental;
    private Address address;
    private String description;
    private Owner owner;

    public double getPriceRental() {
        return priceRental;
    }

    public void setPriceRental(double priceRental) {
        this.priceRental = priceRental;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
