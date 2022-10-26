package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.Model.Car;
import web.Service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count",required = false) Integer count, Model model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1,"name_1","color_1"));
        cars.add(new Car(2,"name_2","color_2"));
        cars.add(new Car(3,"name_3","color_3"));
        cars.add(new Car(4,"name_4","color_4"));
        cars.add(new Car(5,"name_5","color_5"));
        if (count != null) {
            cars = CarServiceImpl.getCarsByCount(cars, count);
        }
        model.addAttribute("cars",cars);
        return "cars";
    }
}
