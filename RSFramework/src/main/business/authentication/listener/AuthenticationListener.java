package main.business.authentication.listener;

import main.model.FRAccountModel;

/**
 * Created by Dora on 4/25/2017.
 */
public interface AuthenticationListener {

    public void onLoginSuccess(FRAccountModel accountModel);
    public void onLoginFail(String errMessage);

}
