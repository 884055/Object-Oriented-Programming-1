package it.unive.dais.po1.vehicles;

public interface Unloadable {

    double getLoad();
    void setLoad(double l);

    default public double unload() {
        double value = this.getLoad();
        this.setLoad(0.0);
        return value;
    }
}
