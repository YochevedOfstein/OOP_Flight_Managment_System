public interface Observable {
    public void addObserver(Person a);
    public void notifyObservers(String notification);
}
