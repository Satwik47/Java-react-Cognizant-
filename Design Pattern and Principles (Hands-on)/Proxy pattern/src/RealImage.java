public class RealImage implements Subject {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("RealImage: Loading image from remote server: " + filename);
        try {
            Thread.sleep(500); // simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        System.out.println("RealImage: Displaying image: " + filename);
    }
}
