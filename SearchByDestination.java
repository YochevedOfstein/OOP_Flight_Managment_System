import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SearchByDestination implements SearchFlightStrategy{

    private String destination;

    public SearchByDestination(String destination){
        this.destination = destination;
    }
    @Override
    public void sort(List<Flight> flights) {
        int count = 0;
        for (Flight f : flights) {
            if (!Objects.equals(f.getDestination(), destination)) {
                flights.remove(f);
                flights.add(0, f);
                count++;
            }
            if (count == 0) {
                System.out.println("No flights going to the following destination");
            }
        }
    }

    /*
    @Override
    public void sort(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getDestination));
    }

     */
}
