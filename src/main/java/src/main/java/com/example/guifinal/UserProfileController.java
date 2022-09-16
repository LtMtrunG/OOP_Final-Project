package com.example.guifinal;

import com.example.guifinal.Customer.GuestAccount;
import com.example.guifinal.Customer.RegularAccount;
import com.example.guifinal.Customer.VIPAccount;
import com.example.guifinal.Item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {
    public static int returnTime = 0;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label address;
    @FXML
    private Label phone;
    @FXML
    private Label username;
    @FXML
    private Label password;
    @FXML
    private Label accountType;
    @FXML
    private Label successfulReturn;
    @FXML
    private TableView<Item> rentalList;
    @FXML
    private TableColumn<Item, String> idColumn;
    @FXML
    private TableColumn<Item, String> titleColumn;
    @FXML
    private TableColumn<Item, String> rentalTypeColumn;
    @FXML
    private TableColumn<Item, String> loanTypeColumn;
    @FXML
    private TableColumn<Item, String> genreColumn;
    @FXML
    private TableColumn<Item, Float> feeColumn;

    ObservableList<Item> data = FXCollections.observableArrayList(LoginController.account.getRentalList());
    @FXML
    protected void onEditProfileButtonClick() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("EditProfileDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 360);
        Stage stage = new Stage();
        stage.setTitle("Edit Profile");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();

        name.setText(LoginController.account.getName());
        address.setText(LoginController.account.getAddress());
        phone.setText(LoginController.account.getPhone());
        username.setText(LoginController.account.getUsername());
        password.setText(LoginController.account.getPassword());
    }

    @FXML
    protected void onReturnButtonClick() {
        Item selected = rentalList.getSelectionModel().getSelectedItem();
        if(selected != null) {
            LoginController.account.getRentalList().remove(selected);
            data.remove(selected);

            for (Item item : Application.itemList.getList()) {
                if (item.getId().equals(selected.getId())) {
                    item.setCopy(item.getCopy() + 1);
                }
            }

            LoginController.account.setSuccessfullyReturn(LoginController.account.getSuccessfullyReturn() + 1);

            returnTime++;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Return Item");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Return Item successfully!");

            alert.showAndWait();

            successfulReturn.setText(String.valueOf(LoginController.account.getSuccessfullyReturn()));
            if(LoginController.account instanceof RegularAccount & LoginController.account.getSuccessfullyReturn() == 5){
                //reset the successful return
                LoginController.account.setSuccessfullyReturn(0);

                //promote, delete the unpromoted account from the list and add the promoted account ot the list
                VIPAccount vipAccount = ((RegularAccount) LoginController.account).promote();
                Application.customerList.remove(LoginController.account);
                Application.customerList.add(vipAccount);

                //change the current account to the promoted account
                LoginController.account = vipAccount;

                //display the new account type and successfully return
                accountType.setText("VIP Account");
                successfulReturn.setText(String.valueOf(LoginController.account.getSuccessfullyReturn()));
            } else if (LoginController.account instanceof GuestAccount & !(LoginController.account instanceof RegularAccount) & LoginController.account.getSuccessfullyReturn() == 3){
                //reset the successful return
                LoginController.account.setSuccessfullyReturn(0);

                //promote, delete the unpromoted account from the list and add the promoted account ot the list
                RegularAccount regularAccount = ((GuestAccount) LoginController.account).promote();
                Application.customerList.remove(LoginController.account);
                Application.customerList.add(regularAccount);

                //change the current account to the promoted account
                LoginController.account = regularAccount;

                //display the new account type and successfully return
                accountType.setText("Regular Account");
                successfulReturn.setText(String.valueOf(LoginController.account.getSuccessfullyReturn()));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");

            alert.setHeaderText("");
            alert.setContentText("You have not selected an item to return");

            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setText(LoginController.account.getId());
        name.setText(LoginController.account.getName());
        address.setText(LoginController.account.getAddress());
        phone.setText(LoginController.account.getPhone());
        username.setText(LoginController.account.getUsername());
        password.setText(LoginController.account.getPassword());
        successfulReturn.setText(String.valueOf(LoginController.account.getSuccessfullyReturn()));
        if(LoginController.account instanceof VIPAccount){
            accountType.setText("VIP Account");
        } else if(LoginController.account instanceof RegularAccount) {
            accountType.setText("Regular Account");
        } else{
            accountType.setText("Guest Account");
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        rentalTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("rentalType"));
        loanTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("loanType"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("genre"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Item, Float>("fee"));

        rentalList.setItems(data);
    }
}
