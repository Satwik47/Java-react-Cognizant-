public class BuilderPatternTest {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Implementation Test ===\n");
        
       
        System.out.println("1. Basic Computer (only CPU and RAM):");
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .build();
        System.out.println(basicComputer);
        System.out.println();
        
        
        System.out.println("2. Computer with Storage:");
        Computer computerWithStorage = new Computer.Builder("Intel i7", "16GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println(computerWithStorage);
        System.out.println();
        
        
        System.out.println("3. Gaming Computer (all features):");
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
                .setStorage("1TB NVMe SSD")
                .setGpu("NVIDIA RTX 4080")
                .setOs("Windows 11")
                .setHasWiFi(true)
                .setHasBluetooth(true)
                .build();
        System.out.println(gamingComputer);
        System.out.println();
        
       
        System.out.println("4. Office Computer:");
        Computer officeComputer = new Computer.Builder("Intel i3", "4GB")
                .setStorage("256GB SSD")
                .setOs("Ubuntu Linux")
                .setHasWiFi(true)
                .build();
        System.out.println(officeComputer);
        System.out.println();
        
        
        System.out.println("5. Developer Workstation:");
        Computer developerComputer = new Computer.Builder("Intel i9", "64GB")
                .setStorage("2TB SSD")
                .setGpu("NVIDIA RTX 3070")
                .setOs("macOS")
                .setHasWiFi(true)
                .setHasBluetooth(true)
                .build();
        System.out.println(developerComputer);
        System.out.println();
        
        System.out.println("=== Test Completed Successfully ===");
    }
}
