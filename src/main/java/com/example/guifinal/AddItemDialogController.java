package com.example.guifinal;

import com.example.guifinal.Item.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddItemDialogController implements Initializable {
    @FXML
    private Label errorMessage;
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

    public boolean checkId(String id){
        if (id.charAt(0) != 'I') {
            return false;
        }
        if (!Character.isDigit(id.charAt(1)) && !Character.isDigit(id.charAt(2)) && !Character.isDigit(id.charAt(3))) {
            return false;
        }
        if (id.charAt(4) != '-') {
            return false;
        }
        if (!Character.isDigit(id.charAt(5)) && !Character.isDigit(id.charAt(6)) && !Character.isDigit(id.charAt(7)) && !Character.isDigit(id.charAt(8))) {
            return false;
        }
        return true;
    }


    @FXML
    protected void onAddButtonClick(ActionEvent event) {
        try {
            //get input
            String id = tfID.getText().trim();
            String title = tfTitle.getText().trim();
            float fee = Float.parseFloat(tfFee.getText().trim());
            int copies = Integer.parseInt(tfCopies.getText().trim());

            if (id.charAt(0) != 'I') {
                errorMessage.setText("Invalid Item'sID");
                return;
            }
            if (!Character.isDigit(id.charAt(1)) && !Character.isDigit(id.charAt(2)) && !Character.isDigit(id.charAt(3))) {
                errorMessage.setText("Invalid Item'sID");
                return;
            }
            if (id.charAt(4) != '-') {
                errorMessage.setText("Invalid Item'sID");
                return;
            }
            if (!Character.isDigit(id.charAt(5)) && !Character.isDigit(id.charAt(6)) && !Character.isDigit(id.charAt(7)) && !Character.isDigit(id.charAt(8))) {
                errorMessage.setText("Invalid Item'sID");
                return;
            }

            for (Item item : Application.itemList.getList()) {
                if (item.getId().equals(id)) {
                    errorMessage.setText("This item is already on the list.");
                    return;
                }
            }

            //check input and create new Item
            if (cbRentalType.equals("Game")) {
                cbGenre.disabledProperty();
                Item item = new Item(id, title, cbRentalType.getValue(), "", cbLoanType.getValue(), copies, fee);
                Application.itemList.add(item);
            } else {
                Item item = new Item(id, title, cbRentalType.getValue(), cbGenre.getValue(), cbLoanType.getValue(), copies, fee);
                Application.itemList.add(item);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add New Item");
            alert.setHeaderText("Add New Item successfully!");

            alert.showAndWait();

            //close dialog box
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
        catch (NumberFormatException e){
            errorMessage.setText("Invalid input format");
        }
        catch (NullPointerException e) {
            errorMessage.setText("Missing input");
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbRentalType.getItems().addAll("Record", "DVD", "Game");
        cbLoanType.getItems().addAll("1-week", "2-day");
        cbGenre.getItems().addAll("Action", "Horror", "Drama", "Comedy");
    }
}
