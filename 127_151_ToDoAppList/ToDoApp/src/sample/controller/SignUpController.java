package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import sample.database.DbHandler;
import sample.model.User;

public class SignUpController {

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnRegister;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    @FXML
    private JFXTextField txtUserFirstName;

    @FXML
    private JFXTextField txtLastName;

    @FXML
    private JFXTextField txtLocation;

    @FXML
    private JFXCheckBox cbMale;

    @FXML
    private JFXCheckBox cbFemale;

    @FXML
    void initialize() {
        createUser();
    }

    private void createUser() {
        btnRegister.setOnAction(event -> {
            DbHandler dbHandler = new DbHandler();

            String firstName = txtUserFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String userName = txtUserName.getText().trim();
            String password = txtPassword.getText().trim();
            String location = txtLocation.getText().trim();
            String gender ="";

            if (cbFemale.isSelected()) gender="female";
            else if (cbMale.isSelected()) gender="male";

            User user = new User(firstName,lastName,userName,password,location,gender);
            dbHandler.signUp(user);
        });
    }
}
