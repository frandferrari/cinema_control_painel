package frames;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entities.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import entities.Movie;

public class MainViewController implements Initializable {

	@FXML
	private ComboBox<Movie> comboBoxMovie;
	
	@FXML
	private Button btAll;
	
	private ObservableList<Movie> obsList;
	
	@FXML
	public void onComboBoxMovieAction() {
		Movie Movie = comboBoxMovie.getSelectionModel().getSelectedItem();
		System.out.println(Movie);
	}
	
	@FXML
	public void onBtAllAction() {
		for (Movie movie : comboBoxMovie.getItems()) {
			System.out.println(movie);
		}
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
}
