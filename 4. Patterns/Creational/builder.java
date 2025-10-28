public class builder {

    public static void main(String[] args) {
        
        Car.CarBuilder builder1 = new Car.CarBuilder();
        Car car1 = builder1.setEngine("V8")
                .setColor("Red")
                .setSeats(5)
                .setSunroof(true)
                .build(); 
        System.out.println(car1);

        
        Car.CarBuilder builder2 = new Car.CarBuilder();
        Car car2 = builder2.setEngine("V6")
                .setColor("Blue")
                .setSeats(4)
                .build(); 
        System.out.println(car2);
    }
}


class Car {
    private String engine;
    private int wheels;
    private int seats;
    private String color;
    private boolean sunroof;
    private boolean navigationSystem;

    
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.seats = builder.seats;
        this.color = builder.color;
        this.sunroof = builder.sunroof;
        this.navigationSystem = builder.navigationSystem;
    }

    

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSeats() {
        return seats;
    }

    public String getColor() {
        return color;
    }

    public boolean hasSunroof() {
        return sunroof;
    }

    public boolean hasNavigationSystem() {
        return navigationSystem;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", seats=" + seats
                + ", color=" + color + ", sunroof=" + sunroof
                + ", navigationSystem=" + navigationSystem + "]";
    }

    
    
    public static class CarBuilder {
        
        private String engine; 
        private int wheels = 4; 
        private int seats = 5; 
        private String color = "Black"; 
        private boolean sunroof = false; 
        private boolean navigationSystem = false; 

        
        public CarBuilder() {
        }

        
        

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setNavigationSystem(boolean navigationSystem) {
            this.navigationSystem = navigationSystem;
            return this;
        }

        
        public Car build() {
            
            return new Car(this); 
        }
    }
}
