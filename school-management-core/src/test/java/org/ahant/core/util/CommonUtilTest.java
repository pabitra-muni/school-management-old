package org.ahant.core.util;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 7/24/2016.
 */
public class CommonUtilTest {

    @Test
    public void testResizeTo(){
        assertEquals("helloABC##", CommonUtil.resizeTo("helloABC", 10, '#'));
        assertEquals("helloABC__", CommonUtil.resizeTo("helloABC", 10, '_'));
        assertEquals("hello", CommonUtil.resizeTo("helloABC", 5, '#'));
        assertEquals("hello", CommonUtil.resizeTo("hello", 5, '#'));
        assertTrue(CommonUtil.resizeTo("hello", 0, '#').isEmpty());
    }

    @Test
    public void testIsSameDate() {
        Date today = getToday();
        assertTrue(CommonUtil.isSameDate(today, today));
    }

    @Test
    public void testIsNotSameDate() {
        assertTrue(CommonUtil.isNotSameDate(getToday(), getYesterDay()));
    }

    @Test
    public void testIsToday() {
        assertTrue(CommonUtil.isToday(getToday()));
    }

    @Test
    public void testIsNotToday() {
        assertTrue(CommonUtil.isNotToday(getYesterDay()));
    }

    private Date getYesterDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    private Date getToday() {
        return new Date();
    }
}
