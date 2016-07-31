package org.ahant.admission.util;

import org.ahant.core.model.School;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


/**
 * Created by ahant on 7/24/2016.
 */
public class AdmissionNumberGeneratorTest {
    private AdmissionNumberGenerator source;
    private Set<String> admissionNumberSet;
    private static final int THREAD_SIZE = 1500;
    private static final String SCHOOL_CODE = "CODE";
    private static final String SHORT_SCHOOL_CODE = "COD";
    private static final String SCHOOL_NAME = "ABCD XYZ";
    private static final String SHORT_SCHOOL_NAME = "AB";
    private static final String SCHOOL_CODE_SUFFIX = "_";
    private static final long WAITING_TIME = 1 * 1000 * 1;

    @BeforeMethod
    public void init() {
        admissionNumberSet = new HashSet<>();
        source = spy(AdmissionNumberGenerator.class);
        doReturn(4).when(source).getSchoolCodeLengh();
        doReturn(SCHOOL_CODE_SUFFIX).when(source).getSchoolCodeSuffix();
    }

    private School getSchoolWithCode() {
        return new School() {
            public String getCode() {
                return SCHOOL_CODE;
            }
        };
    }

    private School getSchoolWithShortCode() {
        return new School() {
            public String getCode() {
                return SHORT_SCHOOL_CODE;
            }
        };
    }

    private School getSchoolWithName() {
        return new School() {
            public String getName() {
                return SCHOOL_NAME;
            }
        };
    }

    private School getSchoolWithShortName() {
        return new School() {
            public String getName() {
                return SHORT_SCHOOL_NAME;
            }
        };
    }

    @Test
    public void testGenerateNumber_FromCode() throws InterruptedException {
        source.setSchool(getSchoolWithCode());
        executeMethod();
        assertTrue(admissionNumberSet.iterator().next().startsWith(SCHOOL_CODE));
    }

    @Test
    public void testGenerateNumber_FromShortCode() throws InterruptedException {
        source.setSchool(getSchoolWithShortCode());
        executeMethod();
        assertTrue(admissionNumberSet.iterator().next().startsWith(new StringBuilder().append(SHORT_SCHOOL_CODE)
                .append(SCHOOL_CODE_SUFFIX).toString()));
    }

    @Test
    public void testGenerateNumber_FromName() throws InterruptedException {
        source.setSchool(getSchoolWithName());
        executeMethod();
        assertTrue(admissionNumberSet.iterator().next().startsWith(SCHOOL_NAME.substring(0, 4)));
    }

    @Test
    public void testGenerateNumber_FromShortName() throws InterruptedException {
        source.setSchool(getSchoolWithShortName());
        executeMethod();
        assertTrue(admissionNumberSet.iterator().next().startsWith(new StringBuilder().append(SHORT_SCHOOL_NAME)
                .append(SCHOOL_CODE_SUFFIX).append(SCHOOL_CODE_SUFFIX).toString()));
    }

    private void executeMethod() throws InterruptedException {
        for (int i = 1; i++ <= THREAD_SIZE; ) {
            (new Thread(new MultiThreadTest())).start();
        }

        await().atMost(3, SECONDS).until(isComplete());
        assertEquals(admissionNumberSet.size(), THREAD_SIZE);
    }


    class MultiThreadTest implements Runnable {
        @Override
        public void run() {
            admissionNumberSet.add(source.generateNumber());
        }
    }

    private Callable<Boolean> isComplete() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return admissionNumberSet.size() >= THREAD_SIZE;
            }
        };
    }
}
