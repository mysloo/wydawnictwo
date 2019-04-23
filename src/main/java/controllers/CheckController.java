package controllers;


import dzial_programowy.Pozycja;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CheckController {
	private MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	TextField textField;

	@FXML
	public void checkBook() {
		int var = mainController.getD_hand().getMagazyn().sprawdzStan(textField.getText());
		String s = "W magazynie znajduje si� " + var + " sztuk '" + textField.getText() + "'.";
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(s);
		alert.setTitle("Informacja");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	@FXML
	public void backShop() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ShopScreen.fxml");
		ShopController shopController = loader.getController();
		shopController.setMainController(mainController);
	}
}
