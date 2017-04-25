package main.authenticationsub.proxy;

import main.accountsub.AccountFacade;
import main.accountsub.AccountService;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/23/2017.
 */
public class Authentication implements IAuthentication {

    @Override
    public FRAccountModel requestLogin(String userName, String password) {
        AccountService accountService = new AccountFacade();
        return accountService.getAccount(userName, password);
    }
}
