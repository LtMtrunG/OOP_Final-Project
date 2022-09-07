package com.example.guifinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminItemController implements Initializable {
    @FXML
    private ChoiceBox<String> cbRentalType;
    @FXML
    private ChoiceBox<String> cbStatus;
    @FXML
    protected void onAddItemButtonClick() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AddItemDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 450);
        Stage stage = new Stage();
        stage.setTitle("Add New Item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbRentalType.getItems().addAll("Record", "DVD","Game");
        cbStatus.getItems().addAll("Available", "Out of Stock");
    }
}
