package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static com.techelevator.movies.MovieDBCLI.appendTextBasedUponWildcard;
import static com.techelevator.movies.MovieDBCLI.constructSQL;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {

        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT * FROM collection";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            collections.add(mapToCollection(results));
        }

        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        String sql = "SELECT * FROM collection WHERE collection_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapToCollection(results);
        }

        return null;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();
        name = appendTextBasedUponWildcard(name, useWildCard);
        String sqlTemplate = "SELECT * FROM collection WHERE collection_name $";
        String sql = constructSQL(sqlTemplate, "$", useWildCard, true);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);

        while (results.next()) {
            collections.add(mapToCollection(results));
        }

        return collections;

    }

    private Collection mapToCollection(SqlRowSet results) {
        Collection collection = new Collection();
        collection.setId(results.getInt("collection_id"));
        collection.setName(results.getString("collection_name"));

        return collection;
    }
}
