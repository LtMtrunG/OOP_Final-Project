package com.example.guifinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {
    @FXML
    private BarChart<?,?> barChart;
    @FXML
    protected void onAddTaskButtonClick(ActionEvent e) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AddTaskDialog.fxml"));
        Scene scene = new Scene(fxml, 400, 260);
        Stage stage = new Stage();
        stage.setTitle("Add Task");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.showAndWait();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setBarChart();
    }
}
