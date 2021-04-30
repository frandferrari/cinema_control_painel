package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.User;
import model.exceptions.ValidationException;

public class LoginController implements Initializable {

	private User entity;
	

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtPassword;

	@FXML
	private Label labelErrorLogin;

	@FXML
	private Label labelErrorPassword;

	@FXML
	private Button btEnter;

	@FXML
	private Button btCancel;
	
	public void setSeller(User entity) {
		this.entity = entity;
	}
	
	private User getFormData() {
		User obj = new User();
	}
	
	ValidationException exception = new ValidationException("Validation error");
	
	obj.setUser(Utils.tryParseToInt(txtLogin.getText()));

	if (txtLogin.getText() == null || txtLogin.getText().trim().equals("")) {
		exception.addError("name", "Field can't be empty");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}


}
