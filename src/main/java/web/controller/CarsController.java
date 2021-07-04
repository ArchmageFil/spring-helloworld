package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarListService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CarsController {
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") String countParam, ModelMap modelMap, CarListService carService) {
        int count = Integer.parseInt(countParam);
        List<String> cars = carService.getNCars(count).map(Car::toString)
                .collect(Collectors.toList());
        modelMap.addAttribute("cars", cars);
        cars.forEach(System.out::println);
        return "cars";
    }
}