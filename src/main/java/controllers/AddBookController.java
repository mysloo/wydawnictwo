package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.Album;
import dzial_programowy.Autor;
import dzial_programowy.Miesiecznik;
import dzial_programowy.Romans;
import dzial_programowy.Sensacyjne;
import dzial_programowy.Tygodnik;
import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AddBookController implements Initializable{
	MainController mainController;
	@FXML
	private TextField titleField, priceField;
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	ComboBox<Autor> chooseAuthor;
	private ObservableList<String> list = FXCollections.observableArrayList(Album.class.getSimpleName(), Miesiecznik.class.getSimpleName(),
			Romans.class.getSimpleName(), Sensacyjne.class.getSimpleName(), Tygodnik.class.getSimpleName());
	ObservableList<Autor> authorList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comboBox.setItems(list);
	}	
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	public void addNewBook() {
		try {
			tryAddNewBook();
		}
		catch(Throwable t) {
			mainController.showErrorAlert("Wprowadzono bledne dane.");
		}
	}
	
	public void tryAddNewBook() throws Throwable{
		try {
			if(comboBox.getValue().equals("Album")) mainController.d_prog.zleceniePracy(chooseAuthor.getValue(), new Album(chooseAuthor.getValue(), titleField.getText(), Double.parseDouble(priceField.getText())));
			if(comboBox.getValue().equals("Miesiecznik")) mainController.d_prog.zleceniePracy(chooseAuthor.getValue(), new Miesiecznik(chooseAuthor.getValue(), titleField.getText(), Double.parseDouble(priceField.getText()))) ;
			if(comboBox.getValue().equals("Romans")) mainController.d_prog.zleceniePracy(chooseAuthor.getValue(), new Romans(chooseAuthor.getValue(), titleField.getText(), Double.parseDouble(priceField.getText())));
			if(comboBox.getValue().equals("Sensacyjne")) mainController.d_prog.zleceniePracy(chooseAuthor.getValue(), new Sensacyjne(chooseAuthor.getValue(), titleField.getText(), Double.parseDouble(priceField.getText())));
			if(comboBox.getValue().equals("Tygodnik")) mainController.d_prog.zleceniePracy(chooseAuthor.getValue(), new Tygodnik(chooseAuthor.getValue(), titleField.getText(), Double.parseDouble(priceField.getText())));			
			mainController.showInfoAlert("Udalo sie zlecic prace.");
		}
		catch(CzyPoprawnyStringException e) {
			mainController.showErrorAlert("Wystapil blad.\nPowod: "+e.getMessage()+".\nZlecenie pracy nie powiodlo sie.");
		}
		catch(UjemnaWartoscException e) {
			mainController.showErrorAlert("Wystapil blad:\nPowod: "+e.getMessage()+"\nOperacja nie zostala wykonana.");
		}
	}
	@FXML
	public void backManagement() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/ManagementScreen.fxml");
		ManagementController managementController = loader.getController();
		managementController.setMainController(mainController);
	}


}
