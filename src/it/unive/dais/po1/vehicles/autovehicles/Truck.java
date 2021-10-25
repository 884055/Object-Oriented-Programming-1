package it.unive.dais.po1.vehicles.autovehicles;

import it.unive.dais.po1.vehicles.LoadableUnloadable;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

import it.unive.dais.po1.Printable;

public class Truck extends Car implements LoadableUnloadable, Printable {
    private double loadedCharge;

    public Truck(double initialSpeed, FuelType f) {
        super(initialSpeed, f);
    }

    public Truck(double initialSpeed, FuelType f, double loadedCharge) {
        this(initialSpeed, f);
        this.loadedCharge = loadedCharge;
    }

    public double getLoad() {
        return loadedCharge;
    }
    public void setLoad(double l) {
        this.loadedCharge=l;
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

    public void print() {
        System.out.print("I am a truck with "+loadedCharge+" kgs of goods");
    }
}
