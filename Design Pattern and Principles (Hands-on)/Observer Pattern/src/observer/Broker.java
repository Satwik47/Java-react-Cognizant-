package observer;

public class Broker implements Observer {
    private final String firm;

    public Broker(String firm) { this.firm = firm; }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Broker " + firm + " notified: " + stockSymbol + " => " + price);
    }

    @Override
    public String toString() { return "Broker(" + firm + ")"; }
}
