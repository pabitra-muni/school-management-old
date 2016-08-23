package org.ahant.core.validation;

import com.google.common.collect.ImmutableList;
import org.ahant.core.model.Address;
import org.ahant.core.model.Gender;
import org.ahant.core.validation.util.RequiredFieldValidator;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Set;

import static org.ahant.core.constants.ApplicationConstants.COLLECTION_MIN_SIZE_ERROR;
import static org.ahant.core.constants.ApplicationConstants.REQUIRED_FIELD_MISSING;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by ahant on 8/22/2016.
 */
public class RequiredFieldValidatorTest {

    @Test
    public void test_allGood(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setFullName("Pabitra Muni");
        clazz.setGender(Gender.MALE);
        clazz.setContactNumberList(ImmutableList.of("8978889915"));
        clazz.setAddress(new Address());
        clazz.setEmailAddress("mailtopabi@gmail.com");
        assertTrue(RequiredFieldValidator.validate(clazz, FieldValidationType.FAIL_FAST).isEmpty());
    }

    @Test
    public void test_ReqdFieldMissing(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setFullName("Pabitra Muni");
        clazz.setGender(Gender.MALE);
        clazz.setAddress(new Address());
        Set<String> result = RequiredFieldValidator.validate(clazz, FieldValidationType.FAIL_FAST);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 1);
        assertEquals(result.iterator().next(), String.format(REQUIRED_FIELD_MISSING, "contactNumber"));
    }

    @Test
    public void test_CollectionLessThanMinSize(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setFullName("Pabitra Muni");
        clazz.setGender(Gender.MALE);
        clazz.setContactNumberList(ImmutableList.of());
        clazz.setAddress(new Address());
        Set<String> result = RequiredFieldValidator.validate(clazz, FieldValidationType.FAIL_FAST);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 1);
        assertEquals(result.iterator().next(), String.format(COLLECTION_MIN_SIZE_ERROR, 1, "contactNumber"));
    }

    @Test
    public void test_ValidationTypeContinue(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setGender(Gender.MALE);
        clazz.setAddress(new Address());
        Set<String> result = RequiredFieldValidator.validate(clazz, FieldValidationType.CONTINUE);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 2);
    }

    @Test
    public void test_ValidationTypeFailFastShouldNotContinue(){
        DummyClass clazz = new DummyClass();
        clazz.setBirthDate(new Date());
        clazz.setGender(Gender.MALE);
        clazz.setAddress(new Address());
        Set<String> result = RequiredFieldValidator.validate(clazz, FieldValidationType.FAIL_FAST);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 1);
        assertEquals(result.iterator().next(), String.format(REQUIRED_FIELD_MISSING, "fullName"));
    }
}
