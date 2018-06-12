package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.database.Const;
import sample.database.DbHandler;
import sample.model.User;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btnSignUp;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    private DbHandler dbHandler;

    @FXML
    void initialize() {

        dbHandler = new DbHandler();
        btnSignUp.setOnAction(event -> {
            //take user to sign up screen
            btnSignUp.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/signUp.fxml"));
            try {
                loader.load();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Sign up");
                stage.setScene(new Scene(root, 700, 400));
                stage.showAndWait();
                stage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnLogin.setOnAction((event)->{
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            if (!username.equals("") || !password.equals("")){
                User user = new User();
                user.setUserName(username);
                user.setPassword(password);
                ResultSet resultSet = dbHandler.getUser(user);
                String name = null;

                int count = 0;
                try {
                    while (resultSet.next()) {
                        count++;
                        name  = resultSet.getString(Const.USERS_LASTNAME);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (count == 1) {
                    System.out.println("Login successfull");
                    System.out.println("Welcome :  " + name);
                }
                else System.out.println("Invalid username/password");

            }else
            {
                System.out.println("Error log in..........");
            }

        });
    }

}
