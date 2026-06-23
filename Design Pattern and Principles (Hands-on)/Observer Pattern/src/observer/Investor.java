package observer;

public class Investor implements Observer {
    private final String name;

    public Investor(String name) { this.name = name; }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Investor " + name + " received update: " + stockSymbol + " = " + price);
    }

    @Override
    public String toString() { return "Investor(" + name + ")"; }
}
