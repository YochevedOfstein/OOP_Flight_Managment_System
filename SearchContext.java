import java.util.ArrayList;
import java.util.List;

public class SearchContext {
    private SearchFlightStrategy strategy;

    public void setStrategy(SearchFlightStrategy s){
        this.strategy = s;
    }

    public void sort(List<Flight> flights){
        strategy.sort(flights);
    }
}
