package org.ahant.core.constants;

/**
 * Created by ahant on 8/14/2016.
 */
public class ApplicationConstants {
    public static final String REQUIRED_FIELD_MISSING = "Required field missing: \'%s\'";
    public static final String COLLECTION_MIN_SIZE_ERROR = "A minimum of %d values are required for field \'%s\'";
    public static final String PHONE_NUMBER_REGEX = "\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*";
    public static final String ZIP_CODE_REGEX = "\\d{5}";
    public static final String EMAIL_REGEX = "[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})";
    public static final String BIRTH_DATE_FORMAT = "dd/MM/yyyy";


    public static final String INVALID_EMAIL = "Invalid email address";
    public static final String INVALID_ZIP = "Invalid zip code";
    public static final String INVALID_PHONE = "Invalid phone number";

    private ApplicationConstants() {
    }
}
