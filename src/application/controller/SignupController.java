package application.controller;

import static application.utils.Utils.createDialog;
import static application.view.FXMLConstans.*;

import java.io.IOException;

import application.client.ClientSocket;
import application.view.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignupController {

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
    void handleSignup(ActionEvent event) throws IOException {
    	String username = inputUsername.getText();
    	String password = inputPassword.getText();
    	if(username.equals("")|| password.equals("")) {
    		createDialog(Alert.AlertType.WARNING, "WARNING", "", "Vui lòng nhập đầy đủ username và password!");
    	}
    	else {
	    	ClientSocket.getInstance().sendMessage("register,"+username+","+password);
	    	String message = ClientSocket.getInstance().readMessage();
	    	System.out.println(message);
	    	String[] messageSplit = message.split(",");
	    	if(messageSplit[0].equals("duplicate-username")) {
	    		createDialog(Alert.AlertType.WARNING, "WARNING", "", "Username đã tồn tại");
	    	}
	    	if(messageSplit[0].equals("registed-success")) {
	    		createDialog(Alert.AlertType.INFORMATION, "WARNING", "", "Đăng ký thành công");
	    		viewUtils.changeScene(event, LOGIN_VIEW);
	    	}
    	}
    }

    @FXML
    void moveToLogin(ActionEvent event) throws IOException {
    	viewUtils.changeScene(event, LOGIN_VIEW);
    }

}
