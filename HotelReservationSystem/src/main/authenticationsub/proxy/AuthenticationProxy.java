package main.authenticationsub.proxy;

import main.model.Account;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/23/2017.
 */
public class AuthenticationProxy implements IAuthentication {

    private IAuthentication authentication;

    public AuthenticationProxy() {
        this.authentication = new Authentication();
    }

    @Override
    public FRAccountModel requestLogin(String userName, String password) {
        return this.authentication.requestLogin(userName, password);
    }
}
