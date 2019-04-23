package controllers;

import java.io.IOException;

import dzial_programowy.Autor;
import dzial_programowy.Pozycja;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class AuthorController {
	MainController mainController;


	
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void addAuthor() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/AddAuthorScreen.fxml");
	
		AddAuthorController addAuthorController = loader.getController();
		addAuthorController.setMainController(mainController);
	}
	
	@FXML
	public void removeAuthor() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/RemoveAuthorScreen.fxml");

		RemoveAuthorController removeAuthorController = loader.getController();
		removeAuthorController.setMainController(mainController);
	}
	
	@FXML
	public void displayAuthors() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/ListOfAuthors.fxml");
		
		
		ListOfAuthorsController listAuthorsController = loader.getController();
		//!!!!
		listAuthorsController.listaAutorow.addAll(mainController.d_prog.getListaAutorow());
		listAuthorsController.autorzy.setItems(listAuthorsController.listaAutorow);
		//!!!!
		listAuthorsController.setMainController(mainController);
	}
	
	@FXML
	public void backAuthorScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ManagementScreen.fxml");
		ManagementController managementController = loader.getController();
		managementController.setMainController(mainController);
	}
}
