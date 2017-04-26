package main.business.authentication.proxy;

import main.db.DBFacade;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/23/2017.
 */
public class AuthenticationProxy implements IAuthentication {

    private IAuthentication authentication;

    public AuthenticationProxy(DBFacade dbFacade) {
        this.authentication = new Authentication(dbFacade);
    }

    @Override
    public FRAccountModel requestLogin(String userName, String password) {
        return this.authentication.requestLogin(userName, password);
    }
}
