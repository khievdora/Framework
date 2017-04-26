package main.business.authentication.proxy;

import main.db.DBFacade;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/23/2017.
 */
public class Authentication implements IAuthentication {

    private DBFacade dbFacade;

    public Authentication(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    @Override
    public FRAccountModel requestLogin(String userName, String password) {
        return dbFacade.getFRAccountModelByUserNameAndPassword(userName, password);
    }
}
