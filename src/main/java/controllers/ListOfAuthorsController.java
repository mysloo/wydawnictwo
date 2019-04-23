package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.Autor;
import dzial_programowy.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListOfAuthorsController implements Initializable {
	
	MainController mainController;
	
	@FXML
	public TableView<Autor> autorzy;
	public ObservableList<Autor> listaAutorow = FXCollections.observableArrayList();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//imie
		TableColumn<Autor, String> imieCol = new TableColumn<>("Imie");
		imieCol.setCellValueFactory(new PropertyValueFactory<>("imie"));
		//nazwisko
		TableColumn<Autor, String> nazwiskoCol = new TableColumn<>("Nazwisko");
		nazwiskoCol.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
		
		autorzy.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		autorzy.getColumns().clear();
		autorzy.getColumns().addAll(imieCol, nazwiskoCol);
	}


	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void backAuthorScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/AuthorScreen.fxml");
		AuthorController authorController = loader.getController();
		authorController.setMainController(mainController);
	}


}
