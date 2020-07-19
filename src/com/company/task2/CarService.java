package com.company.task2;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarService {
    public static void main(String[] args) {

        Car car1 = new Car("Daewoo", "Lanos", new BigDecimal(2000), Year.of(1998), EngineType.R3);
        Car car2 = new Car("Fiat", "Bravo", new BigDecimal(12000), Year.of(2010), EngineType.R6);
        Car car3 = new Car("Ford", "Fiesta", new BigDecimal(7000), Year.of(2006), EngineType.R4);
        Car car4 = new Car("Honda", "Civic", new BigDecimal(30000), Year.of(2016), EngineType.V6);
        Car car5 = new Car("BMW", "z3", new BigDecimal(70000), Year.of(2017), EngineType.V12);
        Car car6 = new Car("Ford", "Focus", new BigDecimal(80000), Year.of(2019), EngineType.V8);
        Car car7 = new Car("Fiat", "Bravo", new BigDecimal(8000), Year.of(2008), EngineType.R4);

        List<Car> carsList = new ArrayList<>();
        //podpunkt 1
        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);
        carsList.add(car6);
        carsList.add(car7);
        carsList.add(car7);

        //podpunkt 2
        carsList.remove(carsList.size() - 1);

        //podpunkt 3
        System.out.println("Cars on list");
        displayList(carsList);

        //podpunkt 4
        List<Car> carsWithV12Engine = carsList.stream()
                .filter(car -> car.engineType.equals(EngineType.V12))
                .collect(Collectors.toList());
        System.out.println("Cars with V12 Engine");
        displayList(carsWithV12Engine);

        //podpunkt 5
        List<Car> manufacturedCarsBefore1999 = carsList.stream()
                .filter(car -> car.getProductionYear().isBefore(Year.of(1999)))
                .collect(Collectors.toList());
        System.out.println("Manufactured cars before 1999");
        displayList(manufacturedCarsBefore1999);

        //podpunkt 6
        Optional<Car> mostExpensiveCar = carsList.stream()
                .max((a, b) -> a.getPrice().compareTo(b.getPrice()));
        System.out.println("Most expensive car is: ");
        System.out.println(mostExpensiveCar.orElse(new Car()));
        System.out.println();

        //podpunkt 7
        Optional<Car> cheapestCar = carsList.stream()
                .min((a, b) -> a.getPrice().compareTo(b.getPrice()));
        System.out.println("Cheapest car is: ");
        System.out.println(cheapestCar.orElse(new Car()));
        System.out.println();

        //podpunkt 8
        List<Car> wantedCars = carsList.stream()
                .filter(car -> car.getModel().equals("Bravo"))
                .filter(car -> car.getProductionYear().equals(Year.of(2010)))
                .filter(car -> car.getPrice().equals(new BigDecimal(12000)))
                .collect(Collectors.toList());
        System.out.println("Your wanted cars");
        displayList(wantedCars);

        //podpunkt 9
        List<Car> givenManufacturer = carsList.stream()
                .filter(car -> car.getName().equals("Ford"))
                .collect(Collectors.toList());
        System.out.println("All Ford cars");
        displayList(givenManufacturer);

        //podpunkt 10
        CarService carService = new CarService();
        List<Car> carStringModel = carService.method("Bravo", carsList);
        List<Car> carStringName = carService.method("Ford", carsList);
        List<Car> carBigDecimal = carService.method(new BigDecimal(12000), carsList);
        List<Car> carYear = carService.method(Year.of(2019), carsList);
        List<Car> carEngine = carService.method(EngineType.V12, carsList);

        System.out.println("Barvo models (generic method)");
        displayList(carStringModel);
        System.out.println("All Ford cars (generic method)");
        displayList(carStringName);
        System.out.println("Cars with 12000 value (generic method)");
        displayList(carBigDecimal);
        System.out.println("Cars produced in 1999 (generic method)");
        displayList(carYear);
        System.out.println("Cars with V12 engine (generic method)");
        displayList(carEngine);


    }
     <T> List<Car> method(T t, List<Car> lista){
        if(t instanceof String){
            List<Car> list1 = lista.stream()
                    .filter(car -> car.getName().equals(t))
                    .collect(Collectors.toList());
            List<Car> list2 = lista.stream()
                    .filter(car -> car.getModel().equals(t))
                    .collect(Collectors.toList());
            list1.addAll(list2);
            return list1;
        }
        if(t instanceof Year){
            return lista.stream()
                    .filter(car -> car.getProductionYear().equals(t))
                    .collect(Collectors.toList());
        }
         if(t instanceof BigDecimal){
             return lista.stream()
                     .filter(car -> car.getPrice().equals(t))
                     .collect(Collectors.toList());
         }
         if(t instanceof EngineType){
             return lista.stream()
                     .filter(car -> car.getEngineType().equals(t))
                     .collect(Collectors.toList());
         }
         return null;
    }


    static void displayList(List<Car> list) {
        for (Car c : list
        ) {
            System.out.println(c);
        }
        System.out.println();
    }
}
