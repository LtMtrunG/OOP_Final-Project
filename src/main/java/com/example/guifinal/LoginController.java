package com.example.guifinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class LoginController {
    @FXML
    private Label errorMessage;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private CheckBox checkBoxRememberMe;

    @FXML
    protected HashMap<String,String> handleCheckBoxRememberMe(ActionEvent e) {
        HashMap<String, String> account = new HashMap<>();
        if(checkBoxRememberMe.isSelected()){
            account.put(username.getText(), password.getText());
        }
        return account;
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent e) throws IOException {
        if(username.getText().equals("user")) {
            Parent fxml = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxml, 1320, 800);
            stage.setScene(scene);
            stage.show();
        } else if (username.getText().equals("admin")){
            Parent fxml = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxml, 1320, 800);
            stage.setScene(scene);
            stage.show();
        } else {
            errorMessage.setText("Invalid username or password");
        }
    }

    @FXML
    protected void onCreateAnAccountClick() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(fxml, 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Registration");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
