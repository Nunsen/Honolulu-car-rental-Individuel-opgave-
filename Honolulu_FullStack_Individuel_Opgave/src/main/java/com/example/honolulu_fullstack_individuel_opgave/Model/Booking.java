package com.example.honolulu_fullstack_individuel_opgave.Model;

public class Booking {
        private int bookingId;
        private Car car;
        private Customer customer;
        private String startDate;
        private String endDate;
        private double totalPrice;

        // tom constructor
        public Booking() {
        }

        // Constructor with parameters
        public Booking(int bookingId, Car car, Customer customer, String startDate, String endDate, double totalPrice) {
            this.bookingId = bookingId;
            this.car = car;
            this.customer = customer;
            this.startDate = startDate;
            this.endDate = endDate;
            this.totalPrice = totalPrice;
        }
        // Getters and Setters
        public int getReservationId() {
            return bookingId;
        }

        public void setReservationId(int reservationId) {
            this.bookingId = reservationId;
        }

        public Car getCar() {
            return car;
        }

        public void setCar(Car car) {
            this.car = car;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }
    }

