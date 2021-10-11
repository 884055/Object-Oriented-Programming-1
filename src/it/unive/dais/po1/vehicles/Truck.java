package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.fuel.FuelTank;
import it.unive.dais.po1.vehicles.fuel.FuelType;

class Truck {
    private double loadedCharge = 0.0;

    private double speed = 0;

    private double fuel = 0;
    private final FuelType fuelType;


    public Truck(FuelType f) {
        fuelType = f;
    }

    public void refuel(FuelTank tank) {
        fuel = fuel + tank.getAmount();
        tank.emptyTank();
    }

    public void fullBrake() {
        this.speed=0;
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


    void chargeLoad(double l) {
        if(l>0.0)
            this.loadedCharge += l;
    }

    double unload() {
        double value = this.loadedCharge;
        this.loadedCharge = 0.0;
        return value;
    }
}
