package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import dzial_programowy.*;
import exceptions.CzyPoprawnyStringException;
import exceptions.UjemnaWartoscException;
public class AddContractController implements Initializable{
	MainController mainController;

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	TextField time_titleField, paymentField, priceField;
	@FXML
	private ComboBox<String> chooseContract;
	@FXML
	ComboBox<Autor> chooseAuthor;
	@FXML
	ComboBox<String> chooseTypeBook;
	
	private ObservableList<String> contracts = FXCollections.observableArrayList("Umowa o prace", "Umowa o dzielo");
	ObservableList<Autor> authors = FXCollections.observableArrayList();	
	ObservableList<String> types = FXCollections.observableArrayList(Album.class.getSimpleName(), Miesiecznik.class.getSimpleName(),
			Romans.class.getSimpleName(), Sensacyjne.class.getSimpleName(), Tygodnik.class.getSimpleName());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chooseContract.setItems(contracts);
		chooseTypeBook.setItems(types);
	}
	
	@FXML
	public void onChooseContract() {
		if(chooseContract.getValue().equals("Umowa o prace")) {
			time_titleField.setVisible(true);
			chooseTypeBook.setVisible(false);
			priceField.setVisible(false);
			time_titleField.setPromptText("Czas trwania umowy");
			
		}
		else if(chooseContract.getValue().equals("Umowa o dzielo")){
			chooseTypeBook.setVisible(true);
			time_titleField.setVisible(true);
			priceField.setVisible(true);
			time_titleField.setPromptText("Tytul");
		}

	}
	@FXML
	public void addContract() {
		try {
			tryAddContract();
		} catch (Throwable t) {
			mainController.showErrorAlert("Wprowadzono bledne dane.");
		}
	}
	//java.lang.NullPointerException jezeli nie wyplenie pola to to mozna
	public void tryAddContract() throws Throwable{
			if(chooseContract.getValue().equals("Umowa o prace")) {
				try {
				if(mainController.d_prog.zawrzyjUmoweOprace(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
															Integer.parseInt(time_titleField.getText())) == true) {
					mainController.showInfoAlert("Zawarto nowa umowe o prace.");
				}
				else mainController.showErrorAlert("Ten autor ma juz umowe o prace. Nie mozna dodac nowej umowy o prace.");
				}
				catch(UjemnaWartoscException e) {
					mainController.showErrorAlert("Wystapil blad.\nPowod: "+e.getMessage()+" ("+ e.getWartosc()+")");
				}
			}
			else {
				try {
					if(chooseTypeBook.getValue().equals("Album")) {
						if(mainController.d_prog.zawrzyjUmoweOdzielo(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
														new Album(chooseAuthor.getValue(), time_titleField.getText(), Double.parseDouble(priceField.getText())))) {
							mainController.showInfoAlert("Zawarto nowa umowe o dzielo.");
						}
						else mainController.showErrorAlert("Ten autor ma zawarta umowe o prace. Nie mozna dodac nowej umowy o dzielo.");
					}
					if(chooseTypeBook.getValue().equals("Miesiecznik")) {
						if(mainController.d_prog.zawrzyjUmoweOdzielo(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
														new Miesiecznik(chooseAuthor.getValue(), time_titleField.getText(), Double.parseDouble(priceField.getText())))) {
							mainController.showInfoAlert("Zawarto nowa umowe o dzielo.");
						}
						else mainController.showErrorAlert("Ten autor ma zawarta umowe o prace. Nie mozna dodac nowej umowy o dzielo.");
					}
					if(chooseTypeBook.getValue().equals("Romans")) {
						if(mainController.d_prog.zawrzyjUmoweOdzielo(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
														new Romans(chooseAuthor.getValue(), time_titleField.getText(), Double.parseDouble(priceField.getText())))) {
							mainController.showInfoAlert("Zawarto nowa umowe o dzielo.");
						}
						else mainController.showErrorAlert("Ten autor ma zawarta umowe o prace. Nie mozna dodac nowej umowy o dzielo.");
					}
					if(chooseTypeBook.getValue().equals("Sensacyjne")) {
						if(mainController.d_prog.zawrzyjUmoweOdzielo(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
														new Sensacyjne(chooseAuthor.getValue(), time_titleField.getText(), Double.parseDouble(priceField.getText())))) {
							mainController.showInfoAlert("Zawarto nowa umowe o dzielo.");
						}
						else mainController.showErrorAlert("Ten autor ma zawarta umowe o prace. Nie mozna dodac nowej umowy o dzielo.");
					}
					if(chooseTypeBook.getValue().equals("Tygodnik")) {
						if(mainController.d_prog.zawrzyjUmoweOdzielo(chooseAuthor.getValue(), Double.parseDouble(paymentField.getText()),
														new Tygodnik(chooseAuthor.getValue(), time_titleField.getText(), Double.parseDouble(priceField.getText())))) {
							mainController.showInfoAlert("Zawarto nowa umowe o dzielo.");
						}
						else mainController.showErrorAlert("Ten autor ma zawarta umowe o prace. Nie mozna dodac nowej umowy o dzielo.");
					}
				}
				catch(UjemnaWartoscException e) {
					mainController.showErrorAlert("Wystapil blad.\nPowod: "+e.getMessage()+" ("+ e.getWartosc()+")");	
				}
				catch(CzyPoprawnyStringException e) {
					mainController.showErrorAlert("Wystapil blad.\nPowod: "+e.getMessage());				
				}
			}
	}

	
	@FXML
	public void backContractScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ContractScreen.fxml");
		ContractController contractController = loader.getController();
		contractController.setMainController(mainController);
	}
	
}
