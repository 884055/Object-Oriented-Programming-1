package it.unive.dais.po1.vehicles.autovehicles.fuel;

import it.unive.dais.po1.vehicles.ImpossibleAccelerationException;

public class FuelNotSufficientException extends ImpossibleAccelerationException {
    public FuelNotSufficientException(double fuelConsumed, double fuel) {
        super("The fuel was not enough: consumed "+fuelConsumed+", in the tank there was "+fuel);
    }
}
