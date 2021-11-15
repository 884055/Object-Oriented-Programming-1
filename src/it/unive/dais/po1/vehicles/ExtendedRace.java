package it.unive.dais.po1.vehicles;

public class ExtendedRace extends Race {

    public ExtendedRace(Vehicle v1, Vehicle v2) {
        super(v1, v2);
    }

    public static int race(Vehicle v1, Vehicle v2, double length) throws ImpossibleAccelerationException {
        System.out.println("Racing in the extended version of Race!!!");
        return Race.race(v1, v2, length);
    }
}
