package org.ahant.core.validation;

import com.google.common.collect.ImmutableList;
import org.ahant.core.model.Address;
import org.ahant.core.model.Gender;
import org.ahant.core.validation.util.RequiredFieldValidator;
import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by ahant on 8/22/2016.
 */
public class RequiredFieldValidatorTest {

    @Test
    public void test(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setFullName("Pabitra Muni");
        clazz.setGender(Gender.MALE);
        clazz.setContactNumberList(ImmutableList.of("8978889915"));
        clazz.setAddress(new Address());

        assertTrue(RequiredFieldValidator.validate(clazz, FieldValidationType.FAIL_FAST).isEmpty());
    }
}
