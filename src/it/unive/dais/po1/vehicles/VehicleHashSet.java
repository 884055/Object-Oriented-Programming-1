package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.animals.AnimalCart;
import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.FuelTypeCache;
import it.unive.dais.po1.vehicles.autovehicles.Truck;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

import java.util.HashMap;
import java.util.HashSet;

public class VehicleHashSet<T extends Vehicle> extends HashSet<T> {

    public Vehicle race(double length) throws ImpossibleAccelerationException {
        for(Vehicle v : this) {
            v.fullBrake();
        }
        HashMap<Vehicle, Double> distance = new HashMap<>();
        for(Vehicle v : this) {
            distance.put(v, 0.0);
        }
        //Tutti i veicoli sono sulla linea di partenza

        while(true) {
            for(Vehicle v : this)
                distance.put(v, distance.get(v)+v.getSpeed());
            for(Vehicle v : this)
                if(distance.get(v) >= length)
                    return v;
            for(Vehicle v : this)
                v.accelerate(Math.random()*10.0);
        }
    }

    public static void main(String[] args) throws ImpossibleAccelerationException {
        FuelTypeCache cache = new FuelTypeCache();
        VehicleHashSet<Vehicle> set = new VehicleHashSet<Vehicle>();
        FuelType diesel = cache.put("diesel", 1.4, 0.01);
        FuelType petrol = cache.put("petrol", 1.5, 0.015);
        Car yourCar = new Car(0, cache.getFuelTypeFromName("petrol"));
        Car myCar = new Car(0, cache.getFuelTypeFromName("petrol"));
        Bicycle myBicycle = new Bicycle(10);
        Truck myTruck = new Truck(0, diesel);
        AnimalCart myCart = new AnimalCart(0, 0);

        set.add(yourCar);
        set.add(myCar);
        set.add(myBicycle);
        set.add(myTruck);
        set.add(myCart);
        Vehicle winner = set.race(100.0);

    }
}
