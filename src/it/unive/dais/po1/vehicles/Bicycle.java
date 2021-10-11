package it.unive.dais.po1.vehicles;


public class Bicycle {

    private double speed = 0;

    public void accelerate(double a) {
        if(a>0)
            this.speed += a;
    }

    public void fullBreak() {
        this.speed = 0;
    }
}
