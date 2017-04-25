package test;

import main.accountsub.AccountFacade;
import main.accountsub.AccountService;
import main.model.Account;
import main.model.FRAccountModel;
import main.statusenums.AccountStatus;
import main.statusenums.Status;
import main.statusenums.UserRole;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public class AccountMainTest {

    public static void main(String[] args) {

        AccountMainTest mainTest = new AccountMainTest();

        AccountService accountService = new AccountFacade();

        // List all account in the db
        List<FRAccountModel> accountList = accountService.getAllAccount();
        mainTest.displayAllAccount(accountList);

        // Add new account
        FRAccountModel account = new Account();
        account.setCode(accountList.size() + 1);
        account.setUserName("dora");
        account.setPassword("dora");
        account.setStatus(Status.ENABLE.toString());
        account.setUserRole(UserRole.USER.toString());
        account.setAccountStatus(AccountStatus.ACTIVE.toString());
//        accountService.saveAccount(account);

        // List all account again
        //accountList = accountService.getAllAccount();
        //mainTest.displayAllAccount(accountList);

        // Edit account
        FRAccountModel doraAccount = accountService.getAccountByUserId("4");
//        doraAccount.setAccountStatus(AccountStatus.SUSPENDED.toString());
//        accountService.updateAccount(doraAccount);
//        System.out.println("After update");
//        System.out.println(doraAccount.toString());

        accountService.deleteAccount(doraAccount);

        accountList = accountService.getAllAccount();
        mainTest.displayAllAccount(accountList);



        // Load account that has been updated


    }
    public void addAccount(){

    }
    public void displayAllAccount(List<FRAccountModel> accountList) {
        printTitle("FRAccountModel List");
        for (FRAccountModel item : accountList) {
            System.out.println(item.toString());
        }
    }

    public void printTitle(String message) {
        System.out.println("***********************************");
        System.out.println(message);
        System.out.println("***********************************");
    }

}
