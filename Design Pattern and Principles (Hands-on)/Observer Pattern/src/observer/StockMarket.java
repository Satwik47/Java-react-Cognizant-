package observer;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockMarket implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Double> prices = new HashMap<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("Registered observer: " + o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Removed observer: " + o);
    }

    @Override
    public void notifyObservers(String stockSymbol, double price) {
        for (Observer o : new ArrayList<>(observers)) {
            o.update(stockSymbol, price);
        }
    }

    public void setPrice(String stockSymbol, double price) {
        prices.put(stockSymbol, price);
        System.out.println("\n[StockMarket] " + stockSymbol + " updated to " + price);
        notifyObservers(stockSymbol, price);
    }

    public Double getPrice(String stockSymbol) {
        return prices.get(stockSymbol);
    }

    @Override
    public String toString() { return "StockMarket"; }
}
