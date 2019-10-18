import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightDAO {
    private static List<Flight> flights = new ArrayList<Flight>();

    static {
        flights.add(new Flight(9,new Date("20/10/2019"),new Date("20/10/2019"),"WRO","WAW",50,100));
        flights.add(new Flight(89,new Date("21/10/2019"),new Date("21/10/2019"),"KRA","WAW",50,100));
    }

    public static List<Flight> getFlights(){
        return flights;
    }

    public static void addFlight(Flight flight){
        flights.add(flight);
    }

    public static Flight getFlightById(int id){
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId() == id){
                return flights.get(i);
            }
        }
        return null;
    }

    public static void removeById (int id){
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getId() == id){
                flights.remove(flights.get(i));
            }
        }
    }
    public static void updateFlight (Flight flight){
        FlightDAO.getFlightById(flight.getId()).setDepartureDate(flight.getDepartureDate());
        FlightDAO.getFlightById(flight.getId()).setArrivalDate(flight.getArrivalDate());
        FlightDAO.getFlightById(flight.getId()).setAirportFromCode(flight.getAirportFromCode());
        FlightDAO.getFlightById(flight.getId()).setAirportToCode(flight.getAirportToCode());
        FlightDAO.getFlightById(flight.getId()).setPrice(flight.getPrice());
        FlightDAO.getFlightById(flight.getId()).setTotalSeats(flight.getTotalSeats());
    }

}
