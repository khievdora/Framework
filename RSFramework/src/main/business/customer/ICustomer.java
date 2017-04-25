package main.business.customer;

import main.model.FRCustomerModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public interface ICustomer {
    public int saveCustomer(FRCustomerModel customerModel);
    public int updateCustomer(FRCustomerModel customerModel);
    public int deleteCustomerById(int guestId);
    public int deleteAllGuest();
    public FRCustomerModel getCustomerById(int guestId);
    public List<FRCustomerModel> getAllCustomer();
}
