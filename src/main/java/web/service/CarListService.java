package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CarListService {

    private final List<Car> cars;

    @SuppressWarnings("SpellCheckingInspection")
    public CarListService() {
        this.cars = Arrays.asList(
                new Car("Corolla", "Передний", 195),
                new Car("Avensis", "Передний", 180),
                new Car("Camry", "Передний", 210),
                new Car("C-HR", "Полный", 180),
                new Car("FJ Cruiser", "Полный", 180));
    }

    public Stream<Car> getNCars(int count) {
        System.out.println("count = " + count);
        System.out.println("cars = " + cars);
        return cars.stream().limit(count);
    }
}
