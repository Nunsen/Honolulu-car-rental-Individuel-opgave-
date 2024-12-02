package com.example.honolulu_fullstack_individuel_opgave.Controller;

import com.example.honolulu_fullstack_individuel_opgave.Model.Car;
import com.example.honolulu_fullstack_individuel_opgave.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    // Hovedsiden
    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    //en test jeg lavede for at tjekke om der var hul igennem
    @GetMapping("/home/test")
    public String test() {
        return "home/test";
    }

    //FIND YOUR CAR knappen leder videre til findCar, som viser ledige biler
    //@RequestParam, binder query parametre startDate, endDate, carType fra URL'en til metode parametrene i metoden til at finde biler der passer kundens datoer + type.
    //Model objektet viderefører data til view (html siden), tillader at tilføje attributter, som en liste af biler som kan vises frontend.
    @GetMapping("/home/findCar")
    public String findCar(
            @RequestParam("startDate") String startDateString,
            @RequestParam("endDate") String endDateString,
            @RequestParam("carType") String carType,
            Model model) {


        //Date.valueOf(): konverterer den valgte dato fra YYYY-MM-DD til et date objekt som java kan bearbejde.
        //konvertere datoerne fra String til Date type
        Date startDate = Date.valueOf(startDateString);
        Date endDate = Date.valueOf(endDateString);

        //Kalder findAvailableCars metode fra carService, derinde kalder den carRepo.fetchAvailableCars, som har kontakt til databasen
        //Derinde er rowmapperen som tager de requested commando i de prepared statements og konverterer bilerne til objekter fra resultatsættet.
        List<Car> availableCars = carService.findAvailableCars(startDate, endDate, carType);

        //Tilføjer de ledige biler til model, associerer det med nøglen "cars".
        //Tillader the view (HTML page) at dynamically display listen af biler ved brug af Thymeleaf
        model.addAttribute("cars", availableCars);

        //Tager nu værdierne i URL med over i siden findCar, som viser bilerne der er ledige og af rigtig type.
        return "home/findCar";
    }

}
