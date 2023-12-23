package application.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ViewUtils {
	
	public void changeScene(ActionEvent event, String viewSource) throws IOException {
		Stage stage;
		Scene scene;
		Parent root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource(viewSource));
		root = loader.load();
		scene = new Scene(root);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
	public void changeScene(MouseEvent event, String viewSource) throws IOException {
		Stage stage;
		Scene scene;
		Parent root;
		FXMLLoader loader = new FXMLLoader(getClass().getResource(viewSource));
		root = loader.load();
		scene = new Scene(root);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
	}
}
