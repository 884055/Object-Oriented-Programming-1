package it.unive.dais.po1.vehicles.autovehicles;
import it.unive.dais.po1.TestException;
import it.unive.dais.po1.vehicles.ImpossibleAccelerationException;
import it.unive.dais.po1.vehicles.InconsistentSpeedException;
import it.unive.dais.po1.vehicles.NegativeSpeedException;
import it.unive.dais.po1.vehicles.Vehicle;
import it.unive.dais.po1.vehicles.autovehicles.fuel.*;
import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * This class represents a car
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class Car extends Vehicle {
    @Override
    public boolean equals(Object o) {
        if(o != null && o instanceof Car) {
            Car o1= (Car) o;
            return o1.getSpeed() == this.getSpeed() &&
                    o1.fuel == this.fuel &&
                    this.fuelType.equals(o1.fuelType);
        }
        else return false;
    }
    @Override
    public Car clone() {
        Car c = new Car(this.getSpeed(), this.fuelType.clone());
        c.fuel = this.fuel;
        return c;
    }

    @Override
    public int hashCode() {
        //return (int) this.getSpeed();
        //return (int) this.fuel;
        return this.fuelType.hashCode();
    }

    /*
        @invariant fuel >= 0
         */
    private double fuel = 0;
    private final FuelType fuelType;

    /**
     * Standard constructor for cars. Cars are standing and without fuel at the beginning.
     *
     * @param f the fuel type of the car
     */
    public Car(double initialSpeed, FuelType f) {
        super(initialSpeed);
        fuelType = f;
    }

    public boolean isFuelEmpty() {
        if(fuel <= 0) {
            super.fullBrake();
            return true;
        }
        else return false;
    }

    /**
     * Refuel the car with the fuel in the given tank.
     *
     * @param tank a fuel tank containing some fuel
     *
     * @requires this.fuelType.isCompatible(tank)
     */
    public void refuel(FuelTank tank) {
            fuel = fuel + tank.getAmount();
            tank.emptyTank();
    }

    @Deprecated
    public void refuel(double amount) {
        fuel += amount;
    }





    private double computeConsumedFuel(double speedIncrease, double litresPerKmH) {
        return speedIncrease*litresPerKmH;
    }

    public double getFuelCost() {
        return this.fuelType.getFuelCost();
    }


    /**
     * Accelerate the car of the given amount of km/h. If there is not enough fuel, it accelerates
     * as much as possible.
     *
     * @requires amount >= 0
     * @ensures computeConsumedFuel(amount, fuelType.getLitresPerKmH()) < fuel => speed = pre(speed) + amount
     * @ensures computeConsumedFuel(amount, fuelType.getLitresPerKmH()) >= fuel => speed = pre(speed) + fuel / fuelType.getLitresPerKmH()
     */
    public void accelerate(double amount) throws ImpossibleAccelerationException {
        double fuelConsumed = computeConsumedFuel(amount, fuelType.getLitresPerKmH());
        if(fuelConsumed < fuel) {
            super.accelerate(amount);
            fuel = fuel - fuelConsumed;
        }
        else
            throw new FuelNotSufficientException(fuelConsumed, fuel);
            /*{
            double increaseSpeed = fuel / fuelType.getLitresPerKmH();
            super.accelerate(increaseSpeed);
            fuel = 0;
        }*/
    }
}
