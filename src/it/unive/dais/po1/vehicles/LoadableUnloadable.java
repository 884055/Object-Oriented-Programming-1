package it.unive.dais.po1.vehicles;

public interface LoadableUnloadable extends Loadable {

    default public double unload() {
        double value = this.getLoad();
        this.setLoad(0.0);
        return value;
    }
}
