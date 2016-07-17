package org.ahant.auth.dao;

import org.ahant.core.util.cipher.Encryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by ahant on 3/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context/application-context-auth.xml"})
public class LoginDaoImplIntegrationTest {

    private static final String encryptedPassword = "YWhhbnQxMjM=";

    @Autowired
    private LoginDaoImpl loginDao;

    @Test
    public void testGetPassword() {
        assertEquals(Encryptor.decode(encryptedPassword), Encryptor.decode(loginDao.getPassword("ahant")));
    }
}
