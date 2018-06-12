package sample.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField loginId;

    @FXML
    private JFXPasswordField passwordId;

    @FXML
    private JFXButton loginButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginId.setStyle("-fx-text-inner-color:#90a4ae");
        passwordId.setStyle("-fx-text-inner-color:#90a4ae");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginUser();
                System.out.println("User: " + loginId.getText().trim());
                System.out.println("with password: '" + passwordId.getText().trim() +"' is logged In!");
            }
        });
    }

    public void loginUser() {
        //get the main window

        if (!loginId.getText().trim().equals("") &&
                !passwordId.getText().trim().equals("")){

            //ready to go the details screen
            loginButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Stage detailStage = new Stage();

            /*
             *   first Alternative
             * */

            loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
            try {
                loader.load();
                Parent root = loader.getRoot();
                DetailsController detailsController = loader.<DetailsController>getController();
                detailsController.setProfile(loginId.getText().trim(), 40, "code Monkey");
                detailStage.setTitle("Profile");
                detailStage.setScene(new Scene(root, 700, 400));
                detailStage.setResizable(false);
                detailStage.show();

            }catch (IOException ex) {}


            /*
            *   2nd Alternative
            * */

            /*try {
                loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
                //Parent root = loader.load(getClass().getResource("/sample/view/details.fxml")); //doesn't works!
                Parent root = loader.load();
                DetailsController detailsController = loader.getController();
                detailsController.setProfile(loginId.getText().trim(), 40, "code Monkey");
                detailStage.setTitle("Profile");
                detailStage.setScene(new Scene(root, 700, 400));
                detailStage.setResizable(false);
                detailStage.show();
            }catch (IOException ex) {}*/
        }
    }
}

