package controllers;

import java.io.IOException;
import java.util.TreeMap;

import dzial_programowy.*;
import dzial_handlowy.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShopController {
	
	private MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void checkStore() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/CheckScreen.fxml");

		CheckController check = loader.getController();
		check.setMainController(mainController);
	}

	@FXML
	public void showBooks() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ListofBooks.fxml");

		ListOfBooksController listaKsiazekController = loader.getController();
		listaKsiazekController.listaPozycji.addAll(mainController.getD_hand().getMagazyn().getPozycjeWmagazynie());
		listaKsiazekController.bookTable.setItems(listaKsiazekController.listaPozycji);

		listaKsiazekController.setMainController(mainController);
	}

	@FXML
	public void buyBook() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/PurchaseBookScreen.fxml");

		PurchaseBookController purchaseBookController = loader.getController();
		purchaseBookController.books.addAll(mainController.getD_hand().getMagazyn().getPozycjeWmagazynie());
		purchaseBookController.chooseBook.setItems(purchaseBookController.books);

		purchaseBookController.setMainController(mainController);
	}

	@FXML
	public void backMenu() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/MenuScreen.fxml");
		MenuController menuController = loader.getController();
		menuController.setMainController(mainController);
	}
	

}
