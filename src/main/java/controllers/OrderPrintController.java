package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.*;
import exceptions.UjemnaWartoscException;

public class OrderPrintController implements Initializable{
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
	public void orderPrint() {
		try {
			tryOrderPrint();
		}
		catch(Throwable t) {
			mainController.showErrorAlert("Wprowadzono bledne dane.");
		}
	}
	public void tryOrderPrint(){
		UjemnaWartoscException e = mainController.d_prog.zlecDruk(mainController.getW(), chooseBook.getValue(), Integer.parseInt(quantityField.getText()));
		if(e == null) mainController.showInfoAlert("Wydrukowano. Sprawdz magazyn.");
		else mainController.showErrorAlert("Wystapil blad.\nPowod: " + e.getMessage() +"\n Zlecenie nie zostalo zrealizowane.");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	public void backManagement() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ManagementScreen.fxml");
		ManagementController managementController = loader.getController();
		managementController.setMainController(mainController);
	}



}
