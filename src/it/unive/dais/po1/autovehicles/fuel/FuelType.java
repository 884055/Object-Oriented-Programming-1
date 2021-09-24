package it.unive.dais.po1.autovehicles.fuel;

import it.unive.dais.po1.autovehicles.Car;

public class FuelType {
    final String type;
    double costPerLiter;
    final double litresPerKmH;

    FuelType(String t, double c) {
        this(t, c, 0.01);
    }
    FuelType(String type, double costPerLiter, double litresPerKmH) {
        this.type = type;
        this.costPerLiter = costPerLiter;
        this.litresPerKmH = litresPerKmH;
    }

    boolean isCompatible(Car car) {
        return car.fuelType.type.equals(this.type);
    }

}
