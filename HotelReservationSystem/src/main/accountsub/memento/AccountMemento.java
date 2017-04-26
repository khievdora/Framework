package main.accountsub.memento;

import main.model.Account;
import main.model.FRAccountModel;

/**
 * Created by Dora on 4/26/2017.
 */
public class AccountMemento {

    public FRAccountModel state;

    public AccountMemento(FRAccountModel state) {
        this.state = new Account();
        setState(state);
    }

    public void setState(FRAccountModel accountModel) {
        state.setCode(accountModel.getCode());
        state.setAccountStatus(accountModel.getAccountStatus());
        state.setPassword(accountModel.getPassword());
        state.setStatus(accountModel.getStatus());
        state.setUserName(accountModel.getUserName());
        state.setUserRole(accountModel.getUserRole());
    }

    public FRAccountModel getState() {
        return state;
    }

}
