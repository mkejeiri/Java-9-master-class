package sample;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Button button;

    @Override
    public void start(Stage primaryStage){
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FlowPane root = new FlowPane(Orientation.HORIZONTAL,5,5);

        /*********************************************
        * Using Lambda expression for events handlding.
        **********************************************/
        button = new Button("Lambda expression click");
        button.setOnAction(event ->System.out.println(event));

        root.getChildren().add(button);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
