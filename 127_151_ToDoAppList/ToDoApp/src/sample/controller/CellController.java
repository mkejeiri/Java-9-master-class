package sample.controller;
import com.jfoenix.controls.JFXListCell;

import java.io.IOException;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.database.DbHandler;
import sample.model.Task;
import sample.shared.Helper;

public class CellController extends JFXListCell<Task> {

    @FXML
    private Label labelTask;

    @FXML
    private Label labelDescription;

    @FXML
    private ImageView iconTask;

    @FXML
    private ImageView iconDelete;

    @FXML
    private JFXListView<Task> listViewTasks;

    @FXML
    private Label labelDateCreated;

    @FXML
    private AnchorPane ancorPaneCellTask;



    @FXML
    private ImageView iconUpdate;

    @FXML
    private  FXMLLoader fxmlLoader;

    private   DbHandler dbHandler;

    @FXML
    void initialize() {


        fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/taskcell.fxml"));
        fxmlLoader.setController(this);
        iconDelete.setOnMouseClicked(event -> {
            int taskId= getItem().getTaskId();
            getListView().getItems().remove(getItem());
            dbHandler = new DbHandler();
            dbHandler.deleteTask(taskId);
        });

        iconUpdate.setOnMouseClicked(event -> {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Helper.class.getResource("/sample/view/updatetaskform.fxml"));
            try {
                loader.load();
                UpdateTaskController updateTaskController= loader.getController();
                Task task = getItem();
                updateTaskController.setTask(task);
                updateTaskController.fillInGUI();
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setTitle("Update Task");
                stage.setScene(new Scene(root, 700, 400));
                stage.showAndWait();
                stage.setResizable(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void updateItem(Task myTask, boolean empty) {
        super.updateItem(myTask, empty);
        if(empty || myTask == null){
            setText(null);
            setGraphic(null);

        }else {
            if (fxmlLoader == null){
                fxmlLoader = new FXMLLoader(getClass().getResource("/sample/view/taskcell.fxml"));
                fxmlLoader.setController(this);
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            labelTask.setText(myTask.getTask());
            labelDescription.setText(myTask.getDescription());
            labelDateCreated.setText(myTask.getDateCreated().toString());
            System.out.println(myTask.getDateCreated().toString());
            setText(null);
            setGraphic(ancorPaneCellTask);

        }
    }
}
