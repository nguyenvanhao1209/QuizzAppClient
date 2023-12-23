package application.utils;

import application.model.User;
import javafx.scene.control.Alert;

public class Utils {
	public static User getUserFromString(int start, String[] message) {
		return new User(Integer.parseInt(message[start]), message[start+1], message[start+2]);
	}
    public static void createDialog(Alert.AlertType type, String title, String headerText, String contentText) {
        Alert warning = new Alert(type);
        warning.setTitle(title);
        warning.setHeaderText(headerText);
        warning.setContentText(contentText);
        warning.showAndWait();
    }
}
