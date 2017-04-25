package main.business.Address;

import main.model.FRAddressModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public interface IAddress {
    public int saveAddress(FRAddressModel address);
    public int updateAddress(FRAddressModel address);
    public int deleteAddress(FRAddressModel address);
    public int deleteAddressById(int addressId);
    public FRAddressModel getAddressById(int addressId);
    public List<FRAddressModel> getAllAddress();
}
