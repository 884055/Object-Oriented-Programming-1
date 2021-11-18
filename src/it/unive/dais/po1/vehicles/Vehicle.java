package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelNotSufficientException;

public abstract class Vehicle {

    //@invariant speed >= 0
    private double speed;

    public Vehicle(double initialSpeed) {
        this.speed = initialSpeed;
    }

    /**
     * Accelerate the car of the given amount of km/h.
     *
     * @throws InconsistentSpeedException when the current speed of the vehicle does not make any sense
     * @throws NegativeSpeedException when the value passed as parameter is strictly than zero
     * @param a speed in km/h. Must be greater or equal than zero.
     *
     */
    public void accelerate(double a) throws ImpossibleAccelerationException {
        assert a>=0 : "The speed should not be negative";
        if(this.speed < 0)
            throw new InconsistentSpeedException();
        if(a >= 0)
            this.speed += a;
        else throw new NegativeSpeedException(a);
    }
    /**
     * Stops the vehicle
     *
     * @requires NIENTE
     * @ensures getSpeed() = 0
     */
    public void fullBrake() {
        this.speed = 0;
    }


    /**
     * Lower the speed of the car of the given amount
     *
     * @param amount km/h to speed down car
     *
     * @requires amount >= 0
     * @ensures getSpeed() >= 0
     */
    public void brake(double amount) {
        if(amount > speed)
            this.fullBrake();
        else speed = speed - amount;
    }


    /**
     *
     * @return the speed of the car
     *
     * @ensures return >= 0
     */
    final public double getSpeed() {
        return speed;
    }
}
