import java.util.Comparator;
import java.util.List;

public class SearchByPrice implements SearchFlightStrategy{

    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparingInt(Flight::getPrice));
    }
}
