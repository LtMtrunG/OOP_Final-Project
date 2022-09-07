package com.example.guifinal;

import SystemManagement.Customer.Customer;
import SystemManagement.Customer.CustomerList;
import SystemManagement.InputOutput.ReadCustomer;
import SystemManagement.Item.Item;
import SystemManagement.Item.ItemList;
import SystemManagement.InputOutput.ReadItem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;

public class Application extends javafx.application.Application {
    double x,y;
    public static ItemList itemList = new ItemList();
    public static CustomerList customerList = new CustomerList();

    public static void readFile() {
        itemList = ReadItem.readItemFile();
        System.out.println();
        for (Item item : itemList.getList()) {
            System.out.println(item.toString());
        }

        customerList = ReadCustomer.readCustomerFile();
        System.out.println();
        for (Customer customer : customerList.getList()) {
            System.out.println(customer.toString());
            System.out.println();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.initStyle(StageStyle.DECORATED);

        root.setOnMousePressed(e -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            stage.setX(e.getSceneX() - x);
            stage.setY(e.getSceneY() - y);
        });

        Scene scene = new Scene(root, 1320, 800);
        stage.setTitle("Jenny Video Store");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();
        readFile();
    }
}