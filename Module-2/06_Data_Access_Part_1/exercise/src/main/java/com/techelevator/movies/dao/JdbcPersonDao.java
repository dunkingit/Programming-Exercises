package com.techelevator.movies.dao;

import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    //person_id, person_name, birthday, deathday, biography, profile_path, home_page

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public Person getPersonById(int id) {
        System.out.println("ID is " + id);
        String sql = "select * from person where person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        return results.next()? mapToPerson(results):new Person();
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        name = useWildCard? "%" + name + "%":name;
        System.out.println(name);
        String sql = "select * from person where person_name ilike ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()) {
            personList.add(mapToPerson(results));
        }
        return personList;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        return null;
    }

    //person_id, person_name, birthday, deathday, biography, profile_path, home_page
    public Person mapToPerson (SqlRowSet results){
        Person person = new Person();
        person.setBiography(results.getString("biography"));
        if(results.getDate("birthday") != null) {
            person.setBirthday(results.getDate("birthday").toLocalDate());
        }
        if(results.getDate("deathday") != null) {
            person.setDeathDate(results.getDate("deathday").toLocalDate());
        }
        person.setHomePage(results.getString("home_page"));
        person.setName(results.getString("person_name"));
        person.setProfilePath(results.getString("profile_path"));
        person.setId(results.getInt("person_id"));
        System.out.println(person);
        System.out.println(results.getString("person_name"));
        return person;
    }
}
