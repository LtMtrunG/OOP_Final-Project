package com.example.guifinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTaskDialogController implements Initializable {
    @FXML
    private TextArea task;
    @FXML
    protected void onAddButtonClick(ActionEvent e) {
        //get input


        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        task.setWrapText(true);
    }
}
