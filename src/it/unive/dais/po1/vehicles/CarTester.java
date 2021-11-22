package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.TestException;
import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;
import org.junit.jupiter.api.Test;

public class CarTester {
    @Test
    public void testAccelerate() throws ImpossibleAccelerationException, TestException {
        Car myCar = new Car(0, new FuelType("diesel", 0.015, 0.01));
        myCar.refuel(10.0);
        myCar.accelerate(10.0);
        assert myCar.getSpeed()==11.0;
    }
}
