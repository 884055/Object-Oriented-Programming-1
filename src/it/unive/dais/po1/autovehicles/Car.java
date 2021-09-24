package it.unive.dais.po1.autovehicles;
import it.unive.dais.po1.autovehicles.fuel.*;

public class Car {
    double speed = 0;
    double fuel = 0;
    FuelType fuelType = null;

    Car(FuelType f) {
        fuelType = f;
    }

    void refuel(FuelTank tank) {
        if(tank.type.isCompatible(this)) {
            fuel = fuel + tank.amount;
            tank.amount = 0;
        }
    }

    void fullBrake() {
        this.speed=0;
    }

    void brake(double amount) {
        if(amount > speed)
            this.fullBrake();
        else speed = speed - amount;
    }

    void accelerate(double amount) {
        double fuelConsumed = amount*fuelType.litresPerKmH;
        if(fuelConsumed < fuel) {
            speed = speed + amount;
            fuel = fuel - fuelConsumed;
        }
        else {
            double increaseSpeed = fuel / fuelType.litresPerKmH;
            speed = speed + increaseSpeed;
            fuel = 0;
        }
    }

    public static void main(String[] args) {
        FuelType diesel = new FuelType("diesel", 1.4);
        FuelType petrol = new FuelType("petrol", 1.4, 0.005);

        Car myCar = new Car(new FuelType("diesel", 1.4, 0.01));
        FuelTank two_lt = new FuelTank(diesel, 2);
        FuelTank three_lt = new FuelTank(diesel, 3);
        diesel.costPerLiter = 1.35;
        myCar.refuel(two_lt);
        double increase = 100;
        myCar.accelerate(increase);
        Car yourCar = new Car(diesel);
        yourCar.refuel(three_lt);
        yourCar = myCar;
        myCar.brake(30);
        myCar.accelerate(50);
        yourCar.accelerate(1000);
        myCar.brake(200);

        System.out.println(myCar.fuel);
        System.out.println(myCar.speed);
    }

}
