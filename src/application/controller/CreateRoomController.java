package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CreateRoomController implements Initializable {

    @FXML
    private ChoiceBox<String> deThiChoiceBox;

    @FXML
    private ChoiceBox<String> monThiChoiceBox;

    @FXML
    private TextField roomNameTextField;

    @FXML
    void handleCreateRoom(ActionEvent event) {

    }

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// TODO Auto-generated method stub
		
	}

}
