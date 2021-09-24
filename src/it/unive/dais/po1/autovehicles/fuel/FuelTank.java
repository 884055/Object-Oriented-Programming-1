package it.unive.dais.po1.autovehicles.fuel;

public class FuelTank {
    FuelType type;
    double amount;
    int id;
    static int counter = 0;

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
