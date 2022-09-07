package com.example.guifinal;

import SystemManagement.Customer.Customer;
import SystemManagement.Customer.GuestAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
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

    protected void displayCustomer(Customer c) {
        tfName.setText(c.getName());
        tfAddress.setText(c.getAddress());
        tfPhone.setText(c.getPhone());
        tfUsername.setText(c.getUsername());
        tfPassword.setText(c.getPassword());
    }

    @FXML
    protected void onUpdateButtonCLick(ActionEvent e) {
        String name = tfName.getText().trim();
        String address = tfAddress.getText().trim();
        String phone = tfPhone.getText().trim();
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();

        //check the account type & improve the ID
        GuestAccount user = new GuestAccount("C007", name, address, phone, username, password, 1);

        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
