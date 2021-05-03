package gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.util.Util;
import com.sun.javafx.util.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainViewController implements Initializable {
	
	@FXML
	private Button btHome;
	
	@FXML
	private Button btExit;
	
	@FXML
	public void onBtExitAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

}
