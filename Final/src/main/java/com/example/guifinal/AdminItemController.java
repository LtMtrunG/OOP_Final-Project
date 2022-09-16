package com.example.guifinal;

import com.example.guifinal.Item.Item;
import com.example.guifinal.Item.ItemList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminItemController implements Initializable {
    public static Item editItem;
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
                    if (item.getCopy() > 0) {
                        searchedList.add(item);
                    }
                }
                data = FXCollections.observableArrayList(searchedList.getList());
                break;
            case "Out Of Stock":
                data.removeAll();
                for (Item item : Application.itemList.getList()) {
                    if (item.getCopy() == 0) {
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
            return;
        }
    }

    @FXML
    protected void onAddItemButtonClick() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AddItemDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 500);
        Stage stage = new Stage();
        stage.setTitle("Add New Item");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    protected void onEditButtonClick() throws IOException {
        editItem = itemTable.getSelectionModel().getSelectedItem();
        if(editItem != null) {
            Parent fxml = FXMLLoader.load(getClass().getResource("EditItemDialog.fxml"));
            Scene scene = new Scene(fxml, 400, 450);
            Stage stage = new Stage();
            stage.setTitle("Edit Item");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.showAndWait();

            itemTable.getItems().clear();
            data = FXCollections.observableArrayList(Application.itemList.getList());
            itemTable.setItems(data);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");

            alert.setHeaderText("");
            alert.setContentText("You have not selected an item to edit");

            alert.showAndWait();
        }
    }

    @FXML
    protected void onDeleteButtonClick(){
        Item selected = itemTable.getSelectionModel().getSelectedItem();
        if(selected != null) {
            Application.itemList.remove(selected);
            data.remove(selected);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Item");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Delete Item successfully!");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");

            alert.setHeaderText("");
            alert.setContentText("You have not selected an item to delete");

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
