package org.ahant.core.validation;

import org.ahant.core.model.Address;
import org.ahant.core.validation.util.RequiredFieldValidator;

import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by ahant on 8/14/2016.
 */
class AddressFieldValidator implements FieldValidator<Address> {

    @Override
    public Set<String> validate(Address address) {
        checkArgument(address != null, "address can't be null");
        return RequiredFieldValidator.validate(address, FieldValidationType.CONTINUE);
    }
}
