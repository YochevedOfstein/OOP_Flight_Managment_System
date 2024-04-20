import java.util.Comparator;
import java.util.List;

public class SearchByFlightLength implements SearchFlightStrategy{
    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparingDouble(Flight::getFlightLength));
    }
}
