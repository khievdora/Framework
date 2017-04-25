package main.business.Address;

import main.model.FRAddressModel;
import main.model.FRCustomerModel;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Address {
    protected IAddress iAddress = null;

    public Address(IAddress iAddress) {
        this.iAddress = iAddress;
    }
    public int saveAddress(FRAddressModel addressModel) {
        if (!validateAddress(addressModel)) {
            return 0;
        }
        return this.iAddress.saveAddress(addressModel);
    }

    public int updateAddress(FRAddressModel rModel) {
        if (!validateAddress(rModel)) {
            return 0;
        }
        return this.iAddress.updateAddress(rModel);
    }

    public int deleteAddress(FRAddressModel rModel) {
        if (!validateAddress(rModel)) {
            return 0;
        }
        return this.iAddress.deleteAddressById(rModel.getCode());
    }

    protected abstract boolean validateAddress(FRAddressModel rModel);
}
