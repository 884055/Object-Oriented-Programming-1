package it.unive.dais.po1.autovehicles.fuel;

import it.unive.dais.po1.autovehicles.Car;
/**
 * This class represents a fuel type
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class FuelType {
    private final String type;
    private double costPerLiter;
    private final double litresPerKmH;

    /**
     * @return the number of litres per km/h of speed increase
     */
    public double getLitresPerKmH() {
        return this.litresPerKmH;
    }

    /**
     * This method sets the cost per liter to the given price if the change of the price is reasonable w.r.t. to the changes in the fuel market.
     * If the cost per liter is negative, it sets the price to zero.
     *
     * @param costPerLiter the new cost per liter of the current fuel type
     * @return true if and only if the cost per liter of the fuel is set to the given price after the execution of this method
     */
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

    /**
     *
     * @param type
     * @param costPerLiter
     * @param litresPerKmH
     */
    public FuelType(String type, double costPerLiter, double litresPerKmH) {
        this.type = type;
        this.costPerLiter = costPerLiter;
        this.litresPerKmH = litresPerKmH;
    }

    public boolean isCompatible(FuelTank tank) {
        return tank.getFuelType().equals(this.type);
    }

}
