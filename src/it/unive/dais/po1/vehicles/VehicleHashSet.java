package it.unive.dais.po1.vehicles;

import it.unive.dais.po1.vehicles.animals.AnimalCart;
import it.unive.dais.po1.vehicles.animals.HorseCart;
import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.FuelTypeCache;
import it.unive.dais.po1.vehicles.autovehicles.Truck;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) throws ImpossibleAccelerationException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Collection<Class> allVehicles = getAllVehiclesClasses();
        for(Class c : allVehicles)
            System.out.println(c.getName());
        VehicleHashSet<Vehicle> allInstatiatedVehicles = new VehicleHashSet();
        for(Class c : allVehicles) {
            Vehicle v = createInstanceOf(c);
            if(v!=null)
                allInstatiatedVehicles.add(v);
            else
                System.err.println("Unable to instantiate vehicle "+c.getName());
        }
        for(Vehicle v : allInstatiatedVehicles)
            System.out.println(v);
        refuel(allInstatiatedVehicles);
        System.out.println("The winner is "+allInstatiatedVehicles.race(100.0));


    }

    private static void refuel(VehicleHashSet<Vehicle> allInstatiatedVehicles) {
        for(Vehicle v : allInstatiatedVehicles)
            if(v instanceof Car)
                ((Car) v).refuel(20.0);
    }

    private static Vehicle createInstanceOf(Class c) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        external: for(Constructor constructor : c.getConstructors()) {
            constructor.setAccessible(true);
            Parameter[] parameters = constructor.getParameters();
            Object[] parametersValues = new Object[parameters.length];
            for(int i = 0; i < parameters.length; i++) {
                Object o = getConcreteValue(parameters[i].getType());
                if(o!=null)
                    parametersValues[i] = o;
                else
                    continue external;
            }
            //We have values for all parameters
            return (Vehicle) constructor.newInstance(parametersValues);
        }
        return null;
    }

    static private Object getConcreteValue(Class<?> type) {
        if(type.equals(FuelType.class))
            return new FuelType("diesel", 0.015, 0.10);
        if(type.equals(double.class) || type.equals(Double.class))
            return Double.valueOf(0.0);
        if(type.equals(int.class) || type.equals(Integer.class))
            return Integer.valueOf(0);
        return null;
    }

    static private Collection<Class> getAllVehiclesClasses() {
        HashSet<Class> result = new HashSet<>();
        Reflections reflections = new Reflections("it.unive.dais.po1.vehicles");
        Set<Class<? extends Vehicle>> allClasses =
                reflections.getSubTypesOf(Vehicle.class);
        result.addAll(allClasses);
        return result;
    }
}
