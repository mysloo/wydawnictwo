package controllers;

import dzial_programowy.Pozycja;
import exceptions.UjemnaWartoscException;
import exceptions.WydawnictwoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PurchaseBookController {
	MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	ComboBox <Pozycja> chooseBook;
	@FXML
	TextField quantityField;
	ObservableList<Pozycja> books = FXCollections.observableArrayList();	
	
	@FXML
	public void purchase() {
		try {
			tryPurchase();
		}
		catch(Throwable t) {
			mainController.showErrorAlert("Wprowadzono bledne dane");
		}
	}
	public void tryPurchase() {
		WydawnictwoException e = mainController.getD_hand().getSklep().sprzedajKsiazke(mainController.getD_hand(),
				chooseBook.getValue(), Integer.parseInt(quantityField.getText()));
		if(e == null) mainController.showInfoAlert("Udalo sie zrealizowac zamowienie. Do zaplaty " + Integer.parseInt(quantityField.getText())*chooseBook.getValue().getCena()+ " zl.");
		else mainController.showErrorAlert("Wystapil blad.\nPowod: " + e.getMessage() + "\nZamowienie nie zostalo zrealizowane.");
	}
	
	@FXML
	public void backShop() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ShopScreen.fxml");
		ShopController shopController = loader.getController();
		shopController.setMainController(mainController);
	}
}
