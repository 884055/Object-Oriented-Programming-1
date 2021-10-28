package it.unive.dais.po1.vehicles.autovehicles;

import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

import java.util.HashMap;

public class FuelTypeCache {
    HashMap<String, FuelType> map = new HashMap<String, FuelType>();
    FuelType getFuelTypeFromName(String n) {
        return map.get(n);
    }
}

