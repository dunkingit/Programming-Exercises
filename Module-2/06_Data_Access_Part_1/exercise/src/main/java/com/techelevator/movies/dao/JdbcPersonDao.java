package com.techelevator.movies.dao;

import com.techelevator.movies.MovieDBCLI;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.techelevator.movies.MovieDBCLI.appendTextBasedUponWildcard;

public class JdbcPersonDao implements PersonDao {
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
        String sql = "select * from person where person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        return results.next()? mapToPerson(results):null;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        name = useWildCard? "%" + name + "%":name;
        String sql = "select * from person where person_name ilike ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while(results.next()) {
                personList.add(mapToPerson(results));
        }
        return personList;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        List<Person> personList = new ArrayList<>();
        collectionName = appendTextBasedUponWildcard(collectionName, useWildCard);
        String name = "SELECT *\n" +
                "FROM person\n" +
                "join movie_actor on person.person_id = movie_actor.actor_id\n" +
                "join movie on movie_actor.movie_id = movie.movie_id\n" +
                "join collection on movie.collection_id = collection.collection_id\n" +
                "WHERE collection_name $";
        String newString = MovieDBCLI.constructSQL(name, "$", useWildCard, true);
        String sql = newString;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, collectionName);
        while(results.next()) {
            personList.add(mapToPerson(results));
        }
        return personList;
    }

    //person_id, person_name, birthday, deathday, biography, profile_path, home_page
    public Person mapToPerson (SqlRowSet results){
        Person person = new Person();
        person.setBiography(results.getString("biography"));
        if (results.getDate("birthday") != null) {
            person.setBirthday(results.getDate("birthday").toLocalDate());
        }
        if(results.getDate("deathday") != null) {
            person.setDeathDate(results.getDate("deathday").toLocalDate());
        }
        person.setHomePage(results.getString("home_page"));
        person.setName(results.getString("person_name"));
        person.setProfilePath(results.getString("profile_path"));
        person.setId(results.getInt("person_id"));
        return person;
    }
}
