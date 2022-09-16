package com.example.guifinal;

import com.example.guifinal.Customer.GuestAccount;
import com.example.guifinal.Customer.VIPAccount;
import com.example.guifinal.Item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewRentalListDialogController implements Initializable {
    @FXML
    private Label accountType;
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
    private TableColumn<Item, Integer> feeColumn;
    @FXML
    private TableColumn<Item, String> genreColumn;

    ObservableList<Item> data = FXCollections.observableArrayList(AdminCustomerController.selectedCustomer.getRentalList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(AdminCustomerController.selectedCustomer instanceof VIPAccount){
            accountType.setText("VIP Account");
        } else if (AdminCustomerController.selectedCustomer instanceof GuestAccount) {
            accountType.setText("Regular Account");
        } else {
            accountType.setText("Guest Account");
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        rentalTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("rentalType"));
        loanTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("loanType"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("fee"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Item,String>("genre"));

        rentalList.setItems(data);
    }
}
