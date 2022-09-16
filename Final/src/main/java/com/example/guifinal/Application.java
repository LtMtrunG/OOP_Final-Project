package com.example.guifinal;

import com.example.guifinal.Customer.CustomerList;
import com.example.guifinal.InputOutput.Functions;
import com.example.guifinal.Item.ItemList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Application extends javafx.application.Application {
    double x,y;
    public static ItemList itemList = new ItemList();
    public static CustomerList customerList = new CustomerList();

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.initStyle(StageStyle.DECORATED);

        //Convert to Thread - remove checking
        itemList = Functions.readItemListFile();
        customerList = Functions.readCustomerListFile();

        Scene scene = new Scene(root, 1320, 800);
        stage.setTitle("Jenny Video Store");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
    }

    @FXML
    private void closeWindowEvent(WindowEvent event) {
        Functions.saveFiles(itemList, customerList);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Exit");

        alert.setHeaderText(null);
        alert.setContentText("Thank you for using our program");

        alert.show();
    }


    public static void main(String[] args) {
        launch();

    }
}

