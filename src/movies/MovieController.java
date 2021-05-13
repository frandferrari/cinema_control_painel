package movies;

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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MovieController {

	@FXML
	public Button btHome;

	@FXML
	public Button btExit;

	@FXML
	public ComboBox<Ticket> ticketNormal;

	@FXML
	public ComboBox<Ticket> ticketHalf;

	@FXML
	public ComboBox<Ticket> ticketStudent;

	@FXML
	public ComboBox<Ticket> ticketElderly;

	@FXML
	public Button next;

	@FXML
	public ImageView imageTest;

	private ObservableList<Ticket> ticketList;

	@FXML
	public void onImageTestMouseClicked() {
		loadView("/movies/Matrix.fxml", x -> {
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

	public void initialize(URL url, ResourceBundle rb) {
		List<Ticket> list = new ArrayList<>();
		list.add(new Ticket(1));
		list.add(new Ticket(2));
		list.add(new Ticket(3));
		list.add(new Ticket(4));

		ticketList = FXCollections.observableArrayList(list);
		ticketNormal.setItems(ticketList);
		ticketNormal.getItems();

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
