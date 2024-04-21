import java.util.ArrayList;
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
        List<Flight> wantedFlights = new ArrayList<>();
        for (Flight f: flights){
            if(Objects.equals(f.getOrigin(), origin)){
                wantedFlights.add(f);
            }
        }
        if(wantedFlights.isEmpty()){
            System.out.println("No flights with the following origin: " + origin);
        }
        else{
            flights.clear();
            flights.addAll(wantedFlights);
        }
    }
}
