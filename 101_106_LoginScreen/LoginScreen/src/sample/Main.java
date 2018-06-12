package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage loginStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/login.fxml"));
        loginStage.setTitle("Login Screen");
        loginStage.setResizable(false);
        loginStage.setScene(new Scene(root, 700, 400));
        loginStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
