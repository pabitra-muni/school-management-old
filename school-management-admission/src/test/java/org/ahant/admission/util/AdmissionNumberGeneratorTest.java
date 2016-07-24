package org.ahant.admission.util;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by ahant on 7/24/2016.
 */
public class AdmissionNumberGeneratorTest {
    AdmissionNumberGenerator source;

    @BeforeMethod
    public void init(){
        source  = new AdmissionNumberGenerator();
    }

    @Test
    public void testGenerateNumber(){


        assert(true);
    }
}
