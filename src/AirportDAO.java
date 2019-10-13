import java.util.ArrayList;
import java.util.List;

public class AirportDAO {
    private static List<Airport> airports = new ArrayList<>();
    static{
        airports.add(new Airport("WRO","Wrocław","Poland"));
        airports.add(new Airport("WAW","Warszawa","Poland"));
    }

    public static List<Airport> getAirports(){
        return airports;
    }
    public static void addAirport(Airport airport){
        airports.add(airport);
    }
}
