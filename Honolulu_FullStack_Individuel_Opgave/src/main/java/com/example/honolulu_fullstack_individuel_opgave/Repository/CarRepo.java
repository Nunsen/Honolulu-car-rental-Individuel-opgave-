package com.example.honolulu_fullstack_individuel_opgave.Repository;

import com.example.honolulu_fullstack_individuel_opgave.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class CarRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Test metode for at se om der var hul igennem til min database. Hente/printe alle biler fra databasen.
    public List<Car> fetchAllCars() {
        String sql = "SELECT * FROM Cars"; // SQL query to fetch all cars
        RowMapper<Car> rowMapper = (rs, rowNum) -> new Car(
                rs.getInt("car_id"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getDouble("daily_rate"),
                rs.getBoolean("available"),
                rs.getString("car_type")
        );
        return jdbcTemplate.query(sql, rowMapper); // udfører query og mapper resultatet som objekter i en liste/table
    }

    //Henter/printer biler baseret på om de er available (startDate, endDate) og carType.
    //opretter listen af bil objekter hvor de available cars ryger ind i.
    public List<Car> fetchAvailableCars(Date startDate, Date endDate, String carType) {
        // SQL query to select cars based on availability and type
        String sql = "SELECT c.* FROM Cars c " +
                "WHERE c.available = TRUE " +
                "AND c.car_type = ? " +
                "AND c.car_id NOT IN ( " +
                "    SELECT b.car_id FROM Bookings b " +
                "    WHERE (b.start_date BETWEEN ? AND ?) " +
                "    OR (b.end_date BETWEEN ? AND ?) " +
                "    OR (? BETWEEN b.start_date AND b.end_date) " +
                "    OR (? BETWEEN b.start_date AND b.end_date) " +
                ")";

        RowMapper<Car> rowMapper = (rs, rowNum) -> new Car(
                rs.getInt("car_id"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getDouble("daily_rate"),
                rs.getBoolean("available"),
                rs.getString("car_type")
        );

        return jdbcTemplate.query(sql, rowMapper, carType, startDate, endDate, startDate, endDate, startDate, endDate);
    }

    // metode til at finde bil gennem ID.
    public Car getCarById(int carId) {
        String sql = "SELECT * FROM Cars WHERE car_id = ?";
        RowMapper<Car> rowMapper = (rs, rowNum) -> new Car(
                rs.getInt("car_id"),
                rs.getString("make"),
                rs.getString("model"),
                rs.getInt("year"),
                rs.getString("color"),
                rs.getDouble("daily_rate"),
                rs.getBoolean("available"),
                rs.getString("car_type")
        );
        return jdbcTemplate.queryForObject(sql, rowMapper, carId); // Fetch single car by its ID
    }
}
