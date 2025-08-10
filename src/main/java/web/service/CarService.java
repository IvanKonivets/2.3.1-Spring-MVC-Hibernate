package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("BMW", "X5", 2021));
        cars.add(new Car("Honda", "Civic", 2019));
        cars.add(new Car("Audi", "Q7", 2022));
        cars.add(new Car("Ford", "Focus", 2020));
        cars.add(new Car("Lada", "Granta", 2018));
    }

    public List<Car> getCars(int count) {
        if (cars.size() <= count) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
