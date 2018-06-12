package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application  implements EventHandler {
    private Label title;
    private Label response;
    private Label selected;
    private CheckBox bananaCB;
    private CheckBox mangoCB;
    private CheckBox papayaCB;
    private CheckBox grapefruitCB;
    private String fruits;
    private FlowPane flowPaneRoot;



    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Favorite Fruit");
         flowPaneRoot = new FlowPane(Orientation.VERTICAL, 5,5);
        flowPaneRoot.setAlignment(Pos.CENTER);

        //TODO: Add all of our controls
        title = new Label("What's fruit do you like?");
        response = new Label("");
        selected = new Label("");
        flowPaneRoot.getChildren().add(title);
        flowPaneRoot.getChildren().add(response);

        //Fruits : checkboxes
        bananaCB = new CheckBox("Banana");
        mangoCB = new CheckBox("Mango");
        papayaCB = new CheckBox("Papaya");
        grapefruitCB = new CheckBox("Grapefruit");

        flowPaneRoot.getChildren().addAll(bananaCB,mangoCB,papayaCB,grapefruitCB,selected);
        bananaCB.setOnAction(this);
        mangoCB.setOnAction(this);
        papayaCB.setOnAction(this);
        grapefruitCB.setOnAction(this);



        Scene scene = new Scene(flowPaneRoot, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        showAll();

    }

    void showAll() {
        fruits="";
        for (Object obj: flowPaneRoot.getChildren().toArray()) {
            if (obj instanceof CheckBox){
                CheckBox checkBox = (CheckBox)obj;
                if(checkBox.isSelected()) {
                    fruits+=" "+ checkBox.getText();
                }
            }
        }
        selected.setText("Selected Fruits:"+fruits);
    }


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void handle(Event event) {
        CheckBox selectedFruit = (CheckBox)event.getSource();
        response.setText("Last selected: " +selectedFruit.getText());
        showAll();
    }
}
