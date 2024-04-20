import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Observer{
    protected final String name;
    protected final int ID;
    protected List<String> notifications;
    public Person(String name, int ID){
        this.name = name;
        this.ID = ID;
        this.notifications = new ArrayList<>();
    }

    @Override
    public void update(String notification) {
        notifications.add(notification);
    }

    public void printNotifications(){
        if(notifications.isEmpty()){
            System.out.println(name + " has no notifications");
        }
        else {
            System.out.println(name + "'s notifications:");
            for (String notification : notifications) {
                System.out.println(notification);
            }
        }
    }
    public void becomeFlightObserver(Flight f){
        f.addObserver(this);
    }
    public void becomeAirlineObserver(Airline a){
        a.addObserver(this);
    }
}
