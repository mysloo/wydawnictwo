package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListOfBooksController implements Initializable{
	private MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	TableView<Pozycja> bookTable;
	
	ObservableList<Pozycja> listaPozycji = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//typ
		TableColumn<Pozycja, String> typCol = new TableColumn<>("Rodzaj");
		typCol.setCellValueFactory(new PropertyValueFactory<>("rodzaj"));
		//tytul
		TableColumn<Pozycja, String> tytulCol = new TableColumn<>("Tytul"); 
		tytulCol.setCellValueFactory(new PropertyValueFactory<>("tytul"));//tutaj podajemy nazwe zmiennej z Person
		//autor
		TableColumn<Pozycja, Autor> autorCol = new TableColumn<>("Autor"); 
		autorCol.setCellValueFactory(new PropertyValueFactory<>("autor"));//tutaj podajemy nazwe zmiennej z Person
		//cena
		TableColumn<Pozycja, Double> cenaCol = new TableColumn<>("Cena");
		cenaCol.setCellValueFactory(new PropertyValueFactory<>("cena"));
		//ilosc
		TableColumn<Pozycja, Integer> iloscCol = new TableColumn<>("Ilosc");
		iloscCol.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
		
		bookTable.getColumns().addAll(typCol, tytulCol, autorCol, cenaCol, iloscCol);
		
	}
	
	public void backShop() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ShopScreen.fxml");
		ShopController shopController = loader.getController();
		shopController.setMainController(mainController);
	}
}
