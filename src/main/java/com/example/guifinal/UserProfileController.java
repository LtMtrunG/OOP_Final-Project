package com.example.guifinal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController implements Initializable {
    @FXML
    protected void onEditProfileButtonClick() throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("EditProfileDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 350);
        Stage stage = new Stage();
        stage.setTitle("Edit Profile");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //how to write the customer's attributes
    }
}
