package org.ahant.core.util;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by ahant on 7/23/2016.
 */
public class CommonUtil {

    private CommonUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static String resizeTo(final String str, int resizeLength, final String resizeChar) {
        String temp = str;
        if (temp.length() > resizeLength) {
            temp = temp.substring(0, resizeLength);
        } else if (temp.length() < resizeLength) {
            temp += getCharacters(resizeLength - temp.length(), resizeChar);
        }
        return temp;
    }

    public static String getCharacters(int count, final String val) {
        StringBuilder temp = new StringBuilder();
        int counter = 1;
        while (counter <= count) {
            temp.append(val);
            counter++;
        }
        return temp.toString();
    }

    public static boolean isSameDate(final Date date1, final Date date2){
        boolean isSame = false;
        DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT);
        if(dateFormatter.format(date1).equals(dateFormatter.format(date2))){
            isSame = true;
        }
        return isSame;
    }

    public static boolean isNotSameDate(final Date date1, final Date date2){
        return !isSameDate(date1, date2);
    }

    public static boolean isToday(final Date date){
        return isSameDate(date, new Date());
    }

    public static boolean isNotToday(final Date date){
        return !isToday(date);
    }
}
