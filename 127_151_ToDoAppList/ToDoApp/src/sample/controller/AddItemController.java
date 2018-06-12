package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import sample.animations.Shaker;
import javafx.scene.layout.AnchorPane;
import sample.shared.Helper;

public class AddItemController  extends  Controller{

    @FXML
    private Label labelNoTask;

    @FXML
    private ImageView btnAddItem;


    @FXML
    private AnchorPane anchorPaneAddItem;



    @FXML
    void initialize() {
        btnAddItem.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            Helper.addTaskChecker(anchorPaneAddItem,btnAddItem,
                           labelNoTask,"/sample/view/additemform.fxml");
        });
    }


}

