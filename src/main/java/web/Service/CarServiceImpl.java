package web.Service;

import web.Model.Car;

import java.util.List;

public class CarServiceImpl {
    static public List<Car> getCarsByCount(List<Car> cars, int count) {
        return cars.stream().limit(count).toList();
    }
}
