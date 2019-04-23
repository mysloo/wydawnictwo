package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dzial_programowy.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListOfContractsController implements Initializable{
	MainController mainController;
	
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	@FXML
	TableView <Umowa> contractTable;
	public ObservableList<Umowa> listaUmow = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		//rodzajUmowy
		TableColumn<Umowa, String> rodzajUmowyCol = new TableColumn<>("Rodzaj umowy");
		rodzajUmowyCol.setCellValueFactory(new PropertyValueFactory<>("rodzajUmowy"));
		//autor
		TableColumn<Umowa, Autor> autorCol = new TableColumn<>("Autor");
		autorCol.setCellValueFactory(new PropertyValueFactory<>("autor"));
		//wynagrodzenie
		TableColumn<Umowa, Double> wynagrodzenieCol = new TableColumn<>("Pensja(zl)");
		wynagrodzenieCol.setCellValueFactory(new PropertyValueFactory<>("wynagrodzenie"));
		//okres
		TableColumn<Umowa, String> okresCol = new TableColumn<>("Okres");
		okresCol.setCellValueFactory((value -> {
			if(value.getValue().getRodzajUmowy().equals("Umowa o prace")){
				Umowa_o_prace u = (Umowa_o_prace) value.getValue();
				return new ReadOnlyObjectWrapper(u.getOkres());
			}
			else return new ReadOnlyObjectWrapper("---");
		}));
		//pozycja
		TableColumn<Umowa, String> pozycjaCol = new TableColumn<>("Pozycja");
		pozycjaCol.setCellValueFactory((value -> {
			if(value.getValue().getRodzajUmowy().equals("Umowa o dzielo")){
				Umowa_o_dzielo u = (Umowa_o_dzielo) value.getValue();
				return new ReadOnlyObjectWrapper(u.getPozycja());
			}
			else return new ReadOnlyObjectWrapper("---");
		}));		
		
		contractTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		contractTable.getColumns().addAll(rodzajUmowyCol, autorCol, wynagrodzenieCol, okresCol, pozycjaCol);
		
	}
	
	
	@FXML
	public void backContractScreen() {
		FXMLLoader loader = mainController.loadScreen("/wydawnictwo/fxml/contracts/ContractScreen.fxml");
		ContractController contractController = loader.getController();
		contractController.setMainController(mainController);
	}
}
