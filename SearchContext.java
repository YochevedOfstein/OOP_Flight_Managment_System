import java.util.List;

public class SearchContext {
    private SearchFlightStrategy strategy;

    public void setStrategy(SearchFlightStrategy strategy){
        this.strategy = strategy;
    }

    public void sort(List<Flight> flights){
        strategy.sort(flights);
    }
}
