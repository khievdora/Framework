package main.business.Address;

import main.db.DBFacade;
import main.model.FRAddressModel;
import main.model.FRCustomerModel;

/**
 * Created by Gize on 4/25/2017.
 */
public abstract class Address {
    protected DBFacade iAddress = null;

    public Address(DBFacade iAddress) {
        this.iAddress = iAddress;
    }
    public int saveAddress(FRAddressModel addressModel) {
        if (!validateAddress(addressModel)) {
            return 0;
        }
        return this.iAddress.saveFRAddressModel(addressModel);
    }

    public int updateAddress(FRAddressModel rModel) {
        if (!validateAddress(rModel)) {
            return 0;
        }
        return this.iAddress.updateFRAddressModel(rModel);
    }

    public int deleteAddress(FRAddressModel rModel) {
        if (!validateAddress(rModel)) {
            return 0;
        }
        return this.iAddress.deleteFRAddressModel(rModel);
    }

    protected abstract boolean validateAddress(FRAddressModel rModel);
}
