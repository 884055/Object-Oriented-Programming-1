package it.unive.dais.po1.vehicles.autovehicles.fuel;

import java.util.Objects;

/**
 * This class represents a fuel type
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class FuelType {
    private final String type;

    public double getFuelCost() {
        return costPerLiter;
    }

    private double costPerLiter;
    private final double litresPerKmH;

    @Override
    public FuelType clone() {
        return new FuelType(type, costPerLiter, litresPerKmH);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelType fuelType = (FuelType) o;
        return Double.compare(fuelType.costPerLiter, costPerLiter) == 0 && Double.compare(fuelType.litresPerKmH, litresPerKmH) == 0 && Objects.equals(type, fuelType.type);
    }

    @Override
    public int hashCode() {
        return (int) costPerLiter;
    }

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
     *
     * @requires NIENTE
     * @ensures costPerLiter < 0 => getCostPerLiter() = 0
     * @ensures costPerLiter >= 0 => Math.abs(this.costPerLiter-costPerLiter)/getCostPerLiter() < 0.20 => getCostPerLiter() = costPerLiter
     * @ensures costPerLiter >= 0 => Math.abs(this.costPerLiter-costPerLiter)/getCostPerLiter() >= 0.20 => ...
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
