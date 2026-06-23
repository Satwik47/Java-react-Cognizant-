package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Investor alice = new Investor("Alice");
        Broker bigBroker = new Broker("BigBroker");

        market.registerObserver(alice);
        market.registerObserver(bigBroker);

        market.setPrice("AAPL", 150.00);
        market.setPrice("GOOG", 2800.00);

        market.removeObserver(bigBroker);

        market.setPrice("AAPL", 155.50);
    }
}
