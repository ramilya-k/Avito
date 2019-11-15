package ru.itpark.service;

import ru.itpark.model.House;
import ru.itpark.util.JdbcTemplate;

import java.sql.SQLException;
import java.util.*;


public class HouseService {
    private Collection<House> houses;

    public List<House> getAll() throws SQLException {
        return JdbcTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, price, district, underground FROM houses",
                resultSet -> (new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getString("district"),
                        resultSet.getString("underground")
                )));
    }
    public List<House> sort(Comparator<House> comparator) throws SQLException {
        List<House> result = getAll();
        result.sort(comparator);
        return result;
    }
}