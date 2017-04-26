package main.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.LoginWindow;
import main.authenticationsub.AuthenticationService;
import main.authenticationsub.AuthenticationSubcriber;
import main.authenticationsub.AuthenticatoinFacade;
import main.business.authentication.AuthenticationHandler;
import main.business.authentication.AuthenticationHandlerImpl;
import main.business.authentication.listener.AuthenticationListener;
import main.db.DBFacade;
import main.dbsub.DBFacadeImpl;
import main.model.FRAccountModel;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Dora on 4/20/2017.
 */
public class LoginController implements Initializable, AuthenticationSubcriber {

    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblMessage;
    @FXML
    private ImageView imgHotel;

    private AuthenticationService authService;
    private LoginWindow loginWindow;

    private DBFacade dbFacade;
    private AuthenticationHandler authenticationHandler;

    public LoginController() {
        //System.out.println("LoginController is instantiated!!!");
        authService = new AuthenticatoinFacade();
        //authService.registerAuthenticationSubscriber(this);
        dbFacade = new DBFacadeImpl();
        authenticationHandler = new AuthenticationHandlerImpl(dbFacade);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Resource is loaded!!!");
        txtUserName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    lblMessage.setText("");
                }
            }
        });
        txtPassword.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    lblMessage.setText("");
                }
            }
        });
        txtPassword.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    onButtonLoginClicked();
                }
            }
        });
    }

    @Override
    public void onLoginSuccess(FRAccountModel account) {
        // Navigate to Welcome screen
        System.out.println("Login success!!!");
        this.loginWindow.navigateToMainWindow();
    }

    @Override
    public void onLoginFail(String errMessage) {
        txtUserName.requestFocus();
        // Display error message
        lblMessage.setText(errMessage);
        clearText();
    }

    @Override
    public void onSessionExpired() {
        // Don't need to implement because we are in Login screen. There's no session expired in this use case.
    }

    public void onButtonLoginClicked() {
        System.out.println("Button login clicked!!!");
//        authService.login(txtUserName.getText(), txtPassword.getText());
//        this.loginWindow.navigateToMainWindow();
        authenticationHandler.login(txtUserName.getText(), txtPassword.getText(), new AuthenticationListener() {
            @Override
            public void onLoginSuccess(FRAccountModel accountModel) {
                loginWindow.navigateToMainWindow();
            }

            @Override
            public void onLoginFail(String errMessage) {
                txtUserName.requestFocus();
                lblMessage.setText(errMessage);
                clearText();
            }
        });
    }

    public void onButtonCancelClicked() {
        System.out.println("Button cancel clicked!!!");
        loginWindow.close();
    }

    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }

    public void clearText() {
        txtUserName.setText("");
        txtPassword.setText("");
    }

    public void setHotelImage(InputStream imageUrl) {
        //System.out.println("Image url : " + imageUrl);
        imgHotel.setImage(new Image(imageUrl));
        imgHotel.setSmooth(true);
    }
}
