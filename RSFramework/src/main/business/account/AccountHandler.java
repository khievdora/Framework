package main.business.account;

import main.business.account.listener.DeleteListener;
import main.business.account.listener.SaveListener;
import main.db.DBFacade;
import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/24/2017.
 *
 * AccountHandler is an Abstract class in Template Method pattern
 * It has hooks methods such as saveAccount, updateAccount, deleteAccount
 */
public abstract class AccountHandler {

    protected DBFacade dbFacade = null;

    public AccountHandler(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public final void saveAccount(FRAccountModel account, SaveListener<FRAccountModel> listener) {
        if (listener == null) {
            throw new NullPointerException("SaveListener must be implemented!");
        }
        if (!validateRequiredFields(account, listener)) {
            return;
        }
        if (!validateInvalidFields(account, listener)) {
            return;
        }
        int result = this.dbFacade.saveFRAccountModel(account);
        if (result == 0) {
            listener.onSaveFail("Account cannot be saved into database!");
        } else {
            listener.onSaveSuccess(account);
        }
    }

    public final void updateAccount(FRAccountModel account, SaveListener<FRAccountModel> listener){
        if (listener == null) {
            throw new NullPointerException("SaveListener must be implemented!");
        }
        if (!validateRequiredFields(account, listener)) {
            return;
        }
        if (!validateInvalidFields(account, listener)) {
            return;
        }
        int result = this.dbFacade.updateFRAccountModel(account);
        System.out.println("Account has been edited");
        if (result == 0) {
            listener.onSaveFail("Account cannot be updated into database!");
        } else {
            listener.onSaveSuccess(account);
        }
    }

    public void deleteAccount(FRAccountModel account, DeleteListener<FRAccountModel> listener) {
        if (listener == null) {
            throw new NullPointerException("DeleteListener must be implemented!");
        }
        int result = this.dbFacade.deleteFRAccountModel(account);
        if (result == 0) {
            listener.onDeleteFail("Account with username " + account.getUserName() + " cannot be deleted");
        } else {
            listener.onDeleteSuccess(account);
        }
    }

    public abstract List<FRAccountModel> getAllAccount();
    protected abstract boolean validateRequiredFields(FRAccountModel account, SaveListener listener);
    protected abstract boolean validateInvalidFields(FRAccountModel account, SaveListener listener);

}
