package sample.controller;
import java.sql.SQLException;
/*import java.sql.Timestamp;
import java.time.LocalDateTime;*/
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.jfoenix.controls.JFXListView;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.util.Duration;
import sample.animations.Shaker;
import sample.database.DbHandler;
import sample.model.Task;
import sample.shared.Helper;

public class ListController extends Controller {

    @FXML
    private AnchorPane ancorPanelTasksList;

    @FXML
    private JFXButton btnAddTask;

    @FXML
    private JFXTextField txtTask;


    @FXML
    private JFXListView<Task> listViewTasks;


    @FXML
    private JFXTextField txtTaskDescription;

    private ObservableList<Task> taskItems;

    @FXML
    private Label labelTaskAddedMsg;

    @FXML
    private ImageView imgListRefreshList;

    @FXML
    void initialize()  {
        DbHandler dbHandler = fillCreateCells();

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
                fillCreateCells();

            }else {
                Shaker shakeUserName = new Shaker(txtTask);
                shakeUserName.shake();
                Shaker shakePassword = new Shaker(txtTaskDescription);
                shakePassword.shake();
                System.out.println("Task fields are required!");
            }
        }));

        imgListRefreshList.setOnMouseClicked(event -> {
            fillCreateCells();
        });
    }



    private DbHandler fillCreateCells() {
        taskItems = FXCollections.observableArrayList();
        DbHandler dbHandler = new DbHandler();
       /* try {
            //dbHandler.getTotalTasks(this.currentUserId);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*Task task = new Task();
        task.setDescription("desc");
        task.setTask("task");
        task.setDateCreated(Timestamp.valueOf(LocalDateTime.now()));
        taskItems.add(task);
        listViewTasks.setItems(taskItems);
        listViewTasks.setCellFactory(c -> new CellController());*/
        try {
            ArrayList<Task> taskList = Helper.getTasksFormatted(dbHandler.getAllTasksByUserId(currentUserId));

            taskItems.addAll(taskList);
            listViewTasks.setItems(taskItems);
            listViewTasks.setCellFactory(CellController -> new CellController());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbHandler;
    }

    /*static class JFXCell extends JFXListCell<String> {
        //Hbox = Horizontal Box

        HBox hBox= new HBox();
        Button helloButton = new Button("hello");
        Label task = new Label();
        Pane pane = new Pane();
        Image icon = new Image("/sample/assets/todo_icon_small.png");
        ImageView iconImg = new ImageView(icon);

        public JFXCell() {
            super();
            hBox.getChildren().addAll(iconImg,task, helloButton);
            hBox.setHgrow(pane, Priority.ALWAYS);
        }

        public void updateItem(String taskName, boolean empty){
            super.updateItem(taskName,empty);
            setText(null);
            setGraphic(null);

            if (taskName !=null && !empty){
                task.setText(taskName);
                setGraphic(hBox);
            }
        }

    }*/

    void fadeControl(Control control){
        FadeTransition formPaneTransition = new FadeTransition(Duration.millis(2000),control);
        formPaneTransition.setFromValue(0f);
        formPaneTransition.setToValue(1f);
        formPaneTransition.setCycleCount(1);
        formPaneTransition.setAutoReverse(false);
        formPaneTransition.play();

    }
}







