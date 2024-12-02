package com.example.honolulu_fullstack_individuel_opgave.Model;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age; // Age field
    private String carType; // Car type field (Luxury, Family, Sports)
    private String driversLicenseId;

    // Default constructor
    public Customer() {
    }

    // Constructor to initialize all fields
    public Customer(int customerId, String firstName, String lastName, String email, String phone, int age, String carType, String driversLicenseId) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.carType = carType;
        this.driversLicenseId = driversLicenseId;
    }

    // Constructor without customerId (for when creating a new customer)
    public Customer(String firstName, String lastName, String email, String phone, int age, String carType, String driversLicenseId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.carType = carType;
        this.driversLicenseId = driversLicenseId;
    }

    // Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getDriversLicenseId() {
        return driversLicenseId;
    }

    public void setDriversLicenseId(String driversLicenseId) {
        this.driversLicenseId = driversLicenseId;
    }

    // Override toString for easier debugging and logging
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", carType='" + carType + '\'' +
                ", driversLicenseId='" + driversLicenseId + '\'' +
                '}';
    }
}
