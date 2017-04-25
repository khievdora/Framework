package main.dbsub;

import main.db.DBFacade;
import main.model.*;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacadeImpl implements DBService, DBFacade {

    private IAccount account = null;
    private IGuest guest = null;
    private IRoomType roomType = null;
    private IRoom room = null;
    private IAddress address = null;
    private IReservation reservation = null;

    public DBFacadeImpl() {
        //Geneate Database
        IGenerateDB generateDB = new GenerateDBImpl();
        generateDB.generateDB();

        account = new AccountImpl();
        guest = new GuestImpl();
        roomType = new RoomTypeImpl();
        room = new RoomImpl();
        address = new AddressImpl();
        reservation = new ReservationImpl();
    }

    //@Override
    public int saveAccount(FRAccountModel account) {
        return this.account.saveAccount(account);
    }

    //@Override
    public int updateAccount(FRAccountModel account) {
        return this.account.updateAccount(account);
    }

    //@Override
    public int deleteAccount(FRAccountModel account) {
        return this.account.deleteAccount(account);
    }

    //@Override
    public int deleteAccountById(String accountId) {
        return this.account.deleteAccountById(accountId);
    }

    //@Override
    public FRAccountModel getAccountById(String accountId) {
        return this.account.getAccountById(accountId);
    }

    //@Override
    public FRAccountModel getAccountByUserName(String userName) {
        return this.account.getAccountByUserName(userName);
    }

    //@Override
    public FRAccountModel getAccountByUserNameAndPassword(String userName, String password) {
        return this.account.getAccountByUserNameAndPassword(userName, password);
    }

    //@Override
    public List<FRAccountModel> getAccountByFirstName(String firstName) {
        return this.account.getAccountByFirstName(firstName);
    }

    //@Override
    public List<FRAccountModel> getAccountByLastName(String lastName) {
        return this.account.getAccountByLastName(lastName);
    }

    //@Override
    public List<FRAccountModel> getAllAccount() {
        return this.account.getAllAccount();
    }

    //@Override
    public int saveReservation(FRReservationModel reservation) {
        return this.reservation.saveReservation(reservation);
    }

    //@Override
    public int updateReservation(FRReservationModel reservation) {
        return this.reservation.updateReservation(reservation);
    }

    //@Override
    public List<FRReservationModel> getAllReservation() {
        return this.reservation.getAllReservation();
    }

    @Override
    public int deleteAllReservation() {
        return this.reservation.deleteAllReservation();
    }

    @Override
    public int deleteReservationById(int idReservation) {
        return this.reservation.deleteReservationById(idReservation);
    }

    //@Override
    public int saveGuest(FRCustomerModel guest) {
        return this.guest.saveGuest(guest);
    }

    //@Override
    public int updateGuest(FRCustomerModel guest) {
        return this.guest.updateGuest(guest);
    }

    //@Override
    public int deleteGuestById(int guestId) {
        return this.guest.deleteGuestById(guestId);
    }

    //@Override
    public int deleteAllGuest() {
        return this.guest.deleteAllGuest();
    }

    //@Override
    public FRCustomerModel getGuestById(int guestId) {
        return this.guest.getGuestById(guestId);
    }

    //@Override
    public List<FRCustomerModel> getAllGuest() {
        return this.guest.getAllGuest();
    }

    //@Override
    public int saveRoomType(FRProductTypeModel roomType) {
        return this.roomType.saveRoomType(roomType);
    }

    //@Override
    public int updateRoomType(FRProductTypeModel roomType) {
        return this.roomType.updateRoomType(roomType);
    }

    //@Override
    public int deleteRoomType(FRProductTypeModel roomType) {
        return this.roomType.deleteRoomType(roomType);
    }

    //@Override
    public int deleteRoomTypeById(int roomTypeId) {
        return this.roomType.deleteRoomTypeById(roomTypeId);
    }

    //@Override
    public FRProductTypeModel getRoomTypeById(int roomTypeId) {
        return this.roomType.getRoomTypeById(roomTypeId);
    }

    //@Override
    public List<FRProductTypeModel> getAllRoomType() {
        return this.roomType.getAllRoomType();
    }

    //@Override
    public int saveRoom(FRProductModel room) {
        return this.room.saveRoom(room);
    }

    //@Override
    public int updateRoom(FRProductModel room) {
        return this.room.updateRoom(room);
    }

    //@Override
    public int deleteRoom(FRProductModel room) {
        return this.room.deleteRoom(room);
    }

    //@Override
    public int deleteRoomById(int roomId) {
        return this.room.deleteRoomById(roomId);
    }

    //@Override
    public FRProductModel getRoomById(int roomId) {
        return this.room.getRoomById(roomId);
    }

    //@Override
    public List<FRProductModel> getAllRoom() {
        return this.room.getAllRoom();
    }

    //@Override
    public int saveAddress(FRAddressModel address) {
        return this.address.saveAddress(address);
    }

    //@Override
    public int updateAddress(FRAddressModel address) {
        return this.address.updateAddress(address);
    }

    //@Override
    public int deleteAddress(FRAddressModel address) {
        return this.address.deleteAddress(address);
    }

    //@Override
    public int deleteAddressById(int addressId) {
        return this.address.deleteAddressById(addressId);
    }

    //@Override
    public FRAddressModel getAddressById(int addressId) {
        return this.address.getAddressById(addressId);
    }

    //@Override
    public List<FRAddressModel> getAllAddress() {
        return this.address.getAllAddress();
    }

    //////////////////////

    @Override
    public int saveFRAccountModel(FRAccountModel accountModel) {
        return this.account.saveAccount(accountModel);
    }

    @Override
    public int updateFRAccountModel(FRAccountModel accountModel) {
        return this.account.updateAccount(accountModel);
    }

    @Override
    public int deleteFRAccountModel(FRAccountModel accountModel) {
        return this.account.deleteAccount(accountModel);
    }

    @Override
    public int deleteFRAccountModelById(String accountModelId) {
        return this.account.deleteAccountById(accountModelId);
    }

    @Override
    public FRAccountModel getFRAccountModelById(String accountModelId) {
        return this.account.getAccountById(accountModelId);
    }

    @Override
    public FRAccountModel getFRAccountModelByUserName(String userName) {
        return this.account.getAccountByUserName(userName);
    }

    @Override
    public FRAccountModel getFRAccountModelByUserNameAndPassword(String userName, String password) {
        return this.account.getAccountByUserNameAndPassword(userName, password);
    }

    @Override
    public List<FRAccountModel> getFRAccountModelByFirstName(String firstName) {
        return this.account.getAccountByFirstName(firstName);
    }

    @Override
    public List<FRAccountModel> getFRAccountModelByLastName(String lastName) {
        return this.account.getAccountByLastName(lastName);
    }

    @Override
    public List<FRAccountModel> getAllFRAccountModel() {
        return this.account.getAllAccount();
    }

    @Override
    public int saveFRReservationModel(FRReservationModel reservation) {
        return this.reservation.saveReservation(reservation);
    }

    @Override
    public int updateFRReservationModel(FRReservationModel reservation) {
        return this.reservation.updateReservation(reservation);
    }

    @Override
    public List<FRReservationModel> getAllFRReservationModel() {
        return this.reservation.getAllReservation();
    }

    @Override
    public FRReservationModel getReservatinById(int idReservation) {
        return this.reservation.getReservatinById(idReservation);
    }

    @Override
    public int deleteAllFRReservationModel() {
        return this.reservation.deleteAllReservation();
    }

    @Override
    public int deleteFRReservationModelById(int idFRReservationModel) {
        return this.reservation.deleteReservationById(idFRReservationModel);
    }

    @Override
    public int saveFRCustomerModel(FRCustomerModel customer) {
        return this.guest.saveGuest(customer);
    }

    @Override
    public int updateFRCustomerModel(FRCustomerModel customer) {
        return this.guest.updateGuest(customer);
    }

    @Override
    public int deleteFRCustomerModelById(int customerId) {
        return this.guest.deleteGuestById(customerId);
    }

    @Override
    public int deleteAllFRCustomerModel() {
        return this.guest.deleteAllGuest();
    }

    @Override
    public FRCustomerModel getFRCustomerModelById(int customerId) {
        return this.guest.getGuestById(customerId);
    }

    @Override
    public List<FRCustomerModel> getAllFRCustomerModel() {
        return this.guest.getAllGuest();
    }

    @Override
    public int saveFRProductTypeModel(FRProductTypeModel productType) {
        return this.roomType.saveRoomType(productType);
    }

    @Override
    public int updateFRProductTypeModel(FRProductTypeModel productType) {
        return this.roomType.updateRoomType(productType);
    }

    @Override
    public int deleteFRProductTypeModel(FRProductTypeModel productType) {
        return this.roomType.deleteRoomType(productType);
    }

    @Override
    public int deleteFRProductTypeModelById(int productTypeId) {
        return this.roomType.deleteRoomTypeById(productTypeId);
    }

    @Override
    public FRProductTypeModel getFRProductTypeModelById(int productTypeId) {
        return this.roomType.getRoomTypeById(productTypeId);
    }

    @Override
    public List<FRProductTypeModel> getAllFRProductTypeModel() {
        return this.roomType.getAllRoomType();
    }

    @Override
    public int saveFRProductModel(FRProductModel product) {
        return this.room.saveRoom(product);
    }

    @Override
    public int updateFRProductModel(FRProductModel product) {
        return this.room.updateRoom(product);
    }

    @Override
    public int deleteFRProductModel(FRProductModel product) {
        return this.room.deleteRoom(product);
    }

    @Override
    public int deleteFRProductModelById(int productId) {
        return this.room.deleteRoomById(productId);
    }

    @Override
    public FRProductModel getFRProductModelById(int productId) {
        return this.room.getRoomById(productId);
    }

    @Override
    public List<FRProductModel> getAllFRProductModel() {
        return this.room.getAllRoom();
    }

    @Override
    public int saveFRAddressModel(FRAddressModel address) {
        return this.address.saveAddress(address);
    }

    @Override
    public int updateFRAddressModel(FRAddressModel address) {
        return this.address.updateAddress(address);
    }

    @Override
    public int deleteFRAddressModel(FRAddressModel address) {
        return this.address.deleteAddress(address);
    }

    @Override
    public int deleteFRAddressModelById(int addressId) {
        return this.address.deleteAddressById(addressId);
    }

    @Override
    public FRAddressModel getFRAddressModelById(int addressId) {
        return this.address.getAddressById(addressId);
    }

    @Override
    public List<FRAddressModel> getAllFRAddressModel() {
        return this.address.getAllAddress();
    }

}
