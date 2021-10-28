package it.unive.dais.po1.vehicles;

public class ExtendedRace extends Race {

    public static int race(Vehicle v1, Vehicle v2, double length) {
        System.out.println("Racing in the extended version of Race!!!");
        return Race.race(v1, v2, length);
    }
}
