package com.example.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;

public class HelloApplication extends Application {
    public Scene createStartScene(Stage stage){
        VBox vbox = new VBox(10);
        vbox.setBackground(Background.fill(Color.BLACK));
        Scene startScene = new Scene(vbox, 1000, 600);

        //text
        Text welcomeText = new Text("Welcome to Jenny Video Store");
        welcomeText.setFill(Color.WHITE);
        welcomeText.setFont(new Font("",50));

        //buttons
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());

        //add the roots to the scene
        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(startButton, exitButton);
        hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(welcomeText, hbox);
        vbox.setAlignment(Pos.CENTER);

        return startScene;
    }


    public Scene createMenuScene(Stage stage){
        VBox vbox1 = new VBox(30);
        vbox1.setBackground(Background.fill(Color.BLACK));
        Scene menuScene = new Scene(vbox1, 1000, 600);

        //text
        Text text = new Text("Video store");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));

        //Modify Item Function
        Rectangle itemRect = new Rectangle(150,150);
        itemRect.setFill(Color.LIGHTGRAY);
        itemRect.setStrokeWidth(2);
        itemRect.setStroke(Color.LIGHTCYAN);
        itemRect.setOnMouseClicked(e -> stage.setScene(createModifyItemScene(stage)));

        Text itemText = new Text("Modify Item");
        itemText.setFont(new Font(16));
        itemText.setFill(Color.DARKCYAN);

        StackPane modifyItem = new StackPane(itemRect, itemText);
        modifyItem.setAlignment(Pos.BOTTOM_CENTER);

        //Modify Customer Function
        Rectangle customerRect = new Rectangle(150,150);
        customerRect.setFill(Color.LIGHTGRAY);
        customerRect.setStrokeWidth(2);
        customerRect.setStroke(Color.LIGHTCYAN);
        customerRect.setOnMouseClicked(e -> stage.setScene(createModifyCustomerScene(stage)));

        Text customerText = new Text("Modify Customer");
        customerText.setFont(new Font(16));
        customerText.setFill(Color.DARKCYAN);

        StackPane modifyCustomer = new StackPane(customerRect, customerText);
        modifyCustomer.setAlignment(Pos.BOTTOM_CENTER);

        //Promote Customer Function
        Rectangle promoteRect = new Rectangle(150,150);
        promoteRect.setFill(Color.LIGHTGRAY);
        promoteRect.setStrokeWidth(2);
        promoteRect.setStroke(Color.LIGHTCYAN);
        promoteRect.setOnMouseClicked(e -> stage.setScene(createPromoteScene(stage)));

        Text promoteText = new Text("Promote Customer");
        promoteText.setFont(new Font(16));
        promoteText.setFill(Color.DARKCYAN);

        StackPane promoteCustomer = new StackPane(promoteRect, promoteText);
        promoteCustomer.setAlignment(Pos.BOTTOM_CENTER);

        //Rent Item Function
        Rectangle rentRect = new Rectangle(150,150);
        rentRect.setFill(Color.LIGHTGRAY);
        rentRect.setStrokeWidth(2);
        rentRect.setStroke(Color.LIGHTCYAN);
        rentRect.setOnMouseClicked(e ->stage.setScene(createRentScene(stage)));

        Text rentText = new Text("Rent an Item");
        rentText.setFont(new Font(16));
        rentText.setFill(Color.DARKCYAN);

        StackPane rentItem = new StackPane(rentRect, rentText);
        rentItem.setAlignment(Pos.BOTTOM_CENTER);

        //Return Item Function
        Rectangle returnRect = new Rectangle(150,150);
        returnRect.setFill(Color.LIGHTGRAY);
        returnRect.setStrokeWidth(2);
        returnRect.setStroke(Color.LIGHTCYAN);
        returnRect.setOnMouseClicked(e -> stage.setScene(createReturnScene(stage)));

        Text returnText = new Text("Return an Item");
        returnText.setFont(new Font(16));
        returnText.setFill(Color.DARKCYAN);

        StackPane returnItem = new StackPane(returnRect, returnText);
        returnItem.setAlignment(Pos.BOTTOM_CENTER);

        //First Line of Function
        HBox firstFunctionLine = new HBox(20, modifyItem, modifyCustomer, promoteCustomer, rentItem, returnItem);
        firstFunctionLine.setAlignment(Pos.CENTER);

        //Display All Items Function
        Rectangle allItemRect = new Rectangle(150,150);
        allItemRect.setFill(Color.LIGHTGRAY);
        allItemRect.setStrokeWidth(2);
        allItemRect.setStroke(Color.LIGHTCYAN);
        allItemRect.setOnMouseClicked(e -> stage.setScene(createDisplayItemScene(stage)));

        Text allItemText = new Text("Items");
        allItemText.setFont(new Font(16));
        allItemText.setFill(Color.DARKCYAN);

        StackPane allItem = new StackPane(allItemRect, allItemText);
        allItem.setAlignment(Pos.BOTTOM_CENTER);

        //Display Out-Of-Stock Items Function
        Rectangle oosItemRect = new Rectangle(150,150);
        oosItemRect.setFill(Color.LIGHTGRAY);
        oosItemRect.setStrokeWidth(2);
        oosItemRect.setStroke(Color.LIGHTCYAN);
        oosItemRect.setOnMouseClicked(e -> stage.setScene(createOutOfStockScene(stage)));

        Text oosItemText = new Text("Out-of-stock Items");
        oosItemText.setFont(new Font(16));
        oosItemText.setFill(Color.DARKCYAN);

        StackPane oosItem = new StackPane(oosItemRect, oosItemText);
        oosItem.setAlignment(Pos.BOTTOM_CENTER);

        //Display All Customers Function
        Rectangle allCustomerRect = new Rectangle(150,150);
        allCustomerRect.setFill(Color.LIGHTGRAY);
        allCustomerRect.setStrokeWidth(2);
        allCustomerRect.setStroke(Color.LIGHTCYAN);
        allCustomerRect.setOnMouseClicked(e -> stage.setScene(createDisplayCustomerScene(stage)));

        Text allCustomerText = new Text("Customers");
        allCustomerText.setFont(new Font(16));
        allCustomerText.setFill(Color.DARKCYAN);

        StackPane allCustomer = new StackPane(allCustomerRect, allCustomerText);
        allCustomer.setAlignment(Pos.BOTTOM_CENTER);

        //Display Group of Customers Function
        Rectangle groupCustomerRect = new Rectangle(150,150);
        groupCustomerRect.setFill(Color.LIGHTGRAY);
        groupCustomerRect.setStrokeWidth(2);
        groupCustomerRect.setStroke(Color.LIGHTCYAN);
        groupCustomerRect.setOnMouseClicked(e -> stage.setScene(createGroupCustomerScene(stage)));

        Text groupCustomerText = new Text("Customers by Group");
        groupCustomerText.setFont(new Font(16));
        groupCustomerText.setFill(Color.DARKCYAN);

        StackPane groupCustomer = new StackPane(groupCustomerRect, groupCustomerText);
        groupCustomer.setAlignment(Pos.BOTTOM_CENTER);

        //Search Functions
        Rectangle searchRect = new Rectangle(150,150);
        searchRect.setFill(Color.LIGHTGRAY);
        searchRect.setStrokeWidth(2);
        searchRect.setStroke(Color.LIGHTCYAN);
        searchRect.setOnMouseClicked(e -> stage.setScene(createSearchScene(stage)));

        Text searchText = new Text("Search");
        searchText.setFont(new Font(16));
        searchText.setFill(Color.DARKCYAN);

        StackPane search = new StackPane(searchRect, searchText);
        search.setAlignment(Pos.BOTTOM_CENTER);

        //Second Line of Functions
        HBox secondFunctionLine = new HBox(20, allItem, oosItem, allCustomer, groupCustomer, search);
        secondFunctionLine.setAlignment(Pos.CENTER);

        //add the text, first line and second line of functions into the pane
        vbox1.getChildren().addAll(text, firstFunctionLine, secondFunctionLine);
        vbox1.setAlignment(Pos.CENTER);

        return menuScene;
    }


    public Scene createModifyItemScene(Stage stage){
        VBox vbox1 = new VBox();
        vbox1.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(vbox1, 1000, 600);

        //buttons
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));

        Button displayButton = new Button("Display All Items");
        displayButton.setOnAction(e -> AlertBox.displayItem());

        //text
        Text text = new Text("Modify Item");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));

        //Text field
        TextField textField = new TextField();
        textField.setPromptText("Item");
        textField.setPrefWidth(300);
        Button searchButton = new Button("Search"); //search button of the text field

        HBox searchField = new HBox(textField, searchButton);
        searchField.setAlignment(Pos.CENTER_RIGHT);

        //Combo box
        ComboBox<String> comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll(
                "Add a New Item",
                "Update an Existing Item",
                "Delete an Existing Item"
        );
        comboBox1.setPromptText("-Choose an Option-");

        //display option combo box, search field and display all item button horizontally
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(comboBox1, searchField, displayButton);
        hbox.setAlignment(Pos.CENTER);

        //display the text vertically with the horizontal box above
        VBox vbox2 = new VBox(30,text, hbox);
        vbox2.setAlignment(Pos.CENTER);

        //option combo box action
        comboBox1.setOnAction(e -> {
            switch (comboBox1.getValue()){
                //create new item
                case "Add a New Item":
                    textField.setText("Creating new Item");
                    Text text2 = new Text("New Item ");
                    text2.setFont(new Font("", 30));
                    text2.setFill(Color.WHITE);

                    //item ID
                    TextField textField2 = new TextField();
                    textField2.setPromptText("Item ID");
                    textField2.setMaxWidth(380);

                    //item title
                    TextField textField3 = new TextField();
                    textField3.setPromptText("Item Title");
                    textField3.setMaxWidth(380);

                    //item rental type
                    ComboBox<String> comboBox2 = new ComboBox<>();
                    comboBox2.setMinWidth(380);
                    comboBox2.setPromptText("-Select Rental Type-");
                    comboBox2.getItems().addAll(
                            "DVD",
                            "Record Video",
                            "Game"
                    );

                    //item gender
                    ComboBox<String> comboBox3 = new ComboBox<>();
                    comboBox3.setMinWidth(380);
                    comboBox3.setPromptText("-Select Gender-");
                    comboBox3.getItems().addAll(
                            "Action",
                            "Horror",
                            "Drama",
                            "Comedy"
                    );

                    //item loan type
                    ComboBox<String> comboBox4 = new ComboBox<>();
                    comboBox4.setMaxWidth(380);
                    comboBox4.setPromptText("-Select Loan Type-");
                    comboBox4.getItems().addAll(
                            "2-day",
                            "1-week"
                    );

                    //number of copies of the item
                    TextField textField5 = new TextField();
                    textField5.setPromptText("Number of copies");
                    textField5.setMaxWidth(380);

                    //rental fee of the item
                    TextField textField6 = new TextField();
                    textField6.setPromptText("Rental fee");
                    textField6.setMaxWidth(380);

                    //add all the attribute of the item to a vertical box
                    VBox vbox3 = new VBox(10);
                    vbox3.getChildren().addAll(text2,textField2, textField3, comboBox2, comboBox3, comboBox4,textField5, textField6);
                    vbox3.setAlignment(Pos.TOP_CENTER);

                    //Add button
                    Button addButton = new Button("ADD");
                    addButton.setFont(Font.font("", FontWeight.BOLD, 30));
                    addButton.setMinSize(200, 60);
                    addButton.setOnAction(event -> AlertBox.successfullyMessage("Add a New Item", "You have successfully added a new item."));

                    vbox2.getChildren().addAll(vbox3, addButton);
                    break;
                case "Update an Existing Item":
                    textField.setPromptText("Enter an Item's ID or Title");
                    textField.setText("");

                    ComboBox<String> comboBox5 = new ComboBox<>();
                    comboBox5.setMinWidth(380);
                    comboBox5.setPromptText("-Select an attribute to update");
                    comboBox5.getItems().addAll(
                            "ID",
                            "Title",
                            "Rental Type",
                            "Loan Type",
                            "Number of copies",
                            "Rental fee"
                    );

                    TextField textField7 = new TextField();
                    textField7.setPromptText("Enter New Attribute's Content");
                    textField7.setMaxWidth(380);

                    VBox vbox4 = new VBox(10);
                    vbox4.getChildren().addAll(comboBox5, textField7);
                    vbox4.setAlignment(Pos.CENTER);

                    //Update button
                    Button updateButton = new Button("Update");
                    updateButton.setFont(Font.font("", FontWeight.BOLD, 30));
                    updateButton.setMinSize(200, 60);
                    updateButton.setOnAction(event -> AlertBox.successfullyMessage("Update an existing Item", "You have successfully updated the item."));

                    vbox2.getChildren().addAll(vbox4, updateButton);
                    break;
                case "Delete an Existing Item":
                    textField.setPromptText("Enter an Item's ID or Title");
                    textField.setText("");

                    //Delete button
                    Button deleteButton = new Button("Delete");
                    deleteButton.setFont(Font.font("", FontWeight.BOLD, 30));
                    deleteButton.setMinSize(200, 60);
                    deleteButton.setOnMousePressed(event -> AlertBox.warningMessage("Delete an Existing Item", "Do you want to delete this item?"));

                    vbox2.getChildren().add(deleteButton);
                    break;
            }
        });
        vbox1.getChildren().addAll(backButton,vbox2);
        return scene;
    }
    public Scene createModifyCustomerScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Modify Customer");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createPromoteScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);

        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Promote an Existing Customer");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createRentScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Rent an Item");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createReturnScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Return an Item");

        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createDisplayItemScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);

        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));

        //text
        Text text = new Text("Display all Items");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createOutOfStockScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Display Out-of-stock Items");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;

    }
    public Scene createDisplayCustomerScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Display All Customers");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createGroupCustomerScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);
        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Display Group of Customers");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }
    public Scene createSearchScene(Stage stage){
        VBox pane = new VBox();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 1000, 600);

        //button
        Button backButton = new Button("<<-");
        backButton.setOnAction(e -> stage.setScene(createMenuScene(stage)));
        //text
        Text text = new Text("Search");
        text.setFill(Color.WHITE);
        text.setFont(new Font("",50));
        HBox hbox = new HBox(text);
        hbox.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(backButton,hbox);
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Video Store");
        stage.setResizable(false);
        stage.setScene(createStartScene(stage));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
class AlertBox {
    public static void displayItem() {
        Stage alertBox = new Stage();
        alertBox.initModality(Modality.APPLICATION_MODAL);
        alertBox.setTitle("Display all the item");

        Pane pane = new Pane();
        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(pane, 600, 400);
        alertBox.setScene(scene);
        alertBox.showAndWait();
    }

    public static void warningMessage(String title, String message) {
        Stage alertBox = new Stage();
        alertBox.initModality(Modality.APPLICATION_MODAL);
        alertBox.setTitle(title);

        VBox vbox = new VBox();
        vbox.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(vbox, 400, 60);

        Text text = new Text(message);
        text.setFont(new Font("", 20));
        text.setFill(Color.WHITE);

        Button yesButton = new Button("Yes");
        yesButton.setOnAction(e -> {
            AlertBox.successfullyMessage("Delete an Existing Item", "You have successfully deleted the item.");
            alertBox.close();
        });

        Button noButton = new Button("No");
        noButton.setOnAction(e -> alertBox.close());

        HBox hbox = new HBox(50);
        hbox.getChildren().addAll(yesButton, noButton);
        hbox.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(text, hbox);
        vbox.setAlignment(Pos.CENTER);

        alertBox.setScene(scene);
        alertBox.showAndWait();
    }

    public static void successfullyMessage(String title, String message){
        Stage alertBox = new Stage();
        alertBox.initModality(Modality.APPLICATION_MODAL);
        alertBox.setTitle(title);

        VBox vbox = new VBox();
        vbox.setBackground(Background.fill(Color.BLACK));
        Scene scene = new Scene(vbox, 400, 60);

        Text text = new Text(message);
        text.setFont(new Font("", 20));
        text.setFill(Color.WHITE);

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> alertBox.close());

        vbox.getChildren().addAll(text, okButton);
        vbox.setAlignment(Pos.CENTER);

        alertBox.setScene(scene);
        alertBox.showAndWait();
    }

}

//Modify Item: multiple options are chosen?