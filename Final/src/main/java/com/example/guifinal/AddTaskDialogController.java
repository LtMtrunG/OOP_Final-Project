package com.example.guifinal;

import com.example.guifinal.Task.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AddTaskDialogController implements Initializable {
    @FXML
    private Label errorMessage;
    @FXML
    private DatePicker DPDeadline;
    @FXML
    private TextArea TATask;

    private String formatDatePickerValue(LocalDate localDate){
        String unformatted = localDate.toString();
        String formatted = String.valueOf(unformatted.charAt(8)) + unformatted.charAt(9) + "/" + unformatted.charAt(5) + unformatted.charAt(6) + "/" + unformatted.charAt(0) + unformatted.charAt(1) + unformatted.charAt(2) + unformatted.charAt(3);
        return formatted;
    }

    @FXML
    protected void onAddButtonClick(ActionEvent event) {
        try {
            String deadline = formatDatePickerValue(DPDeadline.getValue());
            String task = TATask.getText().trim();

            Task newTask = new Task(deadline,task);
            AdminHomeController.taskList.add(newTask);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add New Task");

            alert.setHeaderText(null);
            alert.setContentText("Add New Task Successfully");

            //close dialog box
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
        catch (NullPointerException e){
            errorMessage.setText("Missing input");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
