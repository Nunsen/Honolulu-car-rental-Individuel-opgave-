package com.example.honolulu_fullstack_individuel_opgave.Service;

import com.example.honolulu_fullstack_individuel_opgave.Model.Car;
import com.example.honolulu_fullstack_individuel_opgave.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    //Test metode for at se om der var hul igennem til min database
    //Bruges kun når man trykker på min testknap og printer alle biler i databasen.
    public List<Car> fetchAllCars() {
        List<Car> cars = carRepo.fetchAllCars();
        for (Car element : cars) {
            System.out.println(element);
        }
        return cars;
    }

    // Metode til at hente/printe biler baseret på startDate, endDate, carType.
    public List<Car> findAvailableCars(Date startDate, Date endDate, String carType) {
        List<Car> availableCars = carRepo.fetchAvailableCars(startDate, endDate, carType);
        for (Car car : availableCars) {
            System.out.println(car);
        }
        return availableCars;
    }

    // Method to fetch car by its ID
    public Car getCarById(int carId) {
        return carRepo.getCarById(carId); // Fetch a car by its ID
    }
}

