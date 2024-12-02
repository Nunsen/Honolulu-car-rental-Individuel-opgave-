package com.example.honolulu_fullstack_individuel_opgave.Controller;

import com.example.honolulu_fullstack_individuel_opgave.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookingController {

    @Autowired
    private CarService carService;

    // Display booking page after selecting a car
    @GetMapping("/home/booking")
    public String loadBookingPage(@RequestParam("carId") int carId,
                                  @RequestParam("dailyRate") double dailyRate,
                                  @RequestParam("carType") String carType,
                                  Model model) {
        model.addAttribute("carId", carId);
        model.addAttribute("dailyRate", dailyRate);
        model.addAttribute("carType", carType);
        return "home/booking";
    }

    // Endpoint to handle the receipt submission
    @PostMapping("/home/receipt")
    public String handleReceipt(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("age") int age,
                                @RequestParam("driversLicenseId") String driversLicenseId,
                                @RequestParam("carId") int carId,
                                @RequestParam("carType") String carType,
                                @RequestParam("dailyRate") double dailyRate,
                                Model model) {

        // Add customer and car details to the model for the receipt page
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("phone", phone);
        model.addAttribute("age", age);
        model.addAttribute("driversLicenseId", driversLicenseId);
        model.addAttribute("carId", carId);
        model.addAttribute("carType", carType);
        model.addAttribute("dailyRate", dailyRate); // Just pass the daily rate

        return "home/receipt"; // Return the receipt page
    }
}