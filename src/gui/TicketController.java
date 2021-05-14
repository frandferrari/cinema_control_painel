package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import entities.Ticket;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class TicketController implements Initializable {

	@FXML
	public Button btHome;

	@FXML
	public Button btExit;

	@FXML
	private ComboBox<Ticket> ticketNormal;

	@FXML
	private ComboBox<Ticket> ticketHalf;
	
	@FXML
	private ComboBox<Ticket> ticketStudent;
	
	@FXML
	private ComboBox<Ticket> ticketElderly;

	private ObservableList<Ticket> ticketList;

	@FXML
	public void onImageMatrixTicketClicked() {
		loadView("/gui/Matrix.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageFastAndFuriousTicketClicked() {
		loadView("/gui/Fast_and_Furious.fxml", x -> {
		});
	}
	
	@FXML
	public void onBtExitAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@FXML
	public void onBtHomeAction() {
		loadView("/gui/MainView.fxml", x -> {
		});
	}

	@FXML
	public void onComboBoxTicketNormalAction() {
		Ticket Ticket = ticketNormal.getSelectionModel().getSelectedItem();
		System.out.println(Ticket);
	}
	
	@FXML
	public void onComboBoxTicketHalfAction() {
		Ticket Ticket = ticketHalf.getSelectionModel().getSelectedItem();
		System.out.println(Ticket);
	}
	
	@FXML
	public void onComboBoxTicketStudentAction() {
		Ticket Ticket = ticketStudent.getSelectionModel().getSelectedItem();
		System.out.println(Ticket);
	}
	
	@FXML
	public void onComboBoxTicketElderlyAction() {
		Ticket Ticket = ticketElderly.getSelectionModel().getSelectedItem();
		System.out.println(Ticket);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket("1", 1));
		list.add(new Ticket("2", 2));
		list.add(new Ticket("3", 3));
		list.add(new Ticket("4", 4));
		list.add(new Ticket("5", 5));
		list.add(new Ticket("6", 6));
		list.add(new Ticket("7", 7));
		list.add(new Ticket("8", 8));
		list.add(new Ticket("9", 9));
		list.add(new Ticket("10", 10));

		ticketList = FXCollections.observableArrayList(list);
		ticketNormal.setItems(ticketList);
		ticketNormal.getItems();
		ticketHalf.setItems(ticketList);
		ticketHalf.getItems();
		ticketStudent.setItems(ticketList);
		ticketStudent.getItems();
		ticketElderly.setItems(ticketList);
		ticketElderly.getItems();

		Callback<ListView<Ticket>, ListCell<Ticket>> factory = lv -> new ListCell<Ticket>() {
			@Override
			protected void updateItem(Ticket item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getNumber());
			}
		};

		ticketNormal.setCellFactory(factory);
		ticketNormal.setButtonCell(factory.call(null));
		ticketHalf.setCellFactory(factory);
		ticketHalf.setButtonCell(factory.call(null));
		ticketStudent.setCellFactory(factory);
		ticketStudent.setButtonCell(factory.call(null));
		ticketElderly.setCellFactory(factory);
		ticketElderly.setButtonCell(factory.call(null));

	}

	protected synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			AnchorPane newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			AnchorPane mainVBox = (AnchorPane) (mainScene.getRoot());

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
