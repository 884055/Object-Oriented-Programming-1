package it.unive.dais.po1.autovehicles;
import it.unive.dais.po1.autovehicles.fuel.*;

/**
 * This class represents a car
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class Car {
    private double speed = 0;
    private double fuel = 0;
    private final FuelType fuelType;

    /**
     * Standard constructor for cars. Cars are standing and without fuel at the beginning.
     *
     * @param f the fuel type of the car
     */
    public Car(FuelType f) {
        fuelType = f;
    }

    /**
     * Refuel the car with the fuel in the given tank.
     *
     * @param tank a fuel tank containing some fuel
     */
    public void refuel(FuelTank tank) {
        if(this.fuelType.isCompatible(tank)) {
            fuel = fuel + tank.getAmount();
            tank.emptyTank();
        }
    }

    /**
     * Stops the car
     */
    public void fullBrake() {
        this.speed=0;
    }

    /**
     * Lower the speed of the car of the given amount
     *
     * @param amount km/h to speed down car
     */
    public void brake(double amount) {
        if(amount > speed)
            this.fullBrake();
        else speed = speed - amount;
    }

    private double computeConsumedFuel(double speedIncrease, double litresPerKmH) {
        return speedIncrease*litresPerKmH;
    }

    /**
     * Accelerate the car of the given amount of km/h
     *
     * @param amount a speed in km/h
     */
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
        Math.abs(-10);

        System.out.println(myCar.fuel);
        System.out.println(myCar.speed);
    }

}
