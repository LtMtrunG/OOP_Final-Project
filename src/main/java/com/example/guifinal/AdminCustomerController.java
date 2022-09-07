package com.example.guifinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminCustomerController implements Initializable {
    @FXML
    private ChoiceBox<String> cbCustomerType;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbCustomerType.getItems().addAll("Guest Account", "Regular Account", "VIP Account");
    }
}
