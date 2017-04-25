package main.accountsub;

import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface AccountService {

    public FRAccountModel getAccount(String userName, String password);
    public FRAccountModel getAccountByUserName(String userName);
    public FRAccountModel getAccountByUserId(String userId);
    public List<FRAccountModel> getAllAccount();
    public int saveAccount(FRAccountModel account);
    public int updateAccount(FRAccountModel account);
    public int deleteAccount(FRAccountModel account);
    public int deleteAccountById(String accountId);

}
