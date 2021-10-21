package it.unive.dais.po1.vehicles.autovehicles;

import it.unive.dais.po1.vehicles.Loadable;
import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

public class Truck extends Car implements Loadable {
    private double loadedCharge;

    public Truck(double initialSpeed, FuelType f) {
        super(initialSpeed, f);
    }

    public Truck(double initialSpeed, FuelType f, double loadedCharge) {
        this(initialSpeed, f);
        this.loadedCharge = loadedCharge;
    }


    public void chargeLoad(double l) {
        if(l>0.0)
            this.loadedCharge += l;
    }


    public double unload() {
        double value = this.loadedCharge;
        this.loadedCharge = 0.0;
        return value;
    }
}
