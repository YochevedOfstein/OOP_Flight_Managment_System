import java.util.List;

public class AirlineWorker extends Person {

    private Airline airline;

    public AirlineWorker(String name, int ID, Airline airline){
        super(name,ID);
        this.airline = airline;
        airline.addObserver(this);
    }
    public void changeAirline(Airline a){
        airline.removeWorker(this);
        a.addObserver(this);
        this.airline = a;
        a.addAirlineWorker(this);
    }

}
