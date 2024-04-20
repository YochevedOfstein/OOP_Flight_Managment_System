import java.util.Comparator;
import java.util.List;

public class SearchByDepartureTime implements SearchFlightStrategy{
    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparingInt(Flight::getDepartureTime));
    }
}
