package main.business.authentication;

import main.business.authentication.listener.AuthenticationListener;
import main.business.authentication.proxy.AuthenticationProxy;
import main.business.authentication.proxy.IAuthentication;
import main.db.DBFacade;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/25/2017.
 */
public class AuthenticationHandlerImpl extends AuthenticationHandler {

    public AuthenticationHandlerImpl(DBFacade dbFacade) {
        super(dbFacade);
    }

    @Override
    public boolean validateEmptyFields(String userName, String password, AuthenticationListener listener) {
        if (userName.isEmpty()) {
            listener.onLoginFail("User name is empty!");
            return false;
        }
        if (password.isEmpty()) {
            listener.onLoginFail("Password is empty!");
            return false;
        }
        return true;
    }

    @Override
    public boolean performLogin(String userName, String password, AuthenticationListener listener) {
        IAuthentication authenticationProxy = new AuthenticationProxy(this.dbFacade);
        FRAccountModel accountModel = authenticationProxy.requestLogin(userName, password);
        if (accountModel == null || accountModel.getCode() == 0) {
            listener.onLoginFail("Username or password is incorrect!");
            return false;
        } else {
            listener.onLoginSuccess(accountModel);
        }
        return true;
    }
}
