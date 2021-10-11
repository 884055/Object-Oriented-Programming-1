package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.fuel.FuelTank;
import it.unive.dais.po1.vehicles.fuel.FuelType;

class Truck extends Car {
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
