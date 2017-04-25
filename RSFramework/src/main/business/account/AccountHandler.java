package main.business.account;

import main.business.account.listener.SaveAccountListener;
import main.db.DBFacade;
import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 */
public abstract class AccountHandler {

    protected DBFacade dbFacade = null;

    public AccountHandler(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public final void saveAccount(FRAccountModel account, SaveAccountListener listener) {
        if (listener == null) {
            throw new NullPointerException("SaveAccountListener must not be null!");
        }
        if (!validateRequiredFields(account, listener)) {
            return;
        }
        if (!validateInvalidFields(account, listener)) {
            return;
        }
        int result = this.dbFacade.saveFRAccountModel(account);
        if (result == 0) {
            listener.onSaveFail("Account cannot be saved into database");
        } else {
            listener.onSaveSuccess(account);
        }
    }

    public abstract boolean validateRequiredFields(FRAccountModel account, SaveAccountListener listener);
    public abstract boolean validateInvalidFields(FRAccountModel account, SaveAccountListener listener);


//    public int updateAccount(FRAccountModel account);
//    public int deleteAccount(FRAccountModel account);
//    public int deleteAccountById(String accountId);
//    public FRAccountModel getAccountById(String accountId);
//    public FRAccountModel getAccountByUserName(String userName);
//    public FRAccountModel getAccountByUserNameAndPassword(String userName, String password);
//    public List<FRAccountModel> getAccountByFirstName(String firstName);
//    public List<FRAccountModel> getAccountByLastName(String lastName);
    public abstract List<FRAccountModel> getAllAccount();

}
