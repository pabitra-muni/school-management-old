package org.ahant.admission.util;

/**
 * Created by ahant on 7/19/2016.
 */
public class RandomNumberGenerator implements NumberGenerator{
    private static RandomNumberGenerator instance = new RandomNumberGenerator();

    private RandomNumberGenerator(){}

    public static RandomNumberGenerator getInstance(){
        return instance;
    }

    @Override
    public String generateNumber() throws Exception {
        return null;
    }
}
