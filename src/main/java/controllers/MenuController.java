package controllers;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class MenuController {
	//ZAPISUJ PRZED URUCHOMIENIEM SCENE BUILDERA!!!
	@FXML //tworze sobie pole klasy(nie z scene buildera)
	private MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	public void initialize() {
		
	}
	@FXML
	public void zapiszDoPliku(){
		mainController.getW().zapisDoPliku("dane.xml");
	}
	@FXML
	public void openManagement() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ManagementScreen.fxml");
		
		ManagementController manageController = loader.getController(); // tak jak tworzenie obiektu, tylko zamiast new jest getController a to jest moja klasa;
		//cos jak tworzenie obiektu
		manageController.setMainController(mainController);
	}
	@FXML
	public void openShop() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ShopScreen.fxml");
		
		ShopController shopController = loader.getController();
		shopController.setMainController(mainController);
	}

	@FXML
	public void exit() {
		Platform.exit();
	}
}
