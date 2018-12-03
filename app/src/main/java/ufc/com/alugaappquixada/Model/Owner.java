package ufc.com.alugaappquixada.Model;

import java.util.List;

public class Owner {
    private String name;
    private String email;
    private Adress adress;
    private PhoneNumber phoneNumber;
    private List<Enterprise> enterprise;

    public Owner(String name, String email, PhoneNumber phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Enterprise> getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(List<Enterprise> enterprises) {
        this.enterprise = enterprises;
    }
}
