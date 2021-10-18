package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.Truck;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelTank;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

public class Race {

    /**
     *
     * @param v1 the first vehicle
     * @param v2 the second vehicle
     * @param length the length of the race
     * @return the id of the winner of the race, or -1
     */
    public static int race(Vehicle v1,  Vehicle v2, double length) {
        v1.fullBrake();
        v2.fullBrake();
        double distancev1 = 0, distancev2 = 0;
        while(distancev1 < length && distancev2 < length) {
            v1.accelerate(Math.random()*10.0);
            v2.accelerate(Math.random()*10.0);
            distancev1 += v1.getSpeed();
            distancev2 += v2.getSpeed();
        }
        if(distancev1 >= length) {
            if(distancev2 >= length)
                return -1;
            else return 1;
        }
        else return 2;
    }

    public static void main(String[] args) {

        FuelType diesel = new FuelType("diesel", 1.4);
        Car myCar = new Car(0, new FuelType("diesel", 1.4, 0.01));
        Car yourCar = new Car(0, new FuelType("petrol", 1.5, 0.015));
        Bicycle myBicycle = new Bicycle(10);
        Truck myTruck = new Truck(0, diesel);

        FuelTank two_lt = new FuelTank(diesel, 2);
        myCar.refuel(two_lt);
        FuelTank three_lt = new FuelTank(diesel, 3);
        myTruck.refuel(three_lt);


        race(myBicycle, myTruck, 100);
    }
}
