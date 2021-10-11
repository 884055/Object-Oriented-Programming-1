package it.unive.dais.po1.vehicles;


public class Bicycle extends Vehicle {
    private final double frontTire, rearTire;

    public Bicycle(int initialSpeed, int frontTire, int rearTire) {
        super(initialSpeed);
        this.frontTire = frontTire;
        this.rearTire = rearTire;
    }

    public Bicycle(int initialSpeed) {
        this(initialSpeed, 0, 0);
    }


    public double frontTirePressure() {
        return frontTire;
    }
    public double rearTirePressure() {
        return rearTire;
    }
}
