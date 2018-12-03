package ufc.com.alugaappquixada.Model;

public class RequestForVisit {

    private String date;
    private String hour;
    private Enterprise enterprise;
    private User user;

    public RequestForVisit() {
    }

    public RequestForVisit(String date, String hour, Enterprise enterprise, User user) {
        this.date = date;
        this.hour = hour;
        this.enterprise = enterprise;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RequestForVisit{" +
                "date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", enterprise=" + enterprise +
                ", user=" + user +
                '}';
    }
}
