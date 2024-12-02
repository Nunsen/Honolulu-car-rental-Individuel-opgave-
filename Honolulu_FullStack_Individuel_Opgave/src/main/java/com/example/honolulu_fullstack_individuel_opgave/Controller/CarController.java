package com.example.honolulu_fullstack_individuel_opgave.Controller;

import com.example.honolulu_fullstack_individuel_opgave.Model.Car;
import com.example.honolulu_fullstack_individuel_opgave.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/home/cars")
    public String getAllCars(Model model) {
        List<Car> cars = carService.fetchAllCars(); // Get all cars
        model.addAttribute("cars", cars); // Add the cars to the model
        return "home/cars"; // Return the view (Thymeleaf template)
    }
}
