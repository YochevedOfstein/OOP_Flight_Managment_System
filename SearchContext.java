import java.util.ArrayList;
import java.util.List;

public class SearchContext {
    private SearchFlightStrategy strategy;
    private List<Flight> flights;

    public void setStrategy(SearchFlightStrategy s){
        this.strategy = s;
    }

    public void sort(List<Flight> flights){
        strategy.sort(flights);
    }
}
