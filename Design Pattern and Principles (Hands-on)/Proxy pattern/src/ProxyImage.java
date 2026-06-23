public class ProxyImage implements Subject {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            System.out.println("ProxyImage: Creating real image and loading it now.");
            realImage = new RealImage(filename);
        } else {
            System.out.println("ProxyImage: Using cached image.");
        }
        realImage.display();
    }
}
