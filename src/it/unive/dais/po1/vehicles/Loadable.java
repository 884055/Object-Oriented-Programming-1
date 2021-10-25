package it.unive.dais.po1.vehicles;

public interface Loadable {

    double getLoad();
    void setLoad(double l);

    default public void chargeLoad(double amount) {
        if(amount>0.0)
            this.setLoad(this.getLoad()+ amount);
    }
}
