module com.example.baitaplonoop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;

    opens com.example.baitaplonoop to javafx.fxml;
    exports com.example.baitaplonoop;
}