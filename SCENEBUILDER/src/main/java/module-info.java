module com.example.scenebuilder {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.scenebuilder to javafx.fxml;
    exports com.example.scenebuilder;
}