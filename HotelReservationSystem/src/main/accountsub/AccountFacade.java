package main.accountsub;

import main.dbsub.DBFacadeImpl;
import main.dbsub.DBService;
import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class AccountFacade implements AccountService {

    private DBService dbService;

    public AccountFacade() {
        this.dbService = new DBFacadeImpl();
    }

    @Override
    public FRAccountModel getAccount(String userName, String password) {
        return this.dbService.getAccountByUserNameAndPassword(userName, password);
    }

    @Override
    public FRAccountModel getAccountByUserName(String userName) {
        return this.dbService.getAccountByUserName(userName);
    }

    @Override
    public FRAccountModel getAccountByUserId(String userId) {
        return this.dbService.getAccountById(userId);
    }

    @Override
    public List<FRAccountModel> getAllAccount() {
        return this.dbService.getAllAccount();
    }

    @Override
    public int saveAccount(FRAccountModel account) {
        return this.dbService.saveAccount(account);
    }

    @Override
    public int updateAccount(FRAccountModel account) {
        return this.dbService.updateAccount(account);
    }

    @Override
    public int deleteAccount(FRAccountModel account) {
        return this.dbService.deleteAccount(account);
    }

    @Override
    public int deleteAccountById(String accountId) {
        return this.dbService.deleteAccountById(accountId);
    }
}
