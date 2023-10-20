package com.techelevator.movies.dao;

import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.movies.MovieDBCLI;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.techelevator.movies.MovieDBCLI.appendTextBasedUponWildcard;
import static com.techelevator.movies.MovieDBCLI.constructSQL;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movieList = new ArrayList<>();

        String sqlTemplate = "SELECT * FROM movie";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlTemplate);
        while(results.next()) {
            movieList.add(mapToMovie(results));
        }
        return movieList;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT *\n" +
                "FROM movie\n" +
                "WHERE movie_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movieList = new ArrayList<>();

        title = appendTextBasedUponWildcard(title, useWildCard);

        String sqlTemplate = "SELECT * FROM movie WHERE title $";
        String sql = constructSQL(sqlTemplate, "$", useWildCard, true);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, title);
        while (results.next()) {
            movieList.add(mapToMovie(results));
        }
        return movieList;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        List<Movie> movieList = new ArrayList<>();

        directorName = appendTextBasedUponWildcard(directorName, useWildCard);

        LocalDate StartYear = LocalDate.of(startYear, 1, 1);
        LocalDate EndYear = LocalDate.of(endYear, 12, 31);

        String sqlTemplate = "SELECT * FROM movie " +
                "JOIN person ON movie.director_id = person.person_id WHERE person_name $ AND movie.release_date " +
                "BETWEEN ? AND ? ORDER BY release_date ASC;";
        String sql = constructSQL(sqlTemplate, "$", useWildCard, false);
        System.out.println(sql);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, directorName, StartYear, EndYear);

        while(results.next()) {
            movieList.add(mapToMovie(results));
        }
        return movieList;
    }

    public Movie mapToMovie(SqlRowSet results) {
        Movie movie = new Movie();
        System.out.println(results.toString());

        movie.setId(results.getInt("movie_id"));
        movie.setTitle(results.getString("title"));
        movie.setOverview(results.getString("overview"));
        movie.setTagline(results.getString("tagline"));
        movie.setPosterPath(results.getString("poster_path"));
        movie.setHomePage(results.getString("home_page"));

        if (results.getDate("release_date") != null) {
            movie.setReleaseDate(results.getDate("release_date").toLocalDate());
        }

        movie.setLengthMinutes(results.getInt("length_minutes"));
        movie.setDirectorId(results.getInt("director_id"));
        movie.setCollectionId(results.getInt("collection_id"));
        System.out.println(movie);

        return movie;
    }

}
