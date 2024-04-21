import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchFlight {

    private SearchContext context;
    private List<Flight> flights;

    public SearchFlight(List<Flight> flights){
        this.context = new SearchContext();
        this.flights = flights;
    }

    public void preformSearch(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select number to search flight:");
        System.out.println("1. Departure Time");
        System.out.println("2. Destination");
        System.out.println("3. Flight Number");
        System.out.println("4. Origin");
        System.out.println("5. Price");

        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1:
                context.setStrategy(new SearchByDepartureTime());
                System.out.println("Sorted flights by departure time: ");
                break;
            case 2:
                System.out.println("Enter destination:");
                String destination = scanner.nextLine();
                context.setStrategy(new SearchByDestination(destination));
                System.out.println("Flights with wanted destination: ");
                break;
            case 3:
                System.out.println("Enter flight number:");
                String flightNumber = scanner.nextLine();
                context.setStrategy(new SearchByFlightNumber(flightNumber));
                System.out.println("Search wanted flight number: ");
                break;
            case 4:
                System.out.println("Enter origin:");
                String origin = scanner.nextLine();
                context.setStrategy(new SearchByOrigin(origin));
                System.out.println("Flights with wanted origin: ");
                break;
            case 5:
                context.setStrategy(new SearchByPrice());
                System.out.println("Sorted flights by price: ");
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        context.sort(flights);

        if(flights.isEmpty()){
            System.out.println("No flights");
        }
        else{
            for(Flight f: flights){
                System.out.println("Flight Number: " + f.getName() + ", Origin: " + f.getOrigin() +
                        ", Destination: " + f.getDestination() + ", Departure Time: " +
                        f.getDepartureTime() + ", Price: " + f.getPrice());
            }
        }
    }
}
