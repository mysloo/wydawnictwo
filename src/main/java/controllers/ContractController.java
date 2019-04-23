package controllers;

import java.io.IOException;

import dzial_programowy.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ContractController {
	MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	
	@FXML
	public void addContract() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/AddContractScreen.fxml");
		
		AddContractController addContractController = loader.getController();
		addContractController.authors.addAll(mainController.d_prog.getListaAutorow());
		addContractController.chooseAuthor.setItems(addContractController.authors);
		
		addContractController.setMainController(mainController);
	}
	
	
	@FXML
	public void displayContrats() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ListOfContracts.fxml");
		
		ListOfContractsController listOfContractsController = loader.getController();
		//!!!!
		listOfContractsController.listaUmow.addAll(mainController.d_prog.getListaUmow());
		listOfContractsController.contractTable.setItems(listOfContractsController.listaUmow);
		//!!!!
		listOfContractsController.setMainController(mainController);
	}
	
	@FXML
	public void removeContract() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/RemoveContractScreen.fxml");
	
		RemoveContractController removeContractController = loader.getController();	
		for(Umowa u: mainController.d_prog.getListaUmow()){
			if(u instanceof Umowa_o_prace) removeContractController.contracts.add(u);
		}
		removeContractController.chooseContract.setItems(removeContractController.contracts);
		
		removeContractController.setMainController(mainController);
	}
	
	@FXML
	public void backManagement() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ManagementScreen.fxml");
		ManagementController managementController = loader.getController();
		managementController.setMainController(mainController);
	}
}
