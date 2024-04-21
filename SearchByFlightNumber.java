import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SearchByFlightNumber implements SearchFlightStrategy{

    private String flightNumber;

    public SearchByFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    @Override
    public void sort(List<Flight> flights) {
        List<Flight> wantedFlights = new ArrayList<>();
        for (Flight f: flights){
            if(Objects.equals(f.getName(), flightNumber)){
                wantedFlights.add(f);
            }
        }
        if(wantedFlights.isEmpty()){
           System.out.println("No flights with the following flight number: " + flightNumber );
        }
        else{
            flights.clear();
            flights.addAll(wantedFlights);
        }
    }
}
