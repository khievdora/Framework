package main.authenticationsub;

import main.model.FRAccountModel;

/**
 * Created by Dora on 4/19/2017.
 */
public interface AuthenticationSubcriber {

    public void onLoginSuccess(FRAccountModel account);
    public void onLoginFail(String errMessage);
    public void onSessionExpired();

}
