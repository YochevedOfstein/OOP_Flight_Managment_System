import java.util.ArrayList;
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
        List<Flight> wantedFlights = new ArrayList<>();
        for (Flight f: flights){
            if(Objects.equals(f.getDestination(), destination)){
                wantedFlights.add(f);
            }
        }
        if(wantedFlights.isEmpty()){
            System.out.println("No flights with the following destination: " + destination);
        }
        else{
            flights.clear();
            flights.addAll(wantedFlights);
        }
    }
}
