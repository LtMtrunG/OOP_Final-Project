package com.example.guifinal;

import com.example.guifinal.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class LoginController {
    public static Customer account;
    @FXML
    private Label errorMessage;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;

    public boolean checkAccount() {
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();
        for(Customer customer: Application.customerList.getList()){
            if(customer.getUsername().equals(username) & customer.getPassword().equals(password)){
                account = customer;
                return true;
            }
        }
        return false;
    }

    @FXML
    protected void onLoginButtonClick(ActionEvent e) throws IOException {
        if(checkAccount()) {
            Parent fxml = FXMLLoader.load(getClass().getResource("UserDashboard.fxml"));
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxml, 1320, 800);
            stage.setScene(scene);
            stage.show();
        } else if (tfUsername.getText().equals("admin") & tfPassword.getText().equals("oop")){
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
        stage.setTitle("Register");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
