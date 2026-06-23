public class ImageViewer {
    public static void main(String[] args) {
        Subject image = new ProxyImage("photo.jpg");

        System.out.println("First call to display():");
        image.display();

        System.out.println();
        System.out.println("Second call to display():");
        image.display();
    }
}
