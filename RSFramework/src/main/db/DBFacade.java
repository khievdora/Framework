package main.db;

import main.model.*;

import java.util.List;

/**
 * Created by Dora on 4/25/2017.
 */
public interface DBFacade {
    // CRUD User
    public int saveFRAccountModel(FRAccountModel accountModel);
    public int updateFRAccountModel(FRAccountModel accountModel);
    public int deleteFRAccountModel(FRAccountModel accountModel);
    public int deleteFRAccountModelById(String accountModelId);
    public FRAccountModel getFRAccountModelById(String accountModelId);
    public FRAccountModel getFRAccountModelByUserName(String userName);
    public FRAccountModel getFRAccountModelByUserNameAndPassword(String userName, String password);
    public List<FRAccountModel> getFRAccountModelByFirstName(String firstName);
    public List<FRAccountModel> getFRAccountModelByLastName(String lastName);
    public List<FRAccountModel> getAllFRAccountModel();

    //CRUD FRReservationModel
    public int saveFRReservationModel(FRReservationModel reservation);
    public int updateFRReservationModel(FRReservationModel reservation);
    public List<FRReservationModel> getAllFRReservationModel();
    public FRReservationModel getReservatinById(int idFRReservationModel);
    public int deleteAllFRReservationModel();
    public int deleteFRReservationModelById(int idFRReservationModel);

    //CRUD FRCustomerModel
    public int saveFRCustomerModel(FRCustomerModel customer);
    public int updateFRCustomerModel(FRCustomerModel customer);
    public int deleteFRCustomerModelById(int customerId);
    public int deleteAllFRCustomerModel();
    public FRCustomerModel getFRCustomerModelById(int customerId);
    public List<FRCustomerModel> getAllFRCustomerModel();

    // CRUD FRProductModel Type
    public int saveFRProductTypeModel(FRProductTypeModel productType);
    public int updateFRProductTypeModel(FRProductTypeModel productType);
    public int deleteFRProductTypeModel(FRProductTypeModel productType);
    public int deleteFRProductTypeModelById(int productTypeId);
    public FRProductTypeModel getFRProductTypeModelById(int productTypeId);
    public List<FRProductTypeModel> getAllFRProductTypeModel();

    // CRUD FRProductModel
    public int saveFRProductModel(FRProductModel product);
    public int updateFRProductModel(FRProductModel product);
    public int deleteFRProductModel(FRProductModel product);
    public int deleteFRProductModelById(int productId);
    public FRProductModel getFRProductModelById(int productId);
    public List<FRProductModel> getAllFRProductModel();

    //CRUD FRAddressModel
    public int saveFRAddressModel(FRAddressModel address);
    public int updateFRAddressModel(FRAddressModel address);
    public int deleteFRAddressModel(FRAddressModel address);
    public int deleteFRAddressModelById(int addressId);
    public FRAddressModel getFRAddressModelById(int addressId);
    public List<FRAddressModel> getAllFRAddressModel();
}
