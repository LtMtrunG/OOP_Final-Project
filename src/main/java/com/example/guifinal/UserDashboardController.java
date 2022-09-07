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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserDashboardController implements Initializable {
    @FXML
    private Button homeButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button itemButton;
    @FXML
    private Button notificationButton;
    @FXML
    private StackPane contentArea;


    @FXML
    protected void onHomeButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: #F4F4FC");
        profileButton.setStyle("-fx-background-color: transparent");
        itemButton.setStyle("-fx-background-color: transparent");
        notificationButton.setStyle("-fx-background-color: transparent");
        Parent fxml = FXMLLoader.load(getClass().getResource("UserHome.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onProfileButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: transparent");
        profileButton.setStyle("-fx-background-color: #F4F4FC");
        itemButton.setStyle("-fx-background-color: transparent");
        notificationButton.setStyle("-fx-background-color: transparent");
        Parent fxml = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onItemButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: transparent");
        profileButton.setStyle("-fx-background-color: transparent");
        itemButton.setStyle("-fx-background-color: #F4F4FC");
        notificationButton.setStyle("-fx-background-color: transparent");
        Parent fxml = FXMLLoader.load(getClass().getResource("UserItem.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    protected void onNotificationButtonClick() throws IOException {
        homeButton.setStyle("-fx-background-color: transparent");
        profileButton.setStyle("-fx-background-color: transparent");
        itemButton.setStyle("-fx-background-color: transparent");
        notificationButton.setStyle("-fx-background-color: #F4F4FC");
        Parent fxml = FXMLLoader.load(getClass().getResource("UserNotification.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
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
            Parent fxml = FXMLLoader.load(getClass().getResource("UserHome.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException exception) {
        }
    }
}