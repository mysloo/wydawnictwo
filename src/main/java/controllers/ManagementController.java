package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ManagementController{

	private MainController mainController;
	

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	@FXML
	public void openContracts() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ContractScreen.fxml");
		
		ContractController contractController= loader.getController();
		contractController.setMainController(mainController);
	}

	@FXML
	public void openAuthors() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/authors/AuthorScreen.fxml");
		
		AuthorController authorController= loader.getController();
		authorController.setMainController(mainController);
	}
	
	
	@FXML
	public void addBook() {//zlec prace autorowi
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/AddBookScreen.fxml");
		
		AddBookController addSheet = loader.getController();
		for(Umowa u : mainController.d_prog.getListaUmow()) {
			if(u instanceof Umowa_o_prace)	addSheet.authorList.addAll(u.getAutor());
		}
		addSheet.chooseAuthor.setItems(addSheet.authorList);
		
		addSheet.setMainController(mainController);
	}
	
	@FXML
	public void orderPrint() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/OrderPrintScreen.fxml");
		
		OrderPrintController orderPrintController= loader.getController();
		for(Autor a : mainController.d_prog.getListaAutorow()) {
			orderPrintController.books.addAll(a.getListaPozycji());
		}
		orderPrintController.chooseBook.setItems(orderPrintController.books);
		
		orderPrintController.setMainController(mainController);
	}
	
	@FXML
	public void backMenu() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/MenuScreen.fxml");
		MenuController menuController = loader.getController();
		menuController.setMainController(mainController);
	}


}
