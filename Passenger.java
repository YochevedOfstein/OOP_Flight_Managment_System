import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person{

    private List<Flight> bookedflights;

    public Passenger(String name, int ID){
        super(name,ID);
        this.bookedflights = new ArrayList<>();
    }


    public void bookFlight(Flight f){
        f.addPassenger(this);
        bookedflights.add(f);
    }

    public void unBookFlight(Flight f){
        if(bookedflights.contains(f)){
            f.removePassenger(this);
            bookedflights.remove(f);
        }
        else{
            System.out.println("Flight not booked by this passenger");
        }
    }
}
