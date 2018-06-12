package sample.controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.database.DbHandler;
import sample.model.Task;

public class UpdateTaskController {

    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    @FXML
    private JFXButton btnUpdateTask;

    @FXML
    private JFXTextField txtTask;

    @FXML
    private JFXTextField txtTaskDescription;

    @FXML
    private Label labelTaskAddedMsg;

    private DbHandler dbHandler;

    @FXML
    void initialize() {
        btnUpdateTask.setOnAction(event -> {
            task.setTask(txtTask.getText().trim());
            task.setDescription(txtTaskDescription.getText().trim());
            dbHandler.updateTask(task);
            labelTaskAddedMsg.setVisible(true);
        });
    }

    void fillInGUI(){
        if (task != null){
            dbHandler = new DbHandler();
            txtTask.setText(task.getTask());
            txtTaskDescription.setText(task.getDescription());
        }
    }
}

