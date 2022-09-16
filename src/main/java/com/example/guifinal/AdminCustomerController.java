package com.example.guifinal;

import com.example.guifinal.Customer.*;
import com.example.guifinal.Item.Item;
import com.example.guifinal.Item.ItemList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.AccessibleAction;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminCustomerController implements Initializable {
    public static Customer selectedCustomer;
    @FXML
    private TextField tfSearch;
    @FXML
    private ChoiceBox<String> cbCustomerType;
    @FXML
    private ChoiceBox<String> cbOrderBy;
    @FXML
    private TableView<Customer> customerTable;
    @FXML
    private TableColumn<Customer, String> idColumn;
    @FXML
    private TableColumn<Customer, String> nameColumn;
    @FXML
    private TableColumn<Customer, String> addressColumn;
    @FXML
    private TableColumn<Customer, String> phoneColumn;
    @FXML
    private TableColumn<Customer, Integer> successfulReturnColumn;

    ObservableList<Customer> data = FXCollections.observableArrayList(Application.customerList.getList());

    @FXML
    protected void onSearchButtonClick(ActionEvent event) {
        String search = tfSearch.getText().trim();
        CustomerList searchedList = new CustomerList();
        customerTable.getItems().clear();
        data.removeAll();

        for(Customer customer: Application.customerList.getList()){
            if(customer.getName().contains(search) || customer.getId().equals(search)){
                searchedList.add(customer);
            }
        }

        data =  FXCollections.observableArrayList(searchedList.getList());
        customerTable.setItems(data);
    }

    public void checkCustomerTypeComboBox() {
        CustomerList searchedList = new CustomerList();

        switch(cbCustomerType.getValue()){
            case "All":
                data.removeAll();
                data = FXCollections.observableArrayList(Application.customerList.getList());
                break;
            case "Guest Account":
                data.removeAll();
                for (Customer customer : Application.customerList.getList()) {
                    if (customer instanceof GuestAccount & !(customer instanceof RegularAccount) & !(customer instanceof VIPAccount)) {
                        searchedList.add(customer);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "Regular Account":
                data.removeAll();
                for (Customer customer : Application.customerList.getList()) {
                    if (customer instanceof RegularAccount & !(customer instanceof VIPAccount)) {
                        searchedList.add(customer);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "VIP Account":
                data.removeAll();
                for (Customer customer : Application.customerList.getList()) {
                    if (customer instanceof VIPAccount) {
                        searchedList.add(customer);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
        }
    }

    @FXML
    protected void onDisplayButtonClick() {
        ItemList searchedList = new ItemList();
        customerTable.getItems().clear();

        if(cbCustomerType.getValue() != null) {
            checkCustomerTypeComboBox();
            customerTable.setItems(data);
        }
    }

    @FXML
    protected void onViewRentalListClick() throws IOException {
        selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
        if(selectedCustomer != null){
            Parent fxml = FXMLLoader.load(getClass().getResource("ViewRentalListDialog.fxml"));
            Scene scene = new Scene(fxml, 800, 650);
            Stage stage = new Stage();
            stage.setTitle("Rental List");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");

            alert.setHeaderText("");
            alert.setContentText("You have not selected a customer");

            alert.showAndWait();
        }
    }

    @FXML
    protected void onSortButtonClick() {
        if(cbOrderBy.getValue().equals("Name")){
            Application.customerList.sortByNameOrTitle();
        } else {
            Application.customerList.sortByID();
        }
        customerTable.getItems().clear();
        data = FXCollections.observableArrayList(Application.customerList.getList());
        customerTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbCustomerType.getItems().addAll("All","Guest Account", "Regular Account", "VIP Account");
        cbOrderBy.getItems().addAll("Name","ID");

        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
        successfulReturnColumn.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("successfullyReturn"));

        customerTable.setItems(data);
    }

}
