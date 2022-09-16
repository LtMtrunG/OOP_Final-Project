package com.example.guifinal;

import com.example.guifinal.Item.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditItemDialogController implements Initializable {
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
    protected void onUpdateItemClick(ActionEvent e) {
        String title = tfTitle.getText().trim();
        float fee = Float.parseFloat(tfFee.getText().trim());
        int copies = Integer.parseInt(tfCopies.getText().trim());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Edit Item");
        alert.setHeaderText("Are you sure want to update this Item's attributes?");

        Optional<ButtonType> option = alert.showAndWait();


        if(option.get() == ButtonType.OK){
            AdminItemController.editItem.setTitle(title);
            AdminItemController.editItem.setRentalType(cbRentalType.getValue());
            AdminItemController.editItem.setLoanType(cbLoanType.getValue());
            AdminItemController.editItem.setGenre(cbGenre.getValue());
            AdminItemController.editItem.setFee(fee);
            AdminItemController.editItem.setCopy(copies);

            for(Item item : Application.itemList.getList()){
                if(item.getId().equals(AdminItemController.editItem.getId())){
                    item = AdminItemController.editItem;
                }
            }

            Alert alertMessage = new Alert(Alert.AlertType.INFORMATION);
            alertMessage.setTitle("Edit Item");

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
        cbRentalType.getItems().addAll("Record", "DVD", "Game");
        cbLoanType.getItems().addAll("1-week", "2-day");
        cbGenre.getItems().addAll("Action", "Comedy", "Drama", "Horror");

        tfTitle.setText(AdminItemController.editItem.getTitle());
        cbRentalType.setValue(AdminItemController.editItem.getRentalType());
        cbLoanType.setValue(AdminItemController.editItem.getLoanType());
        cbGenre.setValue(AdminItemController.editItem.getGenre());
        tfFee.setText(String.valueOf(AdminItemController.editItem.getFee()));
        tfCopies.setText(String.valueOf(AdminItemController.editItem.getCopy()));
    }
}
