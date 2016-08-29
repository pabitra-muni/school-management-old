package org.ahant.core.util;

import com.google.common.base.Strings;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.exception.ResultException;
import org.ahant.core.model.TaskData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by ahant on 7/23/2016.
 */
public class CommonUtil {
    private static Logger logger;
    public static final long _24HOUR = 24 * 60 * 60 * 1000;

    private CommonUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static String resizeTo(final String str, final int resizeLength, final char resizeChar) {
        String temp = str;
        if (temp.length() > resizeLength) {
            temp = temp.substring(0, resizeLength);
        } else if (temp.length() < resizeLength) {
            temp += getCharacters(resizeLength - temp.length(), resizeChar);
        }
        return temp;
    }

    public static String getCharacters(final int size, final char val) {
        StringBuilder temp = new StringBuilder();
        int counter = 1;
        while (counter <= size) {
            temp.append(val);
            counter++;
        }
        return temp.toString();
    }

    /**
     * changes the time values of given date to zero.
     *
     * @param date
     * @return
     */
    public static Date getZeroTimeDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * checks if date2 is later than date1 ignoring the time stamp.
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isLaterDate(final Date date1, final Date date2) {
        return getZeroTimeDate(date2).getTime() - getZeroTimeDate(date1).getTime() > 0;
    }

    /**
     * checks if date1 and date2 represent the same day ignoring the time stamp.
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(final Date date1, final Date date2) {
        return getZeroTimeDate(date2).getTime() - getZeroTimeDate(date1).getTime() == 0;
    }

    public static boolean isNotSameDate(final Date date1, final Date date2) {
        return !isSameDate(date1, date2);
    }

    public static boolean isToday(final Date date) {
        return isSameDate(date, new Date());
    }

    public static boolean isNotToday(final Date date) {
        return !isToday(date);
    }

    public static boolean isBlank(String input) {
        return Strings.isNullOrEmpty(input);
    }

    public static boolean isNotBlank(String input) {
        return !isBlank(input);
    }

    public static <T extends RuntimeException> T buildException(Class<T> exceptionClass, String msg) {
        T exception = null;
        try {
            Constructor<T> constructor = exceptionClass.getDeclaredConstructor(String.class);
            exception = constructor.newInstance(msg);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            log(CommonUtil.class, LogSeverity.WARN, e.getMessage());
        }
        return exception;
    }

    public static void log(Class<?> clazz, LogSeverity severity, String msg) {
        logger = LoggerFactory.getLogger(clazz);
        switch (severity) {
            case DEBUG:
                logger.debug(msg);
                break;
            case INFO:
                logger.info(msg);
                break;
            case WARN:
                logger.warn(msg);
                break;
            case ERROR:
                logger.error(msg);
                break;
        }
    }

    public static void log(Class<?> clazz, String msg) {
        log(clazz, LogSeverity.DEBUG, msg);
    }

    public enum LogSeverity {
        DEBUG, INFO, WARN, ERROR;
    }

    public static boolean isSuccessful(Collection errors) {
        return errors == null || errors.isEmpty();
    }

    public static boolean isNotSuccessful(Collection errors) {
        return !isSuccessful(errors);
    }

    public static void setException(TaskData taskData, String errorMsg) {
        setException(taskData, buildException(ApplicationException.class, errorMsg));
    }

    public static void setException(TaskData taskData, ResultException ex) {
        taskData.setException(ex);
    }

}
