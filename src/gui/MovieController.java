package gui;

import java.io.IOException;
import java.util.function.Consumer;

import application.Main;
import entities.Ticket;
import gui.util.Alerts;
import gui.util.Utils;
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
	public ComboBox<Ticket> ticketNormal;

	@FXML
	public ComboBox<Ticket> ticketHalf;

	@FXML
	public ComboBox<Ticket> ticketStudent;

	@FXML
	public ComboBox<Ticket> ticketElderly;

	@FXML
	public ImageView imageMatrix;
	
	@FXML
	public ImageView imageFastAndFurious;
	
	@FXML
	public ImageView imageInterestellar;
	
	@FXML
	public ImageView imageToyStory;
	
	@FXML
	public ImageView imageImpossible;
	
	@FXML
	public ImageView imageAvengers;
	
	@FXML
	public ImageView imageForrestGump;
	
	@FXML
	public Button next;

	@FXML
	public void onImageMatrixMouseClicked() {
		loadView("/gui/Matrix.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageFastAndFuriousMouseClicked() {
		loadView("/gui/Fast_and_Furious.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageInterestellarMouseClicked() {
		loadView("/gui/Interestellar.fxml", x -> {
		});
	}

	@FXML
	public void onImageToyStoryMouseClicked() {
		loadView("/gui/Toy_Story.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageImpossibleMouseClicked() {
		loadView("/gui/Impossible.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageAvengersMouseClicked() {
		loadView("/gui/Avengers.fxml", x -> {
		});
	}
	
	@FXML
	public void onImageForrestGumpMouseClicked() {
		loadView("/gui/ForrestGump.fxml", x -> {
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
