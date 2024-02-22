package org.prog.collections;

import java.util.*;

/**

 Write HashMap of owned cars, set their colors using enum you create
 print owners of cars of certain color
 */
public class HomeWork {

    public static void main(String[] args) {


        Map<String, List<Car>> carOwners = new HashMap<>();

        carOwners.put("Alex", new ArrayList<>());
        List<Car> alexCars = carOwners.get("Alex");
        alexCars.add(new Car(Color.WHITE));
        alexCars.add(new Car(Color.BLACK));

        carOwners.put("Boris", new ArrayList<>());
        List<Car> borisCars = carOwners.get("Boris");
        borisCars.add(new Car(Color.WHITE));
        borisCars.add(new Car(Color.CRIMSON));

        carOwners.put("Clara", new ArrayList<>());
        List<Car> claraCars = carOwners.get("Clara");
        claraCars.add(new Car(Color.EGGPLANT));
        claraCars.add(new Car(Color.CRIMSON));
        claraCars.add(new Car(Color.WHITE));

        System.out.println("White car owners:");
        for (String owner : carOwners.keySet()) {
            List<Car> cars = carOwners.get(owner);
            for (Car car : cars) {
                if (car.getColor() == Color.WHITE) {
                    System.out.println(owner);
                    break;
                }
            }
        }
    }
}
