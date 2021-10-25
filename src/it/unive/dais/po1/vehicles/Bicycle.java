package it.unive.dais.po1.vehicles;


import it.unive.dais.po1.Printable;

public class Bicycle extends Vehicle implements Printable {
    private final double frontTire, rearTire;

    public Bicycle(int initialSpeed, int frontTire, int rearTire) {
        super(initialSpeed);
        this.frontTire = frontTire;
        this.rearTire = rearTire;
    }

    public Bicycle(int initialSpeed) {
        this(initialSpeed, 0, 0);
    }


    final public double frontTirePressure() {
        return frontTire;
    }
    final public double rearTirePressure() {
        return rearTire;
    }


    public void print() {
        System.out.println("I'm a slow bicycle");
    }
}
