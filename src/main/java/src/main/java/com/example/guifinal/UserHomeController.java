package com.example.guifinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class UserHomeController implements Initializable {
    @FXML
    private Label username;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(LoginController.account.getName());
    }
}
