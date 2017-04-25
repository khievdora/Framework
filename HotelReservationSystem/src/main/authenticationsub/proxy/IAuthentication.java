package main.authenticationsub.proxy;

import main.model.FRAccountModel;

/**
 * Created by Dora on 4/23/2017.
 */
public interface IAuthentication {

    public FRAccountModel requestLogin(String userName, String password);

}
