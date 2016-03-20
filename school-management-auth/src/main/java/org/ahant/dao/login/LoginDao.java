package org.ahant.dao.login;

import org.ahant.model.login.User;

/**
 * Created by ahant on 3/19/2016.
 */
public interface LoginDao {

    String getPassword(String userName);
}
