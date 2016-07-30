package org.ahant.auth.dao;

import org.ahant.auth.model.User;

/**
 * Created by ahant on 3/19/2016.
 */
public interface authDao {

    String getPassword(String userName);
    User getUserDetails(String username);
}
