package it.unive.dais.po1.util;

import it.unive.dais.po1.vehicles.Bicycle;
import it.unive.dais.po1.vehicles.Vehicle;
import it.unive.dais.po1.vehicles.autovehicles.Car;
import it.unive.dais.po1.vehicles.autovehicles.Truck;
import it.unive.dais.po1.vehicles.autovehicles.fuel.FuelType;

import java.util.Arrays;

public class List<V> {
    private V[] elements;
    public void add(V el) {
        V temp = el;
        int n = elements.length+1;
        elements = Arrays.copyOf(elements, n);
        elements[n-1] = temp;
    }
    public boolean contains(V el) {
        for(int i=0; i < elements.length; i++)
            if(elements[i]==el)
                return true;
        return false;
    }
    public V get(int i) {
        return elements[i];
    }

    public static <T> List<T> toList(T value) {
        List<T> result = new List<T>();
        result.add(value);
        return result;
    }

    public static <T> T getFirst(List<T> list) {
        return list.get(0);
    }


    public static void main(String[] args) {
        /*List<Vehicle> listv = new List<Vehicle>();
        List<Bicycle> listb = new List<Bicycle>();
        List<Vehicle> listv2 = listv;
        listv2 = listb;

        Bicycle b = listb.get(0);
        listb.add(new Bicycle(0));
        listv2.add(new Car(0, new FuelType("petrol", 1.4, 0.01)));
        listb.add(new Car(0, new FuelType("petrol", 1.4, 0.01)));

        listb = listv2;
        listv2.add(new Car(0, new FuelType("petrol", 1.4, 0.01)));
        Bicycle b1 = listb.get(0);
        */
/*
        Vehicle[] v = new Vehicle[1];
        Bicycle[] b = new Bicycle[1];

        v[0] = new Car(0, new FuelType("petrol", 1.4, 0.01));
        b[0] = new Bicycle(0);

        v = b;
        v[0] = new Car(0, new FuelType("petrol", 1.4, 0.01));
        Bicycle b1 = b[0];

        List<Car> c = List.<Car>toList(new Truck(0, new FuelType("petrol", 1.4, 0.01)));
        Car c1 = List.<Car>getFirst(c);

        List<Vehicle> v1 = new List<>();

        Car c2 = List.getFirst(c);

        List<Vehicle> lt = List.<Vehicle>toList(new Truck(0, new FuelType("petrol", 1.4, 0.01)));

*/

  /*      List<Car> v = new List<Car>();
        List<?> q = v;
        List<Vehicle> w2 = v;
        List<? extends Vehicle> w = v;

        Car e = q.get(0); // error
        q.add(new Car(0, new FuelType("petrol", 1.4, 0.01))); // error
        Vehicle e1 = w.get(0); // OK
        w.add(new Car(0, new FuelType("petrol", 1.4, 0.01))); // error
        v.add(new Truck(0, new FuelType("petrol", 1.4, 0.01))); // OK
        v.add(new Car(0, new FuelType("petrol", 1.4, 0.01))); // error
*/


    }
}