package com.example.honolulu_fullstack_individuel_opgave.Model;

public class Car {
    private int carId;
    private String make;
    private String model;
    private int year;
    private String color;
    private double dailyRate;
    private boolean available;
    private String carType;

    // tom konstruktør
    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", dailyRate=" + dailyRate +
                ", available=" + available +
                ", carType='" + carType + '\'' +
                '}';
    }

    // konstruktør med parametre
    public Car(int carId, String make, String model, int year, String color, double dailyRate, boolean available, String carType) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.dailyRate = dailyRate;
        this.available = available;
        this.carType = carType;
    }

    // Getters and Setters
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}

