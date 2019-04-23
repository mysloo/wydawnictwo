package controllers;

import java.io.IOException;

import dzial_handlowy.*;
import dzial_druku.*;
import dzial_programowy.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import wydawnictwo.Wydawnictwo;

//obsluguje MainScreen
public class MainController {
	
	@FXML
	private StackPane mainStackPane;
	
	public Dzial_Programowy d_prog;//musi byc kazdy z dzialow i wydawnictwo
	private Dzial_Handlowy d_hand;
	private Dzial_Druku d_druk;
	private Magazyn mag;
	private Sklep sklep;
	private Wydawnictwo w;
	
	public Dzial_Programowy getD_prog() {
		return d_prog;
	}

	public Dzial_Handlowy getD_hand() {
		return d_hand;
	}

	public Dzial_Druku getD_druk() {
		return d_druk;
	}

	public Wydawnictwo getW() {
		return w;
	}
	
	public MainController() {
		d_prog = new Dzial_Programowy();
		d_druk = new Dzial_Druku();
		mag = new Magazyn();
		sklep = new Sklep("Nazwa jakiegos sklepu");
		d_hand = new Dzial_Handlowy(mag, sklep);
		w = new Wydawnictwo(d_druk, d_prog, d_hand);
		w.odczytZPliku("dane.xml");
	}
	
	
	@FXML
	public void initialize() {
		loadMainScreen();
	}
	public FXMLLoader loadScreen(String url) {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource(url));
		Node pane = null;
		try {
			pane = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainStackPane.getChildren().clear();
		mainStackPane.getChildren().add(pane);
		return loader;
	}
	public void loadMainScreen() {
		FXMLLoader loader = loadScreen("/wydawnictwo/fxml/MenuScreen.fxml");
		MenuController menuController = loader.getController();
		menuController.setMainController(this);
		//robimy ze menucontroller staje sie mainControllerem i dzieki temu mozemu ustawic stackPanea glownego
	}
	
	public void showInfoAlert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.setTitle("Informacja");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	public void showErrorAlert(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(msg);
		alert.setTitle("Blad");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

}
