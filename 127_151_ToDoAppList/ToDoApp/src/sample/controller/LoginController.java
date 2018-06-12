package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import sample.animations.Shaker;
import sample.shared.Helper;
import sample.database.Const;
import sample.database.DbHandler;
import sample.model.User;

public class LoginController extends Controller{

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
            Helper.navigateToGUI("/sample/view/signUp.fxml", "Sign up");
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
                        currentUserId = resultSet.getInt(Const.USERS_USERID);
                        currentUserId = resultSet.getInt(Const.USERS_USERID);

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (count == 1) {
                    btnLogin.getScene().getWindow().hide();
                    //AddItemFormController addItemFormController

                    //FXMLLoader loader = Helper.navigateToGUI("/sample/view/addItem.fxml", "add Item");
                    Helper.navigateToGUI("/sample/view/addItem.fxml", "add Item");
                    //AddItemController addItemController = loader.getController();
                    System.out.println("Login successful");
                    System.out.println("Welcome :  " + name);
                }
                else {
                    Shaker shakeUserName = new Shaker(txtUsername);
                    shakeUserName.shake();
                    Shaker shakePassword = new Shaker(txtPassword);
                    shakePassword.shake();
                }

            }else
            {
                System.out.println("Error log in..........");
            }

        });
    }

  /*  private void navigateToGUI(String viewPath, String Title) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(viewPath));
        try {
            loader.load();
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle(Title);
            stage.setScene(new Scene(root, 700, 400));
            stage.showAndWait();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/


}
