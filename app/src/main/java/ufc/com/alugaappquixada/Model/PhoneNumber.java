package ufc.com.alugaappquixada.Model;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String label;
    private String number;

    public PhoneNumber(String label, String number) {
        this.label = label;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
