package com.techelevator.dao;

import com.techelevator.model.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcStateDao implements StateDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStateDao(DataSource dataSource) {
        //take the data source passed in to the constructor and
        //pass it to the jdbc template constructor
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public State getStateByAbbreviation(String stateAbbreviation) {
        State state = new State();
        String sql = "SELECT state_abbreviation, state_name FROM state WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        if (results.next()) {
//            state = mapRowToState(results);

            state.setStateAbbreviation(results.getString("state_abbreviation"));
            state.setStateName(results.getString("state_name"));
        }
        return state;
    }

    @Override
    public State getStateByCapital(int cityId) {
        State state = null;
        String sql = "SELECT state_abbreviation, state_name FROM state WHERE capital = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
        while (results.next()) {
            state = mapRowToState(results);
        }
        return state;
    }

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<>();
        String sql = "SELECT state_abbreviation, state_name FROM state;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            states.add(mapRowToState(results));
        }
        return states;
    }

    private State mapRowToState(SqlRowSet rowSet) {
        State state = new State();
        state.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        state.setStateName(rowSet.getString("state_name"));
        return state;
    }
}
