package main.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.business.account.AccountHandler;
import main.business.account.AccountHandlerImpl;
import main.business.account.listener.SaveListener;
import main.accountsub.memento.AccountCareTaker;
import main.accountsub.memento.AccountMemento;
import main.dbsub.DBFacadeImpl;
import main.model.Account;
import main.model.FRAccountModel;
import main.statusenums.AccountStatus;
import main.statusenums.Status;
import main.statusenums.UserRole;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dora on 4/21/2017.
 */
public class AccountController implements Initializable, IController {

    @FXML
    private Label lblAccountTitle;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private ComboBox cboAccountStatus;
    @FXML
    private ComboBox cboUserRole;
    @FXML
    private ComboBox cboStatus;
    @FXML
    private Label lblErrMessage;

    private ObservableList<String> accountStatusList = FXCollections.observableArrayList(
            AccountStatus.ACTIVE.toString(),
            AccountStatus.SUSPENDED.toString(),
            AccountStatus.BLOCKED.toString()
    );
    private ObservableList<String> userRoleList = FXCollections.observableArrayList(
            UserRole.ADMIN.toString(),
            UserRole.MANAGER.toString(),
            UserRole.USER.toString()
    );
    private ObservableList<String> statusList = FXCollections.observableArrayList(
            Status.ENABLE.toString(),
            Status.DISABLE.toString()
    );

    private AccountControllerListener listener;

    private AccountHandler accountHandler;
    private AccountCareTaker accountCareTaker;
    private Stage accountStage;
    private boolean isEditAccount = false;
    private FRAccountModel account;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Initialize AccountHandler from Framework package
        // this object will handle database operation and validation during
        // saving, updating and delete account for you.
        accountHandler = new AccountHandlerImpl(new DBFacadeImpl());

        accountCareTaker = new AccountCareTaker();

        // Load data into ComboBox
        loadDataIntoComboBox();

        // Hide Error Message
        lblErrMessage.setVisible(false);
    }

    @Override
    public void setStage(Stage stage) {
        this.accountStage = stage;
    }

    /**
     * This method will be called when we use registration form as Edit form
     * This is what we call reusable component.
     * @param account
     */
    public void setAccount(FRAccountModel account) {
        this.account = account;
        this.isEditAccount = true;
        lblAccountTitle.setText("FRAccountModel Edit Form");
        txtUserName.setText(this.account.getUserName());
        txtPassword.setText(this.account.getPassword());
        cboAccountStatus.setValue(this.account.getAccountStatus());
        cboUserRole.setValue(this.account.getUserRole());
        cboStatus.setValue(this.account.getStatus());
    }

    public void onBtnAccountCancelClicked() {
        this.accountStage.close();
    }

    public void onBtnAccountSaveClicked() {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String status = (String) cboStatus.getSelectionModel().getSelectedItem();
        String userRole = (String) cboUserRole.getSelectionModel().getSelectedItem();
        String accountStatus = (String) cboAccountStatus.getSelectionModel().getSelectedItem();
        if (account == null) {
            account = new Account();
        }

        // Save account to state by using Memento Pattern
        accountCareTaker.add(new AccountMemento(account));

        this.account.setUserName(userName);
        this.account.setPassword(password);
        this.account.setStatus(status);
        this.account.setUserRole(userRole);
        this.account.setAccountStatus(accountStatus);

        if (isEditAccount) {
            //editAccount();
            accountHandler.updateAccount(account, new SaveListener<FRAccountModel>() {
                @Override
                public void onSaveSuccess(FRAccountModel object) {
                    accountStage.close();
                    listener.onUpdateSuccess(object);
                }

                @Override
                public void onSaveFail(String errMessage) {
                    lblErrMessage.setVisible(true);
                    lblErrMessage.setText(errMessage);

                    // In case save account fail, we have to restore account back to its previous state
                    accountCareTaker.restoreToPreviousState(account);
                }
            });
        } else {
            //saveAccount();
            accountHandler.saveAccount(account, new SaveListener<FRAccountModel>() {
                @Override
                public void onSaveSuccess(FRAccountModel accountModel) {
                    accountStage.close();
                    listener.onSaveSuccess(accountModel);
                }

                @Override
                public void onSaveFail(String errMessage) {
                    lblErrMessage.setVisible(true);
                    lblErrMessage.setText(errMessage);

                    // In case save account fail, we have to restore account back to its previous state
                    accountCareTaker.restoreToPreviousState(account);
                }
            });
        }

    }

    public void loadDataIntoComboBox() {
        cboAccountStatus.setItems(accountStatusList);
        cboUserRole.setItems(userRoleList);
        cboStatus.setItems(statusList);
        cboAccountStatus.setValue(AccountStatus.ACTIVE.toString());
        cboUserRole.setValue(UserRole.ADMIN.toString());
        cboStatus.setValue(Status.ENABLE.toString());
    }

    public void setAccountControllerListener(AccountControllerListener listener) {
        this.listener = listener;
    }

    public interface AccountControllerListener {
        public void onSaveSuccess(FRAccountModel account);
        public void onUpdateSuccess(FRAccountModel account);
        public void onSaveFail(String errMessage);
    }
}
