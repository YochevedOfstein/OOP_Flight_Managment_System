import java.util.ArrayList;
import java.util.List;

public class AirlineSystem {
    private List<Airline> airlines;

    public AirlineSystem() {
        this.airlines = new ArrayList<>();
    }

    public Airline createAirline(String name){
        Airline newairline = new Airline(name);
        airlines.add(newairline);
        return newairline;
    }

    public Flight createFlight(String flightNumber, int price, Airline airline, String origin, String destination, double flightLength, int departure){
        Flight newflight = new Flight(flightNumber, price, airline, origin, destination, flightLength, departure);
        return newflight;
    }

    public void addSubAirline(Airline a, Airline b){
        a.addSubAirline(b);
    }
    public void addFlight(Airline a, Flight f){
        a.addFlight(f);
    }

    public void addPassengerToFlight(Flight f, Passenger p){
        p.bookFlight(f);
    }

    public void removePassengerFromFlight(Flight f, Passenger p){
        p.unBookFlight(f);
    }

    public void addWorkers(Airline a, AirlineWorker b){
        a.addAirlineWorker(b);
    }

    public void changeWorkPlace(Airline a, AirlineWorker w){
        w.changeAirline(a);
    }

    public void becomeObserver(Passenger p, Flight f){
        p.becomeFlightObserver(f);
    }


    public void getNumberOfFlights(Airline a){
        int num = a.numOfFlights();
        System.out.println("Total number of flights in " + a.getName()+ ":" + num);
    }

    public void getNumberOfPassengers(Airline a){
        int num = a.numOfPassengers();
        System.out.println("Total number of passengers in " + a.getName() + ":" + num);
    }

    public void getNumberOfSubAirlines(Airline a){
        int num = a.numOfSubAirlines();
        System.out.println("Total number of sub airlines in " + a.getName() + ":" + num);
    }

    public void getNumberOfWorkers(Airline a){
        int num = a.numOfWorkers();
        System.out.println("Total number of workers in " + a.getName() + ":" + num);
    }

    public void getEstimatedIncome(Airline a){
        int num = a.totalPayment();
        System.out.println("Estimated income in " + a.getName() + ":" + num);
    }

    public void getAirlineData(Airline a){
        System.out.println(a.getName() + "s data:");
        getNumberOfSubAirlines(a);
        getNumberOfFlights(a);
        getNumberOfWorkers(a);
        getNumberOfPassengers(a);
        getEstimatedIncome(a);

    }

    public void cancelFlight(Flight f){
        f.cancelFlight();
    }

    public void changeDepartureTime(Flight f, int newtime){
        f.changeDepartureTime(newtime);
    }

    public void announceSale(Flight f, int percent){
        f.sale(percent);
    }


    public void printNotifications(Person p){
        p.printNotifications();
    }
}
