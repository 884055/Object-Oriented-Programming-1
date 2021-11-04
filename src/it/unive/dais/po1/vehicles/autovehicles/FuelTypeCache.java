package it.unive.dais.po1.vehicles.autovehicles;

import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

import java.util.HashMap;

public class FuelTypeCache {
    private HashMap<String, FuelType> map = new HashMap<String, FuelType>();
    public FuelType getFuelTypeFromName(String n) {
        return map.get(n);
    }
    public FuelType put(String n, double costPerLiter, double kmhperLiter) {
        FuelType value = new FuelType(n, costPerLiter, kmhperLiter);
        map.put(n, value);
        return value;
    }
}

