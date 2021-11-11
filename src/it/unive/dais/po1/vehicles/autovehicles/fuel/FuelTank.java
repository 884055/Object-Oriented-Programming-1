package it.unive.dais.po1.vehicles.autovehicles.fuel;
/**
 * This class represents a fuel tank
 *
 * @since 1.0
 * @author Pietro Ferrara
 */
public class FuelTank implements Comparable<FuelTank> {
    private FuelType type;
    private double amount;
    private int id;
    static int counter = 0;

    public FuelType getFuelType() {
        return this.type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FuelTank) {
            FuelTank o = (FuelTank) obj;
            return this.amount==o.amount &&
                    this.getFuelType().equals(o.getFuelType());
        }
        return false;
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

    @Override
    public int compareTo(FuelTank o) {
        if(this.equals(o))
            return 0;
        else if(this.amount!=o.amount) {
            return (int) (this.amount-o.amount);
        }
        else return this.type.compareTo(o.type);
    }
}
