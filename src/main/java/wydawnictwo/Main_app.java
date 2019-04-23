package wydawnictwo;

import controllers.ManagementController;
import dzial_handlowy.*;
import dzial_programowy.*;
import dzial_druku.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main_app extends Application{


	
	public static void main(String[] args) {
		
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/wydawnictwo/fxml/MainScreen.fxml"));
		StackPane stackPane = loader.load();
		Scene scene = new Scene(stackPane);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Witamy w wydawnictwie!");
		primaryStage.show();
	}

}
