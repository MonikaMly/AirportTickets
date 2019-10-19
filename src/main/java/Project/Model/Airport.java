package Project.Model;

import java.util.Objects;

public class Airport {
    private String code;
    private String city;
    private String country;

    public Airport(String code, String city, String country) {
        this.code = code;
        this.city = city;
        this.country = country;
    }

    public Airport() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(code, airport.code) &&
                Objects.equals(city, airport.city) &&
                Objects.equals(country, airport.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, city, country);
    }

    @Override
    public String toString() {
        return "Project.Model.Airport{" +
                "code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
