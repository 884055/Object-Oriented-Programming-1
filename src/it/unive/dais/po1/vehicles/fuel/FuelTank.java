package it.unive.dais.po1.vehicles.fuel;
/**
 * This class represents a fuel tank
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class FuelTank {
    private FuelType type;
    private double amount;
    private int id;
    static int counter = 0;

    public FuelType getFuelType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public void emptyTank() {
        this.amount = 0;
    }

    public FuelTank(FuelType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.id = FuelTank.counter;
        FuelTank.counter++;
    }

    public FuelTank(FuelType type) {
        this(type, 0.0);
    }

    static void resetTanksCount() {
        FuelTank.counter = 0;
    }
    static {
        FuelTank.resetTanksCount();
    }
}
