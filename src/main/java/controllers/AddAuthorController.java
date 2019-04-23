package controllers;

import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import java.io.IOException;
import dzial_programowy.Autor;
import dzial_programowy.Dzial_Programowy;
import exceptions.CzyPoprawnyStringException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

public class AddAuthorController {
	MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	private TextField nameField, surnameField;

	@FXML
	public void addAuthor() {
		try {
			if(mainController.d_prog.dodajAutora(new Autor(nameField.getText(), surnameField.getText()))) {
				mainController.showInfoAlert("Dodano nowego autora do bazy.");
			}
			else {
				mainController.showErrorAlert("Autor o takich danych osobowych juz istnieje w bazie!");
			}
		} catch (CzyPoprawnyStringException e) {
			mainController.showErrorAlert("Wystapil blad.\nPowod: "+e.getMessage()+"\nAutor nie zostal dodany do bazy");
		}
	}

	@FXML
	public void backAuthorScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/AuthorScreen.fxml");
		AuthorController authorController = loader.getController();
		authorController.setMainController(mainController);
	}
}
