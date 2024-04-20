import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SearchByOrigin implements SearchFlightStrategy{

    private String origin;

    public SearchByOrigin(String origin){
        this.origin = origin;
    }
    @Override
    public void sort(List<Flight> flights) {
        int count = 0;
        for (Flight f : flights) {
            if (Objects.equals(f.getOrigin(), origin)) {
                flights.remove(f);
                flights.add(0, f);
                count++;
            }
            if (count == 0) {
                System.out.println("No flights from the following origin found");
            }
        }
    }

    /*
    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getOrigin));
    }

     */
}
