//package com.techelevator.movies.dao;
//
//import com.techelevator.movies.model.Genre;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class JdbcDAO<T> {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<T> getAll(String tableName, String classname) {
//        List<T> items = new ArrayList<>();
//        String sql = "SELECT * FROM " + tableName;
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            if (classname.equals("JdbcGenreDao")){
//                items.add(mapToitem(results, classname));
//            }
//        }
//        return items;
//    }
//
//    private T mapToitem(SqlRowSet results, String classname ) {
//        if (classname.equals("JdbcGenreDao")){
//            Genre genre = new Genre();
//            genre.setId(results.getInt("genre_id"));
//            genre.setName(results.getString("genre_name"));
//            return (T) genre;
//        }
//    }
//}
