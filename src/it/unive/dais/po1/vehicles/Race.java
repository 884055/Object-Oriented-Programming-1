package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.fuel.FuelTank;
import it.unive.dais.po1.vehicles.fuel.FuelType;

public class Race {

    public static int race(Vehicle v1,  Vehicle v2) {
        return 1;
    }

    public static void main(String[] args) {

        FuelType diesel = new FuelType("diesel", 1.4);
        FuelType petrol = new FuelType("petrol", 1.4, 0.005);

        Car myCar = new Car(0, new FuelType("diesel", 1.4, 0.01));


        Bicycle myBicycle = new Bicycle(10);

        race(myCar, myBicycle);

        Truck myTruck = new Truck(0, diesel);




        myCar.isFuelEmpty();
        FuelTank two_lt = new FuelTank(diesel, 2);
        FuelTank three_lt = new FuelTank(diesel, 3);
        diesel.setCostPerLiter(1.35);
        myCar.refuel(two_lt);

        double increase = 100;
        myCar.accelerate(increase);
        Car yourCar = new Car(0, diesel);
        yourCar.refuel(three_lt);
        yourCar = myCar;
        myCar.brake(30);
        myCar.accelerate(50);
        yourCar.accelerate(1000);
        myCar.brake(200);
        Math.abs(-10);

    }
}
