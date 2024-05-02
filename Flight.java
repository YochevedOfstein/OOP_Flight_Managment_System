import java.util.ArrayList;
import java.util.List;

public class Flight implements AirlineComponent, Observable{

    private final String flightNumber;
    private int price;
    private Airline airline;
    private final String destination;
    private final String origin;
    private List<Passenger> passengers;
    private List<Person> observers;
    private int departure;
    private double flightLength;
    boolean canceled = false;

    public Flight(String flightNumber, int price, Airline airline, String origin, String destination, double flightLength, int departure){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.destination = destination;
        this.origin = origin;
        this.price = price;
        this.passengers = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.flightLength = flightLength;
        this.departure = departure;
    }

    @Override
    public String getName() {
        return flightNumber;
    }

    public int getPrice(){
        return price;
    }

    public int getDepartureTime(){
        return departure;
    }

    public double getFlightLength(){
        return flightLength;
    }
    public String getDestination(){
        return destination;
    }
    public String getOrigin(){
        return origin;
    }

    public Airline getAirline(){
        return airline;
    }

    public void addPassenger(Passenger a){
        if(passengers.contains(a)){
            System.out.println("Passenger already added to flight");
        }
        else{
            passengers.add(a);
        }
    }

    public void addObserver(Person a){
        observers.add(a);
        airline.addObserver(a);
    }

    public void removePassenger(Passenger p){
        passengers.remove(p);
    }

    @Override
    public int numOfPassengers() {
        return passengers.size();
    }

    @Override
    public int totalPayment() {
        return price*numOfPassengers();
    }
    public void notifyObservers(String notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }

    public void changeDepartureTime(int deptime){
        if(canceled){
            System.out.println("Error - can't change departure time on canceled flight");
        }
        else{
            this.departure = deptime;
            String str = "Flight " + flightNumber + " departure time has changed to " + deptime;
            notifyObservers(str);
        }
    }
    public void cancelFlight(){
        if(!canceled){
            canceled = true;
            passengers.clear();
            String str = "Flight " + flightNumber + " has been canceled";
            notifyObservers(str);
        }
    }
    public void sale(int n){
        if(canceled){
            System.out.println("Error - can't have sale on canceled flight");
        }
        else{
            int sale = (n * price)/100;
            price = price - sale;
            String str = "Sale on flight " + flightNumber + "! New price: " + price;
            notifyObservers(str);
        }
    }
}
