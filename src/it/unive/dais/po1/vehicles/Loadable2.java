package it.unive.dais.po1.vehicles;

public interface Loadable2 {


    double getChargedLoad();
    void setChargedLoad(double l);

    default public void chargeLoad(double amount) {
        if(amount>0.0)
            this.setChargedLoad(this.getChargedLoad()+ amount);
    }
    default public double unload() {
        double value = this.getChargedLoad();
        this.setChargedLoad(0.0);
        return value;
    }
}
