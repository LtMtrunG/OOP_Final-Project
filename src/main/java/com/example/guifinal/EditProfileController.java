package com.example.guifinal;

import com.example.guifinal.Customer.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    @FXML
    private Label errorMessage;
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
    protected void onUpdateButtonCLick(ActionEvent e) {
        String name = tfName.getText().trim();
        String address = tfAddress.getText().trim();
        String phone = tfPhone.getText().trim();
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Edit profile");
        alert.setHeaderText("Are you sure want to update your profile?");

        Optional<ButtonType> option = alert.showAndWait();

        if(option.get() == ButtonType.OK){
            LoginController.account.setName(name);
            LoginController.account.setAddress(address);
            LoginController.account.setPhone(phone);
            LoginController.account.setUsername(username);
            LoginController.account.setPassword(password);

            for(Customer customer: Application.customerList.getList()){
                if(customer.getId().equals(LoginController.account.getId())){
                    customer = LoginController.account;
                }
            }

            Alert alertMessage = new Alert(Alert.AlertType.INFORMATION);
            alertMessage.setTitle("Edit Profile");

            // Header Text: null
            alertMessage.setHeaderText(null);
            alertMessage.setContentText("Update successfully!");

            alertMessage.showAndWait();
        }

        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfName.setText(LoginController.account.getName());
        tfAddress.setText(LoginController.account.getAddress());
        tfPhone.setText(LoginController.account.getPhone());
        tfUsername.setText(LoginController.account.getUsername());
        tfPassword.setText(LoginController.account.getPassword());
    }
}
