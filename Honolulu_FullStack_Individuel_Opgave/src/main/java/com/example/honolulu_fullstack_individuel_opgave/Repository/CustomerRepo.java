package com.example.honolulu_fullstack_individuel_opgave.Repository;

import com.example.honolulu_fullstack_individuel_opgave.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save a new customer into the database
    public void saveCustomer(Customer customer) {
        String sql = "INSERT INTO Customers (first_name, last_name, email, phone, age, car_type, drivers_license_ID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getPhone(), customer.getAge(), customer.getCarType(), customer.getDriversLicenseId());
    }

    // Fetch all customers from the database (for testing purposes)
    public List<Customer> fetchAllCustomers() {
        String sql = "SELECT * FROM Customers";
        RowMapper<Customer> rowMapper = (rs, rowNum) -> new Customer(
                rs.getInt("customer_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone"),
                rs.getInt("age"),
                rs.getString("car_type"),
                rs.getString("drivers_license_ID")
        );
        return jdbcTemplate.query(sql, rowMapper);
    }
}
