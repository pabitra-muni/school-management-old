package org.ahant.auth.dao;

import org.ahant.core.util.cipher.Encryptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ahant on 3/20/2016.
 */
public class AuthDaoImplTest1 {

    private static final String encryptedPassword = "YWhhbnQxMjM=";

    private AuthDaoImpl authDao;

    @BeforeMethod
    public void setUp() {
        authDao = new AuthDaoImpl();
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        assertNotNull(authDao);
        String username = "ahant";
        String queryValue = "dummyQuery";
        String[] args = {username};
        JdbcTemplate mockJdbcTemplate = mock(JdbcTemplate.class);
        when(mockJdbcTemplate.queryForObject(queryValue, args, String.class)).thenReturn(encryptedPassword);

        Field jdbcField = authDao.getClass().getDeclaredField("jdbcTemplate");
        jdbcField.setAccessible(Boolean.TRUE);
        jdbcField.set(authDao, mockJdbcTemplate);

        authDao.setUserPasswordQuery(queryValue);

        assertEquals(Encryptor.decode(encryptedPassword), Encryptor.decode(authDao.getPassword(username)));
    }
}
