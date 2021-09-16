public class Car {
    double speed = 0;
    double fuel = 0;

    double litresPerKmH = 0.01;

    void refuel(double amount) {
        fuel = fuel + amount;
    }

    void brake(double amount) {
        if(amount > speed)
            speed = 0;
        else speed = speed - amount;
    }

    void accelerate(double amount) {
        double fuelConsumed = amount*litresPerKmH;
        if(fuelConsumed < fuel) {
            speed = speed + amount;
            fuel = fuel - fuelConsumed;
        }
        else {
            double increaseSpeed = fuel / litresPerKmH;
            speed = speed + increaseSpeed;
            fuel = 0;
        }
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.refuel(2);
        myCar.accelerate(100);
        Car yourCar = new Car();
        yourCar.refuel(3);
        yourCar = myCar;
        myCar.brake(30);
        myCar.accelerate(50);
        yourCar.accelerate(1000);
        myCar.brake(200);

        System.out.println(myCar.fuel);
        System.out.println(myCar.speed);
    }

}
