package org.ahant.dao.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginDaoImpl implements LoginDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Environment env;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String getPassword(String username) {
        String[] args = {username};
        String password = (String) jdbcTemplate.queryForObject(env.getProperty("query.user.get.password"), args, String.class);
        return password;
    }
}
