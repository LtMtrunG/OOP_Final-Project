package com.example.guifinal;

import com.example.guifinal.Customer.Customer;
import com.example.guifinal.Customer.GuestAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
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
    private TextField tfConfirmPassword;

    @FXML
    protected void onRegisterButtonClick(ActionEvent e) {
        //get input
        String name = tfName.getText().trim();
        String address = tfAddress.getText().trim();
        String phone = tfPhone.getText().trim();
        String username = tfUsername.getText().trim();
        String password = tfPassword.getText().trim();
        String confirmPassword = tfConfirmPassword.getText().trim();

        for (Customer customer : Application.customerList.getList()) {
            if (customer.getUsername().equals(username) & customer != LoginController.account) {
                errorMessage.setText("This username has been used! Please choose another one.");
                return;
            }
        }

        if(!password.equals(confirmPassword)) {
            errorMessage.setText("Password and confirm password doesn't match.");
            return;
        }
        String newID = "";
        String id = Application.customerList.getCustomerAt(Application.customerList.getSize() - 1).getId();
        id =id.replace("C","");
        int num = Integer.parseInt(id);
        num++;
        if(num < 10) {
            newID = "C00" + String.valueOf(num);
        } else if (num >= 10 & num < 100){
            newID = "C0" + String.valueOf(num);
        } else {
            newID = "C" + String.valueOf(num);
        }

        //check input and create new Item
        Customer customer = new GuestAccount(newID, name, address, phone, username, password, 0);
        Application.customerList.add(customer);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Register");
        alert.setHeaderText("Register successfully!");

        alert.showAndWait();

        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
