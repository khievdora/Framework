package main.dbsub;

import main.model.*;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface DBService {
    // CRUD User
    public int saveAccount(FRAccountModel account);
    public int updateAccount(FRAccountModel account);
    public int deleteAccount(FRAccountModel account);
    public int deleteAccountById(String accountId);
    public FRAccountModel getAccountById(String accountId);
    public FRAccountModel getAccountByUserName(String userName);
    public FRAccountModel getAccountByUserNameAndPassword(String userName, String password);
    public List<FRAccountModel> getAccountByFirstName(String firstName);
    public List<FRAccountModel> getAccountByLastName(String lastName);
    public List<FRAccountModel> getAllAccount();

    //CRUD FRReservationModel
    public int saveReservation(FRReservationModel reservation);
    public int updateReservation(FRReservationModel reservation);
    public List<FRReservationModel> getAllReservation();
    public FRReservationModel getReservatinById(int idReservation);
    public int deleteAllReservation();
    public int deleteReservationById(int idReservation);

    //CRUD FRCustomerModel
    public int saveGuest(FRCustomerModel guest);
    public int updateGuest(FRCustomerModel guest);
    public int deleteGuestById(int guestId);
    public int deleteAllGuest();
    public FRCustomerModel getGuestById(int guestId);
    public List<FRCustomerModel> getAllGuest();

    // CRUD FRProductModel Type
    public int saveRoomType(FRProductTypeModel roomType);
    public int updateRoomType(FRProductTypeModel roomType);
    public int deleteRoomType(FRProductTypeModel roomType);
    public int deleteRoomTypeById(int roomTypeId);
    public FRProductTypeModel getRoomTypeById(int roomTypeId);
    public List<FRProductTypeModel> getAllRoomType();

    // CRUD FRProductModel
    public int saveRoom(FRProductModel room);
    public int updateRoom(FRProductModel room);
    public int deleteRoom(FRProductModel room);
    public int deleteRoomById(int roomId);
    public FRProductModel getRoomById(int roomId);
    public List<FRProductModel> getAllRoom();

    //CRUD FRAddressModel
    public int saveAddress(FRAddressModel address);
    public int updateAddress(FRAddressModel address);
    public int deleteAddress(FRAddressModel address);
    public int deleteAddressById(int addressId);
    public FRAddressModel getAddressById(int addressId);
    public List<FRAddressModel> getAllAddress();


}
