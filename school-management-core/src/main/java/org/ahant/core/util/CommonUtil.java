package org.ahant.core.util;

/**
 * Created by ahant on 7/23/2016.
 */
public class CommonUtil {

    private CommonUtil() {
        throw new IllegalAccessError("Utility class");
    }

    public static String resizeTo(String str, int resizeLength, Character resizeChar) {
        String temp = str;
        if (temp.length() > resizeLength) {
            temp = temp.substring(0, resizeLength);
        } else if (temp.length() < resizeLength) {
            temp += getCharacters(resizeLength - temp.length(), resizeChar);
        }
        return temp;
    }

    public static String getCharacters(int count, Character val) {
        StringBuilder temp = new StringBuilder();
        int counter = 1;
        while (counter <= count) {
            temp.append(val);
            counter++;
        }
        return temp.toString();
    }
}
