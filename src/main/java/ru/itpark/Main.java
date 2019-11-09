package ru.itpark;


import ru.itpark.model.House;
import ru.itpark.service.HouseService;
import ru.itpark.util.JdbcTemplate;

import java.sql.*;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        List<House> houses = JdbcTemplate.<House>executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, price, district, underground FROM houses",
                resultSet -> new House(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getString("district"),
                        resultSet.getString("underground")
                )
        );
        System.out.println(houses);

        HouseService service = new HouseService();
        List<House> housesByPriceAsc = service.sort(Comparator.comparingInt(House::getPrice));
        System.out.println(housesByPriceAsc);
        List<House> housesByPriceDesc = service.sort((o1, o2) -> o2.getPrice() - o1.getPrice());
        System.out.println(housesByPriceDesc);
    }
}
