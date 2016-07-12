package org.ahant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginDaoImpl implements LoginDao {

    private JdbcTemplate jdbcTemplate;
    private String userPasswordQuery;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String getPassword(String username) {
        String[] args = {username};
        return (String) jdbcTemplate.queryForObject(userPasswordQuery, args, String.class);
    }

    public String getUserPasswordQuery() {
        return userPasswordQuery;
    }

    public void setUserPasswordQuery(String userPasswordQuery) {
        this.userPasswordQuery = userPasswordQuery;
    }
}
