package main.business.authentication;

import main.business.authentication.listener.AuthenticationListener;
import main.business.authentication.proxy.AuthenticationProxy;
import main.business.authentication.proxy.IAuthentication;
import main.db.DBFacade;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/24/2017.
 */
public abstract class AuthenticationHandler {

    protected DBFacade dbFacade;

    public AuthenticationHandler(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public final void login(String userName, String password, AuthenticationListener listener) {
        if (listener == null) {
            throw new NullPointerException("AuthenticationListener must be implemented!");
        }
        if (!validateEmptyFields(userName, password, listener)) {
            return;
        }
        performLogin(userName, password, listener);
    }

    protected abstract boolean validateEmptyFields(String userName, String password, AuthenticationListener listener);
    protected abstract boolean performLogin(String userName, String password, AuthenticationListener listener);

}
