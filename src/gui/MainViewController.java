package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import entities.Movie;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class MainViewController implements Initializable {

	@FXML
	private ComboBox<Movie> comboBoxMovie;

	@FXML
	private Button btAll;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private Button btExit;
	
	@FXML
	private Button matrixTeste;

	@FXML
	private Button btHome;

	private ObservableList<Movie> obsList;

	@FXML
	public void onComboBoxMovieAction() {
		Movie Movie = comboBoxMovie.getSelectionModel().getSelectedItem();
		System.out.println(Movie);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Movie> list = new ArrayList<>();
		list.add(new Movie(1, "Matrix"));
		list.add(new Movie(2, "Fast and Furious"));
		list.add(new Movie(3, "Interestellar"));
		list.add(new Movie(4, "Toy Story"));

		obsList = FXCollections.observableArrayList(list);
		comboBoxMovie.setItems(obsList);
		comboBoxMovie.getItems();

		Callback<ListView<Movie>, ListCell<Movie>> factory = lv -> new ListCell<Movie>() {
			@Override
			protected void updateItem(Movie item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};

		comboBoxMovie.setCellFactory(factory);
		comboBoxMovie.setButtonCell(factory.call(null));

	}
	
	@FXML
	public void onMenuItemAboutAction() {
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