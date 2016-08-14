package org.ahant.core.validation;

import org.ahant.core.model.Address;

/**
 * Created by ahant on 8/14/2016.
 */
public class AddressFieldValidator implements FieldValidator<Address> {

    @Override
    public boolean validate(Address address) {
        boolean returnValue = false;
        if(address != null){
            returnValue = RequiredFieldValidator.validate(address);
        }
        return returnValue;
    }
}
