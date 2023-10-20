package com.techelevator.movies.dao;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.techelevator.movies.MovieDBCLI.appendTextBasedUponWildcard;
import static com.techelevator.movies.MovieDBCLI.constructSQL;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Genre> getGenres() {
        List<Genre> genres = new ArrayList<>();
        String sql = "SELECT * FROM genre";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            genres.add(mapToGenre(results));
        }
        return genres;
    }

    @Override
    public Genre getGenreById(int id) {
        String sql = "SELECT * FROM genre WHERE genre_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()) {
            return mapToGenre(results);
        }
        return null;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard){
        List<Genre> genres = new ArrayList<>();

        String sqlTemplate = "SELECT * FROM genre WHERE genre_name $";
        String finalSql = constructSQL(sqlTemplate, "$", useWildCard, true);
        name = appendTextBasedUponWildcard(name, useWildCard);

        SqlRowSet results = jdbcTemplate.queryForRowSet(finalSql, name);
        while (results.next()) {
            genres.add(mapToGenre(results));
        }

        return genres;

    }


    private Genre mapToGenre(SqlRowSet results) {
        Genre genre = new Genre();
        genre.setId(results.getInt("genre_id"));
        genre.setName(results.getString("genre_name"));
        return genre;
    }
}
