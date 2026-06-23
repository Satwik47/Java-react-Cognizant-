public class Computer {
   
    private String cpu;
    private String ram;
    
  
    private String storage;
    private String gpu;
    private String os;
    private boolean hasWiFi;
    private boolean hasBluetooth;
    
  
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
        this.hasWiFi = builder.hasWiFi;
        this.hasBluetooth = builder.hasBluetooth;
    }
    
  
    public String getCpu() {
        return cpu;
    }
    
    public String getRam() {
        return ram;
    }
    
    public String getStorage() {
        return storage;
    }
    
    public String getGpu() {
        return gpu;
    }
    
    public String getOs() {
        return os;
    }
    
    public boolean isHasWiFi() {
        return hasWiFi;
    }
    
    public boolean isHasBluetooth() {
        return hasBluetooth;
    }
    
    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", os='" + os + '\'' +
                ", hasWiFi=" + hasWiFi +
                ", hasBluetooth=" + hasBluetooth +
                '}';
    }
    
    
    public static class Builder {
      
        private String cpu;
        private String ram;
        
        
        private String storage = "256GB SSD";
        private String gpu = "Integrated Graphics";
        private String os = "No OS";
        private boolean hasWiFi = false;
        private boolean hasBluetooth = false;
        
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }
        
        
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        
        public Builder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }
        
        public Builder setOs(String os) {
            this.os = os;
            return this;
        }
        
        public Builder setHasWiFi(boolean hasWiFi) {
            this.hasWiFi = hasWiFi;
            return this;
        }
        
        public Builder setHasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }
        
        
        public Computer build() {
            return new Computer(this);
        }
    }
}
