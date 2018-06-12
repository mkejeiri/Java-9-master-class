package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.util.Duration;
import sample.animations.Shaker;
import sample.database.DbHandler;
import sample.model.Task;
import sample.shared.Helper;

public class AddItemFormController  extends  Controller{

    @FXML
    private JFXButton btnAddTask;

    @FXML
    private JFXTextField txtTask;

    @FXML
    private JFXTextField txtTaskDescription;

    @FXML
    private Label labelTaskAddedMsg;

    @FXML
    private JFXButton btnTaskList;

    @FXML
    FXMLLoader loader;


    @FXML
    void initialize() {
        DbHandler dbHandler = new DbHandler();
        UpdateTaskListLable(dbHandler);
        btnAddTask.setOnAction((event -> {
            String taskValue = txtTask.getText().trim();
            String taskDescValue = txtTaskDescription.getText().trim();

            if (!taskValue.equals("") && !taskDescValue.equals("")){
                Task task = new Task();
                task.setUserId(currentUserId);
                task.setTask(taskValue);
                task.setDescription(taskDescValue);
                Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
                task.setDateCreated(timestamp);
                dbHandler.InsertTask(task);
                labelTaskAddedMsg.setVisible(true);
                fadeControl(labelTaskAddedMsg);
                UpdateTaskListLable(dbHandler);

            }else {
                Shaker shakeUserName = new Shaker(txtTask);
                shakeUserName.shake();
                Shaker shakePassword = new Shaker(txtTaskDescription);
                shakePassword.shake();
                System.out.println("Task fields are required!");
            }

        }));

        btnTaskList.setOnAction(event -> {
            loader = Helper.navigateToGUI("/sample/view/list.fxml", "Task list");
        });


    }

    private void UpdateTaskListLable(DbHandler dbHandler) {
        try {
            btnTaskList.setText("Tasks ("+dbHandler.getTotalTasks(currentUserId)+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void fadeControl(Control control){
       FadeTransition formPaneTransition = new FadeTransition(Duration.millis(2000),control);
       formPaneTransition.setFromValue(0f);
       formPaneTransition.setToValue(1f);
       formPaneTransition.setCycleCount(1);
       formPaneTransition.setAutoReverse(false);
       formPaneTransition.play();

   }

}
