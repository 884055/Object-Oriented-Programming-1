package it.unive.dais.po1.vehicles.animals;

import it.unive.dais.po1.vehicles.LoadableUnloadable;
import it.unive.dais.po1.vehicles.Vehicle;

public class AnimalCart extends Vehicle implements LoadableUnloadable {
    private double loadedCharge;

    public AnimalCart(double initialSpeed, double initialLoad) {
        super(initialSpeed);
        this.loadedCharge = initialLoad;
    }


    public double getLoad() {
        return loadedCharge;
    }
    public void setLoad(double l) {
        this.loadedCharge=l;
    }
}
