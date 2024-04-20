import java.util.List;

public class AirlineWorker extends Person {

    private Airline airline;

    public AirlineWorker(String name, int ID, Airline airline){
        super(name,ID);
        this.airline = airline;
    }
    public void changeAirline(Airline a){
        airline.removeWorker(this);
        this.airline = a;
        a.addAirlineWorker(this);
    }

}
