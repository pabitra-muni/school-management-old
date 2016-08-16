package org.ahant.core.validation;

import org.ahant.core.model.Address;
import org.ahant.core.validation.util.RequiredFieldValidator;

/**
 * Created by ahant on 8/14/2016.
 */
class AddressFieldValidator implements FieldValidator<Address> {

    @Override
    public boolean validate(Address address) {
        boolean returnValue = false;
        if(address != null){
            returnValue = RequiredFieldValidator.validate(address, FieldValidationType.FAIL_FAST);
        }
        return returnValue;
    }
}
