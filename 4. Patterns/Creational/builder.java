public class builder {
    public static void main(String[] args) {
        Car.CarBuilder builder1 = new Car.CarBuilder();
        Car car1 = builder1.setColor("Red")
                .setGears(3)
                .build();
        System.out.println(car1);

        Car.CarBuilder builder2 = new Car.CarBuilder();
        Car car2 = builder2.setColor("Blue")
                .build();
        System.out.println(car2);
    }
}

class Car {
    private String color;
    private int wheels;
    private int gears;

    private Car(CarBuilder builder) {
        this.color = builder.color;
        this.wheels = builder.wheels;
        this.gears = builder.gears;
    }

    @Override
    public String toString() {
        return "Car [color=" + color + ", wheels=" + wheels + ", gears=" + gears + "]";
    }

    public static class CarBuilder {
        private String color = "Black";
        private int wheels = 4;
        private int gears = 5;

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setGears(int gears) {
            this.gears = gears;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}