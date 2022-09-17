package com.example.guifinal;

import com.example.guifinal.Customer.Customer;
import com.example.guifinal.Customer.GuestAccount;
import com.example.guifinal.Customer.RegularAccount;
import com.example.guifinal.Customer.VIPAccount;
import com.example.guifinal.Item.ItemList;
import com.example.guifinal.Item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserItemController implements Initializable {
    public static int rentTime = 0;
    @FXML
    private TextField tfSearch;
    @FXML
    private ChoiceBox<String> cbRentalType;
    @FXML
    private ChoiceBox<String> cbOrderBy;
    @FXML
    private ChoiceBox<String> cbStatus;
    @FXML
    private TableView<Item> itemTable;
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
    @FXML
    private TableColumn<Item, Integer> copiesColumn;

    ObservableList<Item> data = FXCollections.observableArrayList(Application.itemList.getList());

    @FXML
    protected void onSearchButtonClick(ActionEvent event) {
        String search = tfSearch.getText().trim();
        ItemList searchedList = new ItemList();
        itemTable.getItems().clear();
        data.removeAll();

        for(Item item: Application.itemList.getList()){
            if(item.getTitle().contains(search) || item.getId().equals(search)){
                searchedList.add(item);
            }
        }

        data =  FXCollections.observableArrayList(searchedList.getList());
        itemTable.setItems(data);
    }

    public void checkRentalTypeComboBox() {
        ItemList searchedList = new ItemList();

        switch (cbRentalType.getValue()) {
            case "All":
                data.removeAll();
                data = FXCollections.observableArrayList(Application.itemList.getList());
                break;
            case "Record":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (item.getRentalType().equals("Record")) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "DVD":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (item.getRentalType().equals("DVD")) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "Game":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (item.getRentalType().equals("Game")) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
        }
    }

    public void checkStatusComboBox() {
        ItemList searchedList = new ItemList();

        switch (cbStatus.getValue()) {
            case "All":
                data.removeAll();
                data = FXCollections.observableArrayList(Application.itemList.getList());
                break;
            case "Available":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (item.isStatus()) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "Out Of Stock":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (!item.isStatus()) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
        }
    }

    @FXML
    protected void onDisplayButtonClick() {
        ItemList searchedList = new ItemList();
        itemTable.getItems().clear();

         if(cbRentalType.getValue() != null) {
             checkRentalTypeComboBox();
             itemTable.setItems(data);
             return;
         }

         if(cbStatus.getValue() != null){
             checkStatusComboBox();
             itemTable.setItems(data);
         }
    }

    @FXML
    protected void onRentItemClick() {
        Item selected = itemTable.getSelectionModel().getSelectedItem();
        if(selected != null) {
            //check if the customer is Guest Account(Guest account can only rent 2 items at a time)
            if(LoginController.account instanceof GuestAccount & LoginController.account.getRentalList().size() == 2 & !(LoginController.account instanceof RegularAccount) & !(LoginController.account instanceof VIPAccount)){
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Error");

                alertError.setHeaderText(null);
                alertError.setContentText("Guest Account can rent maximum 2 items at a time");

                alertError.showAndWait();
                return;
            }

            if(LoginController.account instanceof GuestAccount & selected.getLoanType().equals("2-day") & !(LoginController.account instanceof RegularAccount) & !(LoginController.account instanceof VIPAccount)){
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Error");

                alertError.setHeaderText(null);
                alertError.setContentText("Guest Account can not rent a 2-day loan type item");

                alertError.showAndWait();
                return;
            }

            for (Item item : Application.itemList.getList()) {
                if (item.getId().equals(selected.getId())) {
                    if (item.getCopy() == 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Rent Item");

                        // Header Text: null
                        alert.setHeaderText(null);
                        alert.setContentText("This item is out of stock! Please rent another one");

                        alert.showAndWait();
                    } else {
                        item.setCopy(item.getCopy() - 1);
                        LoginController.account.getRentalList().add(item);

                        rentTime++;

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                        //if the user is VIP account and have 10 or more successfully return time.
                        if(LoginController.account instanceof VIPAccount & LoginController.account.getSuccessfullyReturn() >= 10){
                            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                            alert1.setTitle("Free Rent");

                            // Header Text: null
                            alert1.setHeaderText(null);
                            alert1.setContentText("You have earned 100 reward points or more. Do you want to change the reward point for a free rent?");

                            Optional<ButtonType> option = alert1.showAndWait();

                            if(option.get() == ButtonType.OK){
                                LoginController.account.setSuccessfullyReturn(((VIPAccount) LoginController.account).getSuccessfullyReturn() - 10);
                                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                alert2.setTitle("Rent Item");

                                // Header Text: null
                                alert2.setHeaderText(null);
                                alert2.setContentText("Successfully rent item for free!");

                                alert2.showAndWait();

                                itemTable.getItems().clear();
                                data = FXCollections.observableArrayList(Application.itemList.getList());
                                itemTable.setItems(data);
                                return;
                            } else if (option.get() == ButtonType.CANCEL) {
                                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Rent Item");

                                // Header Text: null
                                alert2.setHeaderText(null);
                                alert2.setContentText("Rent Item successful!");

                                alert2.showAndWait();

                                itemTable.getItems().clear();
                                data = FXCollections.observableArrayList(Application.itemList.getList());
                                itemTable.setItems(data);
                                return;
                            } else {
                                return;
                            }
                        }

                        alert.setTitle("Rent Item");

                        // Header Text: null
                        alert.setHeaderText(null);
                        alert.setContentText("Rent Item successfully!");

                        alert.showAndWait();

                        itemTable.getItems().clear();
                        data = FXCollections.observableArrayList(Application.itemList.getList());
                        itemTable.setItems(data);
                    }
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");

            alert.setHeaderText("");
            alert.setContentText("You have not selected an item to rent");

            alert.showAndWait();
        }
    }

    @FXML
    protected void onSortButtonClick() {
        if(cbOrderBy.getValue().equals("Title")){
            Application.itemList.sortByNameOrTitle();
        } else {
            Application.itemList.sortByID();
        }
        itemTable.getItems().clear();
        data = FXCollections.observableArrayList(Application.itemList.getList());
        itemTable.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbRentalType.getItems().addAll("All","Record", "DVD","Game");
        cbStatus.getItems().addAll("All","Available", "Out of Stock");
        cbOrderBy.getItems().addAll("Title","ID");

        idColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("title"));
        rentalTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("rentalType"));
        loanTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("loanType"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("genre"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Item, Float>("fee"));
        copiesColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("copy"));

        itemTable.setItems(data);
    }
}
