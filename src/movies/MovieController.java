package movies;

import java.io.IOException;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MovieController {

	@FXML
	public Button btHome;

	@FXML
	public Button btExit;
	
	@FXML
	public ImageView imageTest;
	
	@FXML
	public void onImageTestMouseClicked() {
		loadView("/movies/Toy_Story.fxml", x -> {
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
