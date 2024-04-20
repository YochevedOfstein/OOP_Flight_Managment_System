import java.util.ArrayList;
import java.util.List;

public class Airline implements AirlineComponent{
    private final String name;
    private List<Flight> flights;
    private List<Airline> subAirlines;
    private List<AirlineWorker> workers;

    private boolean hasFather;
    public Airline(String name){
        this.name = name;
        this.flights = new ArrayList<>();
        this.subAirlines = new ArrayList<>();
        this.workers = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Flight> getFlights(){
        return flights;
    }

    public void addSubAirline(Airline a){
        if(subAirlines.contains(a) || a.hasFather){
            System.out.println(a + "is a sub airline already");
        }
        else{
            subAirlines.add(a);
            a.hasFather = true;
        }
    }

    public void addFlight(Flight f){
        flights.add(f);
    }
    public void addAirlineWorker(AirlineWorker a){
        workers.add(a);
    }

    public void removeWorker(AirlineWorker w){
        workers.remove(w);
    }

    @Override
    public int numOfPassengers() {
        int sum = 0;
        for(Flight flight : flights){
            sum += flight.numOfPassengers();
        }
        for(Airline subairline : subAirlines){
            sum += subairline.numOfPassengers();
        }

        return sum;
    }

    public int numOfSubAirlines(){
        int sum = subAirlines.size();
        for(Airline subairline : subAirlines){
            sum += subairline.numOfSubAirlines();
        }
        return sum;
    }

    public int numOfWorkers(){
        int sum = workers.size();
        for(Airline subairline : subAirlines){
            sum += subairline.numOfWorkers();
        }
        return sum;
    }

    public int numOfFlights() {
        int sum = flights.size();
        for(Airline subairline : subAirlines){
            sum += subairline.numOfFlights();
        }
        return sum;
    }

    public void addObserver(Person p){
        for(Flight flight : flights){
            flight.addObserver(p);
        }
        for(Airline subairline : subAirlines){
            subairline.addObserver(p);
        }
    }

    @Override
    public int totalPayment() {
        int sum = 0;
        for (Flight flight : flights) {
            sum += flight.getPrice() * flight.numOfPassengers();
        }
        for (Airline subairline : subAirlines) {
            sum += subairline.totalPayment();
        }
        return sum;
    }

}


