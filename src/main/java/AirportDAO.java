import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private static List<Airport> airports = new ArrayList<Airport>();

    static {
        airports.add(new Airport("WRO", "Wrocław", "Poland"));
        airports.add(new Airport("WAW", "Warszawa", "Poland"));
        airports.add(new Airport("KRA", "Krakow", "Poland"));
    }

    public static List<Airport> getAirports() {
        return airports;
    }

    public static void addAirport(Airport airport) {
        airports.add(airport);
    }

    public static Airport getAirportByCode(String code) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getCode().equals(code)) {
                return airports.get(i);
            }
        }
        return null;
    }

    public static void deleteByCode(String code) {
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getCode().equals(code)) {
                airports.remove(airports.get(i));
            }
        }
    }
    public void createAirpot (Airport airport){
        airports.add(airport);
    }
    public void updateAirport(Airport airport){
       AirportDAO.getAirportByCode(airport.getCode()).setCity(airport.getCity());
       AirportDAO.getAirportByCode(airport.getCode()).setCountry(airport.getCountry());
    }
}
