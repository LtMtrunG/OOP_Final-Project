package com.example.guifinal.Task;

import com.example.guifinal.AdminHomeController;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Date;

public class Task {
    private String deadline;
    private String task;
    private CheckBox checkBox;

    public Task(){}
    public Task(String deadline, String task){
        this.deadline = deadline;
        this.task = task;
        this.checkBox = new CheckBox();
        this.checkBox.setPadding(new Insets(0,0,0,8));
    }

    public String getDeadline() {
        return deadline;
    }

    //0123456789
    //2022-09-18
    public void setDeadline(String deadline) {
        String formatted = String.valueOf(deadline.charAt(8)) + deadline.charAt(9) + "/" + deadline.charAt(5) + deadline.charAt(6) + "/" + deadline.charAt(0) + deadline.charAt(1) + deadline.charAt(2) + deadline.charAt(3);

        this.deadline = formatted;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
