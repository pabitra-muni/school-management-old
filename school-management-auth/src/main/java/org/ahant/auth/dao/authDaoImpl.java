package org.ahant.auth.dao;

import org.ahant.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by ahant on 3/19/2016.
 */
public class authDaoImpl implements authDao {

    private JdbcTemplate jdbcTemplate;
    private String userPasswordQuery;
    private String userDetailQuery;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String getPassword(String username) {
        String[] args = {username};
        return jdbcTemplate.queryForObject(getUserPasswordQuery(), args, String.class);
    }

    @Override
    public User getUserDetails(String username) {
        String[] args = {username};
        return jdbcTemplate.queryForObject(getUserDetailQuery(), args, User.class);
    }

    public String getUserPasswordQuery() {
        return userPasswordQuery;
    }

    public void setUserPasswordQuery(String userPasswordQuery) {
        this.userPasswordQuery = userPasswordQuery;
    }


    public String getUserDetailQuery() {
        return userDetailQuery;
    }

    public void setUserDetailQuery(String userDetailQuery) {
        this.userDetailQuery = userDetailQuery;
    }
}
