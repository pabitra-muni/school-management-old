package org.ahant.core.util.cipher;

import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by ahant on 3/20/2016.
 */
public class Encryptor {
    private Encryptor(){}

    public static void main(String[] args) throws Exception {
        System.out.println(decode("YWRtaW4="));
    }

    public static String encode(String value) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(value.getBytes(Charsets.UTF_8));
    }

    public static String decode(String encodedValue) {
        return new String(Base64.getDecoder().decode(encodedValue));
    }
}
