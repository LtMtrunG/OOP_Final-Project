package com.example.guifinal;

import com.example.guifinal.Item.Item;
import com.example.guifinal.Task.Task;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {
    public static ArrayList<Task> taskList = new ArrayList<>();
    private static boolean firstTime = true;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> deadlineColumn;
    @FXML
    private TableColumn<Task, String> taskColumn;
    @FXML
    private TableColumn<Task, String> doneColumn;
    @FXML
    private Label inStock;
    @FXML
    private Label OOS; //out of stock
    @FXML
    private Label todayRent;
    @FXML
    private Label todayReturn;
    @FXML
    private BarChart<?,?> barChart;

    ObservableList<Task> data = FXCollections.observableArrayList();

    @FXML
    protected void onAddTaskButtonClick(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AddTaskDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 300);
        Stage stage = new Stage();
        stage.setTitle("Add Task");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();

        taskTable.getItems().clear();
        data = FXCollections.observableArrayList(taskList);
        taskTable.setItems(data);
    }

    @FXML
    protected void onRemoveDoneTaskButtonClick() {
        taskList.removeIf(task -> task.getCheckBox().isSelected());

        taskTable.getItems().clear();
        data = FXCollections.observableArrayList(taskList);
        taskTable.setItems(data);
    }

    private void setBarChart() {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Renting Item");
        series1.getData().addAll(new XYChart.Data("Monday", 8),
                                new XYChart.Data("Tuesday", 10),
                                new XYChart.Data("Wednesday", 12),
                                new XYChart.Data("Thursday", 7),
                                new XYChart.Data("Friday", 19),
                                new XYChart.Data("Saturday", 15),
                                new XYChart.Data("Sunday", 10));
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Returned Item");
        series2.getData().addAll(new XYChart.Data("Monday", 8),
                new XYChart.Data("Tuesday", 13),
                new XYChart.Data("Wednesday", 2),
                new XYChart.Data("Thursday", 5),
                new XYChart.Data("Friday", 22 ),
                new XYChart.Data("Saturday", 0),
                new XYChart.Data("Sunday", 18));
        barChart.getData().addAll(series1, series2);
    }

    private int countInStock(){
        int total = 0;
        for(Item item : Application.itemList.getList()){
            total += item.getCopy();
        }
        return total;
    }

    private int countOOS(){
        int total = 0;
        for(Item item : Application.itemList.getList()){
            if(item.getCopy() == 0) {
                total += item.getCopy();
            }
        }
        return total;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setBarChart();
        inStock.setText(String.valueOf(countInStock()));
        OOS.setText(String.valueOf(countOOS()));
        todayRent.setText(String.valueOf(UserItemController.rentTime));
        todayReturn.setText(String.valueOf(UserProfileController.returnTime));

        if(firstTime) {
            taskList.add(new Task("9/18/2022", "Final Project Submission"));
            data = FXCollections.observableArrayList(taskList);
            firstTime = false;
        }

        deadlineColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("deadline"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("task"));
        doneColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("checkBox"));

        taskTable.setItems(data);
    }
}
