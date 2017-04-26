package main.accountsub.memento;

import main.model.FRAccountModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 4/26/2017.
 */
public class AccountCareTaker {

    private List<AccountMemento> accountMementoList = new ArrayList<>();

    public void add(AccountMemento accountMemento) {
        accountMementoList.add(accountMemento);
    }

    public AccountMemento get(int index) {
        return accountMementoList.get(index);
    }

    public void restoreToPreviousState(FRAccountModel accountModel) {
        if (accountMementoList.size() >= 1) {
            AccountMemento preState = accountMementoList.remove(accountMementoList.size() - 1);
            FRAccountModel preAccount = preState.getState();

            accountModel.setUserRole(preAccount.getUserRole());
            accountModel.setUserName(preAccount.getUserName());
            accountModel.setStatus(preAccount.getStatus());
            accountModel.setPassword(preAccount.getPassword());
            accountModel.setAccountStatus(preAccount.getAccountStatus());
            accountModel.setCode(preAccount.getCode());
        }
    }

}
