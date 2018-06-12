package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;


    private Rotate rotate;
    private double angle;


    private BoxBlur boxBlur;
    private double blurVal;

    private double scaleFactor;
    private Scale scale;

    private Reflection reflection;

    /*private Button changeReflection;*/

   /* private TextField topOffset;
    private TextField fraction;
    private TextField topOpacity;
    private TextField bottomOpacity;*/





    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Life cycle");

        rotateButton = new Button("Rotate");
        blurButton = new Button("Blur Off");
        scaleButton = new Button("Scale");


        //register our buttons
        rotateButton.setOnAction(this);
        blurButton.setOnAction(this);
        scaleButton.setOnAction(this);


        /*changeReflection = new Button("Change reflexion");
        changeReflection.setOnAction(this);*/

        Label label = new Label("Reflexion Adds visual Sparkle");

        //Transformations Settings
        rotate = new Rotate();
        rotateButton.getTransforms().add(rotate);
        angle = 0.0;

        boxBlur = new BoxBlur(1.0,1.0,1);

        scaleFactor= 0.8;
        scale = new Scale(scaleFactor,scaleFactor);
        scaleButton.getTransforms().add(scale);


        //topOffset = 1 & fraction = 1 are default value
        reflection = new Reflection(1.0, 1.0, 0.6,0.7);

        //Or
        reflection.setTopOpacity(0.6);
        reflection.setBottomOpacity(0.7);

        //Set effect to the label
        label.setEffect(reflection);



        FlowPane root  =  new FlowPane(Orientation.HORIZONTAL,15,15);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(rotateButton,blurButton,scaleButton,label);


        /*topOffset = new TextField();
        fraction = new TextField();
        topOpacity = new TextField();
        bottomOpacity = new TextField();
        topOffset.setPromptText("topOffset");
        fraction.setPromptText("fraction");
        topOpacity.setPromptText("topOpacity");
        bottomOpacity.setPromptText("bottomOpacity");*/


        /*root.getChildren().addAll(topOffset,fraction,topOpacity,bottomOpacity, changeReflection);*/


        primaryStage.setScene(new Scene(root, 300, 120));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(rotateButton)){
            angle +=15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateButton.getWidth()/2);
            rotate.setPivotY(rotateButton.getHeight()/2);
        }
        if (event.getSource().equals(blurButton)){
            blurVal++;
            if (blurVal == 10.0){
                blurVal=1.0;
                blurButton.setEffect(null);
                blurButton.setText("Blur Off");

            }else {
                blurButton.setEffect(boxBlur);
                blurButton.setText("Blur On");
            }
            boxBlur.setWidth(blurVal);
            boxBlur.setHeight(blurVal);

        }
        if (event.getSource().equals(scaleButton)){
            scaleFactor+=0.1;
            if (scaleFactor >= 1.5) {
                scaleFactor=0.8;
            }
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        }
       /* if (event.getSource().equals(changeReflection)){
            reflection.setTopOffset(Double.parseDouble(topOffset.getText()));
            reflection.setFraction(Double.parseDouble(fraction.getText()));
            reflection.setTopOpacity(Double.parseDouble(topOpacity.getText()));
            reflection.setBottomOpacity(Double.parseDouble(bottomOpacity.getText()));

        }*/

    }
}

