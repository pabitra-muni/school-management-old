package org.ahant.core.util;

import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 7/24/2016.
 */
public class CommonUtilTest {

    @Test
    public void testIsSameDate(){
        Date today = getToday();
        assertTrue(CommonUtil.isSameDate(today, today));
    }

    @Test
    public void testIsNotSameDate(){
        assertTrue(CommonUtil.isNotSameDate(getToday(), getYesterDay()));
    }

    @Test
    public void testIsToday(){
        assertTrue(CommonUtil.isToday(getToday()));
    }

    @Test
    public void testIsNotToday(){
        assertTrue(CommonUtil.isNotToday(getYesterDay()));
    }

    private Date getYesterDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    private Date getToday(){return new Date();}
}
