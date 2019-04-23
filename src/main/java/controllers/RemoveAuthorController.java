package controllers;

import dzial_programowy.*;
import exceptions.CzyPoprawnyStringException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RemoveAuthorController {
	MainController mainController;

	@FXML
	TextField nameField, surnameField;
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void removeAuthor() {
		Autor a;
		try {
			a = new Autor(nameField.getText(),surnameField.getText());
			if(mainController.d_prog.usunAutora(a)) {
				mainController.showInfoAlert("Usunieto autora oraz jego umowy.");
			}
			else {
				mainController.showErrorAlert("Nie ma takiego autora w bazie.");
			}
		} catch (CzyPoprawnyStringException e) {
			mainController.showErrorAlert("Wystapil blad.\nPowod:" + e.getMessage());
		}
	}
		
	@FXML
	public void backAuthorScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/AuthorScreen.fxml");
		AuthorController authorController = loader.getController();
		authorController.setMainController(mainController);
	}
}
