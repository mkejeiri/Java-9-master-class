package sample.shared;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.animations.Shaker;
import sample.database.Const;
import sample.model.Task;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Helper {
    public static FXMLLoader navigateToGUI(String viewPath, String Title ) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Helper.class.getResource(viewPath));
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
        return loader;
    }

    public static ArrayList<Task> getTasksFormatted(ResultSet resultSet) throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();
        while (resultSet.next()){
            Task task = new Task();
            task.setUserId(resultSet.getInt(Const.TASKS_USERID));
            task.setTaskId(resultSet.getInt(Const.TASKS_TASKID));
            task.setTask(resultSet.getString(Const.TASKS_TASK));
            task.setDescription(resultSet.getString(Const.TASKS_DESC));
            task.setDateCreated(resultSet.getTimestamp(Const.TASKS_DATECREATED));
            tasks.add(task);
        }
        return tasks;

    }

//ImageView secondaryControl
    public static void addTaskChecker(AnchorPane pane, Object secondaryControl,
                                      Label readonlyControl, String pathView) {
        if (secondaryControl instanceof  ImageView)
        {
            Shaker btnShaker = new Shaker((ImageView)secondaryControl);
            btnShaker.shake();
            FadeTransition BtnAddItemTransition = new FadeTransition(Duration.millis(2000),(ImageView)secondaryControl);
            FadeTransition labelNoTaskTransition = new FadeTransition(Duration.millis(2000),readonlyControl);

            ((ImageView)secondaryControl).relocate(0,20);
            readonlyControl.relocate(0,80);

            ((ImageView)secondaryControl).setOpacity(0);
            readonlyControl.setOpacity(0);

            BtnAddItemTransition.setFromValue(1f);
            BtnAddItemTransition.setToValue(0f);
            BtnAddItemTransition.setCycleCount(1);
            BtnAddItemTransition.setAutoReverse(false);
            BtnAddItemTransition.play();

            labelNoTaskTransition.setFromValue(1f);
            labelNoTaskTransition.setToValue(0f);
            labelNoTaskTransition.setCycleCount(1);
            labelNoTaskTransition.setAutoReverse(false);
            labelNoTaskTransition.play();
        }

        if(secondaryControl instanceof JFXButton){
            Shaker btnShaker = new Shaker((JFXButton)secondaryControl);
            btnShaker.shake();
            FadeTransition BtnAddItemTransition = new FadeTransition(Duration.millis(2000),(JFXButton)secondaryControl);
            FadeTransition labelNoTaskTransition = new FadeTransition(Duration.millis(2000),readonlyControl);

            ((JFXButton)secondaryControl).relocate(0,20);
            readonlyControl.relocate(0,80);

            ((JFXButton)secondaryControl).setOpacity(0);
            readonlyControl.setOpacity(0);

            BtnAddItemTransition.setFromValue(1f);
            BtnAddItemTransition.setToValue(0f);
            BtnAddItemTransition.setCycleCount(1);
            BtnAddItemTransition.setAutoReverse(false);
            BtnAddItemTransition.play();

            labelNoTaskTransition.setFromValue(1f);
            labelNoTaskTransition.setToValue(0f);
            labelNoTaskTransition.setCycleCount(1);
            labelNoTaskTransition.setAutoReverse(false);
            labelNoTaskTransition.play();
        }


        if (!pathView.equals("")){
            try {

                AnchorPane formPane = FXMLLoader.load(Helper.class.getResource(pathView));
                pane.getChildren().setAll(formPane);
                FadeTransition formPaneTransition = new FadeTransition(Duration.millis(2000),formPane);
                formPaneTransition.setFromValue(0f);
                formPaneTransition.setToValue(1f);
                formPaneTransition.setCycleCount(1);
                formPaneTransition.setAutoReverse(false);
                formPaneTransition.play();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
