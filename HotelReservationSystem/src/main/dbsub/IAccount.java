package main.dbsub;

import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public interface IAccount {
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

}
