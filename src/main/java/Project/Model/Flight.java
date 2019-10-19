package Project.Model;

import java.util.Date;
import java.util.Objects;

public class Flight {
    private int id;
    private Date departureDate;
    private Date arrivalDate;
    private String airportFromCode;
    private String airportToCode;
    private double price;
    private int totalSeats;

    public Flight(int id, Date departureDate, Date arrivalDate, String airportFromCode, String airportToCode, double price, int totalSeats) {
        this.id = id;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airportFromCode = airportFromCode;
        this.airportToCode = airportToCode;
        this.price = price;
        this.totalSeats = totalSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAirportFromCode() {
        return airportFromCode;
    }

    public void setAirportFromCode(String airportFromCode) {
        this.airportFromCode = airportFromCode;
    }

    public String getAirportToCode() {
        return airportToCode;
    }

    public void setAirportToCode(String airportToCode) {
        this.airportToCode = airportToCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                Double.compare(flight.price, price) == 0 &&
                totalSeats == flight.totalSeats &&
                Objects.equals(departureDate, flight.departureDate) &&
                Objects.equals(arrivalDate, flight.arrivalDate) &&
                Objects.equals(airportFromCode, flight.airportFromCode) &&
                Objects.equals(airportToCode, flight.airportToCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureDate, arrivalDate, airportFromCode, airportToCode, price, totalSeats);
    }

    @Override
    public String toString() {
        return "Project.Model.Flight{" +
                "id=" + id +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", airportFromCode='" + airportFromCode + '\'' +
                ", airportToCode='" + airportToCode + '\'' +
                ", price=" + price +
                ", totalSeats=" + totalSeats +
                '}';
    }
}
