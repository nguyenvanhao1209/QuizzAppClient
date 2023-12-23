package application.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static application.view.FXMLConstans.*;

public class Client extends Application {

	@Override
	public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(LOGIN_VIEW));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Client");
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
