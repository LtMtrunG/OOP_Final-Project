package com.example.guifinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {
    @FXML
    private StackPane adminContentArea;
    @FXML
    private Button homeButton;
    @FXML
    private Button customerButton;
    @FXML
    private Button itemButton;


    @FXML
    protected void onHomeButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: #F4F4FC");
        customerButton.setStyle("-fx-background-color: transparent");
        itemButton.setStyle("-fx-background-color: transparent");
        adminContentArea.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
        adminContentArea.getChildren().removeAll();
        adminContentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onCustomerButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: transparent");
        customerButton.setStyle("-fx-background-color: #F4F4FC");
        itemButton.setStyle("-fx-background-color: transparent");
        adminContentArea.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("AdminCustomer.fxml"));
        adminContentArea.getChildren().removeAll();
        adminContentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onItemButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: transparent");
        customerButton.setStyle("-fx-background-color: transparent");
        itemButton.setStyle("-fx-background-color: #F4F4FC");
        adminContentArea.getChildren().removeAll();
        Parent fxml = FXMLLoader.load(getClass().getResource("AdminItem.fxml"));
        adminContentArea.getChildren().removeAll();
        adminContentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onLogOutButtonClick(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxml, 1320, 800);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
            adminContentArea.getChildren().removeAll();
            adminContentArea.getChildren().setAll(fxml);
        } catch (IOException exception) {
        }
    }
}
