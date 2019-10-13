import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDAO {
    private static List<Flight> flights = new ArrayList<>();

    static {
        flights.add(new Flight(9,new Date("20/10/2019"),new Date("20/10/2019"),"WRO","WAW",50,100));
    }

    public List<Flight> getFlights(){
        return flights;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }
}
