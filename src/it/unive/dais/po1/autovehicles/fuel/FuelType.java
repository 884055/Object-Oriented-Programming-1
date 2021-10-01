package it.unive.dais.po1.autovehicles.fuel;

import it.unive.dais.po1.autovehicles.Car;

public class FuelType {
    private final String type;
    private double costPerLiter;
    private final double litresPerKmH;

    public double getLitresPerKmH() {
        return this.litresPerKmH;
    }

    public boolean setCostPerLiter(double costPerLiter) {
        if(costPerLiter < 0) {
            this.costPerLiter = 0;
            return false;
        }
        else {
            double difference = Math.abs(this.costPerLiter-costPerLiter);
            double differencePercentage = difference/this.costPerLiter;
            if(differencePercentage < 0.20) {
                this.costPerLiter = costPerLiter;
                return true;
            }
            else return false;
        }
    }

    public FuelType(String t, double c) {
        this(t, c, 0.01);
    }
    public FuelType(String type, double costPerLiter, double litresPerKmH) {
        this.type = type;
        this.costPerLiter = costPerLiter;
        this.litresPerKmH = litresPerKmH;
    }

    public boolean isCompatible(FuelTank tank) {
        return tank.getFuelType().equals(this.type);
    }

}
