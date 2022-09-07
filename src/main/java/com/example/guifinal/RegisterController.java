package com.example.guifinal;

import SystemManagement.Customer.Customer;
import SystemManagement.Customer.GuestAccount;
import SystemManagement.Item.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    protected void onRegisterButtonClick(ActionEvent e) {
        //get input
        String name = tfName.getText().trim();
        String address = tfAddress.getText().trim();
        String phone = tfPhone.getText().trim();
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();

        //check input and create new Item
        Customer customer = new GuestAccount();

        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
