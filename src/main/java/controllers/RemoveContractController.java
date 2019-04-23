package controllers;

import dzial_programowy.Autor;
import dzial_programowy.Umowa;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
public class RemoveContractController {
	MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	ComboBox<Umowa> chooseContract;
	ObservableList<Umowa> contracts = FXCollections.observableArrayList();

	@FXML
	public void removeContract() {
		mainController.d_prog.rozwiazUmowe(chooseContract.getValue());
		if(!contracts.isEmpty()) {
			mainController.showInfoAlert("Wybrana umowa zostala rozwiazana.");
		}
		else mainController.showErrorAlert("Lista umow jest pusta.");
		
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ContractScreen.fxml");
		ContractController contractController = loader.getController();
		contractController.setMainController(mainController);
		contractController.removeContract();
	}
	
	@FXML
	public void backContractScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ContractScreen.fxml");
		ContractController contractController = loader.getController();
		contractController.setMainController(mainController);
	}

}
