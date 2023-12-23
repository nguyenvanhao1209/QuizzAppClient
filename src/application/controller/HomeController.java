package application.controller;

import application.client.ClientSocket;
import application.view.ViewUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import static application.view.FXMLConstans.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Button logoutBtn;

    @FXML
    private Label usernameLabel;
    
    public final ViewUtils viewUtils = new ViewUtils();

    @FXML
    void handleLogout(MouseEvent event) throws IOException {
    	ClientSocket.getInstance().sendMessage("offline,"+ClientSocket.getInstance().user.getID());
    	ClientSocket.getInstance().user = null;
    	viewUtils.changeScene(event, LOGIN_VIEW);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		usernameLabel.setText(ClientSocket.getInstance().user.getUsername());
		
	}

}
