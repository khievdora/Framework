package main.dbsub;

import main.model.FRCustomerModel;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public interface IGuest {
    public int saveGuest(FRCustomerModel guest);
    public int updateGuest(FRCustomerModel guest);
    public int deleteGuestById(int guestId);
    public int deleteAllGuest();
    public FRCustomerModel getGuestById(int guestId);
    public List<FRCustomerModel> getAllGuest();

}
