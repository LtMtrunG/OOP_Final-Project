package com.example.guifinal;

import SystemManagement.Item.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemDialogController implements Initializable {
    @FXML
    private TextField tfID;

    @FXML
    private TextField tfTitle;
    @FXML
    private ChoiceBox<String> cbRentalType;
    @FXML
    private ChoiceBox<String> cbLoanType;
    @FXML
    private ChoiceBox<String> cbGenre;
    @FXML
    private TextField tfFee;

    @FXML
    private TextField tfCopies;

    @FXML
    protected void onAddButtonClick(ActionEvent e) {
        //get input
        String id = tfID.getText().trim();
        String title = tfTitle.getText().trim();
        float fee = Float.parseFloat(tfFee.getText().trim());
        int copies = Integer.parseInt(tfCopies.getText().trim());

        //check input and create new Item
        Item item = new Item();

        //update the file

        //close dialog box
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbRentalType.getItems().addAll("Record", "DVD", "Game");
        cbLoanType.getItems().addAll("1-week", "2-day");
        cbGenre.getItems().addAll("Action", "Horror", "Drama", "Comedy");
    }
}
