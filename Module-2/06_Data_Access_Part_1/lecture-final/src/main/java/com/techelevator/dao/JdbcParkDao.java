package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int countOfParks = 0;
        String sql = "SELECT COUNT(*) AS count_of_parks FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            countOfParks = results.getInt("count_of_parks");
        }
        return countOfParks;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate oldestParkDateEst = null;
        String sql = "SELECT MIN(date_established) AS oldest_park \n" +
                "FROM park;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if(results.next()){
            oldestParkDateEst = results.getDate("oldest_park").toLocalDate();
        }
        return oldestParkDateEst;
    }
    
    @Override
    public double getAverageParkArea() {
        return 0.0;
    }
    
    @Override
    public List<String> getParkNames() {
        return new ArrayList<>();
    }
    
    @Override
    public Park getRandomPark() {
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {
        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping\n" +
                "FROM park\n" +
                "WHERE park_name ILIKE ?;";

        //need to swap out the string name so that is looks like this %name%
        if(useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()){ 
            Park park = new Park();
            park.setParkId(results.getInt("park_id"));
            park.setParkName(results.getString("park_name"));
            park.setDateEstablished(results.getDate("date_established").toLocalDate());
            park.setArea(results.getDouble("area"));
            park.setHasCamping(results.getBoolean("has_camping"));
            parks.add(park);
        }
        return parks;
    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        return new Park();
    }
}
