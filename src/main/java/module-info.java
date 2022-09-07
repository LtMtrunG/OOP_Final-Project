module com.example.guifinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.guifinal to javafx.fxml;
    exports com.example.guifinal;
}