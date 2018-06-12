package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
//import javafx.scene.layout.StackPane;

/*
* Application class is the barebone that implements
* FX functionalities need for building an FX project
*
* */
public class Main extends Application {
    private Scene scene;
    private Button button;
    private Button clearAll;
    private TextField myTextField;
    private Label myLabel;
    private int count = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
                primaryStage.setTitle("Hello Java FX");
                //StackPane root = new StackPane();
                FlowPane rootFlow = new FlowPane(Orientation.VERTICAL, 8,4);
                rootFlow.setAlignment(Pos.CENTER);
                /*rootFlow.setVgap(8);
                rootFlow.setHgap(4);*/
                button = new Button("Display");
                clearAll = new Button("Clear all");
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        count++;
                        button.setText("Display clicked " + count + " times");
                        myLabel.setText(myTextField.getText().trim());
                    }
                });
                clearAll.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        myTextField.setText("");
                        myLabel.setText("");
                    }
                });
                myTextField= new TextField();
                myLabel= new Label("");
                myTextField.setPromptText("Enter text here");
                rootFlow.getChildren().add(button);
                rootFlow.getChildren().add(myTextField);
                rootFlow.getChildren().add(myLabel);
                rootFlow.getChildren().add(clearAll);
                scene = new Scene(rootFlow, 300,300);
                primaryStage.setScene(scene);
                primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
