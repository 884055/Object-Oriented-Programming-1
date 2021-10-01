package it.unive.dais.po1.autovehicles;
import it.unive.dais.po1.autovehicles.fuel.*;

public class Car {
    private double speed = 0;
    private double fuel = 0;
    private final FuelType fuelType;

    public Car(FuelType f) {
        fuelType = f;
    }

    public void refuel(FuelTank tank) {
        if(this.fuelType.isCompatible(tank)) {
            fuel = fuel + tank.getAmount();
            tank.emptyTank();
        }
    }

    public void fullBrake() {
        this.speed=0;
    }

    public void brake(double amount) {
        if(amount > speed)
            this.fullBrake();
        else speed = speed - amount;
    }

    private double computeConsumedFuel(double speedIncrease, double litresPerKmH) {
        return speedIncrease*litresPerKmH;
    }

    public void accelerate(double amount) {
        double fuelConsumed = computeConsumedFuel(amount, fuelType.getLitresPerKmH());
        if(fuelConsumed < fuel) {
            speed = speed + amount;
            fuel = fuel - fuelConsumed;
        }
        else {
            double increaseSpeed = fuel / fuelType.getLitresPerKmH();
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
        diesel.setCostPerLiter(1.35);
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
