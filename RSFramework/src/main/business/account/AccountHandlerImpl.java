package main.business.account;

import main.business.account.listener.SaveAccountListener;
import main.db.DBFacade;
import main.model.FRAccountModel;

import java.util.List;

/**
 * Created by Dora on 4/25/2017.
 */
public class AccountHandlerImpl extends AccountHandler {

    public AccountHandlerImpl(DBFacade dbFacade) {
        super(dbFacade);

    }

    @Override
    public List<FRAccountModel> getAllAccount() {
        return this.dbFacade.getAllFRAccountModel();
    }

    @Override
    public boolean validateRequiredFields(FRAccountModel account, SaveAccountListener listener) {
        if (account.getUserName().isEmpty()) {
            listener.onSaveFail("User name is required!");
            return false;
        }

        if (account.getPassword().isEmpty()) {
            listener.onSaveFail("Password is required!");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateInvalidFields(FRAccountModel account, SaveAccountListener listener) {
        if (account.getPassword().length() < 5) {
            listener.onSaveFail("Password must be at least 5 characters!");
        }
        return true;
    }
}
