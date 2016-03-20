package org.ahant.dao.login;

import org.ahant.util.cipher.Encryptor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.env.MockEnvironment;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ahant on 3/20/2016.
 */
@Test(groups = {"UnitTest"})
public class LoginDaoImplTest {

    private static final String encryptedPassword = "YWhhbnQxMjM=";

    private LoginDaoImpl loginDao;

    @BeforeMethod
    public void setUp() {
        loginDao = new LoginDaoImpl();
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        assertNotNull(loginDao);
        String username = "ahant";
        String queryKey = "query.user.get.password";
        String queryValue = "dummyQuery";
        String[] args = {username};
        JdbcTemplate mockJdbcTemplate = mock(JdbcTemplate.class);
        when(mockJdbcTemplate.queryForObject(queryValue, args, String.class)).thenReturn(encryptedPassword);

        Field jdbcField = loginDao.getClass().getDeclaredField("jdbcTemplate");
        jdbcField.setAccessible(Boolean.TRUE);
        jdbcField.set(loginDao, mockJdbcTemplate);

        MockEnvironment mockEnv = new MockEnvironment();
        mockEnv.setProperty(queryKey, queryValue);

        Field envField = loginDao.getClass().getDeclaredField("env");
        envField.setAccessible(Boolean.TRUE);
        envField.set(loginDao, mockEnv);

        assertEquals(Encryptor.decode(encryptedPassword), Encryptor.decode(loginDao.getPassword(username)));
    }
}
