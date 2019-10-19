package Project.Model;

import java.util.Objects;

public class Ticket {
    private int id;
    private int flightId;
    private String userLogin;

    public Ticket(int id, int flightId, String userLogin) {
        this.id = id;
        this.flightId = flightId;
        this.userLogin = userLogin;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                flightId == ticket.flightId &&
                Objects.equals(userLogin, ticket.userLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId, userLogin);
    }

    @Override
    public String toString() {
        return "Project.Model.Ticket{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}
