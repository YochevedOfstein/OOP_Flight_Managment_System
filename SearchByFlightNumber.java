import java.util.List;
import java.util.Objects;

public class SearchByFlightNumber implements SearchFlightStrategy{

    private String flightNumber;

    public SearchByFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }
    @Override
    public void sort(List<Flight> flights) {
        int count = 0;
        for (Flight f : flights) {
            if (Objects.equals(f.getName(), flightNumber)) {
                flights.remove(f);
                flights.add(0, f);
                count++;
            }
            if (count == 0) {
                System.out.println("No flights with the following flight number found");
            }
        }
    }
}
