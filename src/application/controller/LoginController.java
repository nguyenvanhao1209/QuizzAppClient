package application.controller;

import application.client.ClientSocket;
import application.view.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static application.utils.Utils.*;
import static application.view.FXMLConstans.*;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField inputPassword;

    @FXML
    private TextField inputUsername;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signUpbtn;
    
    public final ViewUtils viewUtils = new ViewUtils();

    @FXML
    void handleLogin(ActionEvent event) throws IOException {
    	String username = inputUsername.getText();
    	String password = inputPassword.getText();
    	if(username.equals("")|| password.equals("")) {
    		createDialog(Alert.AlertType.WARNING, "WARNING", "", "Vui lòng nhập đầy đủ username và password!");
    	}
    	else {
	    	ClientSocket.getInstance().sendMessage("client-verify,"+username+","+password);
	    	String message = ClientSocket.getInstance().readMessage();
	    	System.out.println(message);
	    	String[] messageSplit = message.split(",");
	    	if(messageSplit[0].equals("login-success")) {
	    		ClientSocket.getInstance().user = getUserFromString(1, messageSplit);
	    		viewUtils.changeScene(event, HOME_VIEW);
	    	}
	    	if(messageSplit[0].equals("dupplicate-login")) {
	    		createDialog(Alert.AlertType.WARNING, "WARNING", "", "Tài khoản của bạn đã được login");
	    	}
	    	if(messageSplit[0].equals("wrong-user")) {
	    		createDialog(Alert.AlertType.WARNING, "WARNING", "", "Sai tên đăng nhập hoặc mật khẩu");
	    	}
    	}
    }

    @FXML
    void moveToSignup(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, SIGNUP_VIEW);
    }

}
