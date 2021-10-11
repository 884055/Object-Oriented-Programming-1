package it.unive.dais.po1.vehicles;

public class Vehicle {
    private double speed;

    public Vehicle(double initialSpeed) {
        this.speed = initialSpeed;
    }

    /**
     * Accelerate the car of the given amount of km/h.
     *
     * @param a speed in km/h. Must be greater or equal than zero.
     *
     * @requires amount >= 0
     */
    public void accelerate(double a) {
        if(a>0)
            this.speed += a;
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
    public double getSpeed() {
        return speed;
    }
}
